package com.kontron.snmp.example;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.text.*;
import java.util.*;

import com.kontron.snmp.example.agent.FmAlarmEntryRow;
import com.kontron.snmp.example.agent.FmAlarmMib;
import org.snmp4j.*;
import org.snmp4j.agent.*;
import org.snmp4j.agent.io.*;
import org.snmp4j.agent.io.prop.*;
import org.snmp4j.agent.mo.*;
import org.snmp4j.agent.mo.snmp.SNMPv2MIB;
import org.snmp4j.agent.mo.snmp.dh.DHKickstartParameters;
import org.snmp4j.agent.mo.snmp.dh.DHKickstartParametersImpl;
import org.snmp4j.cfg.EngineBootsCounterFile;
import org.snmp4j.cfg.EngineBootsProvider;
import org.snmp4j.log.*;
import org.snmp4j.mp.*;
import org.snmp4j.security.SecurityModels;
import org.snmp4j.smi.*;
import org.snmp4j.transport.*;
import org.snmp4j.util.*;
import org.snmp4j.security.SecurityProtocols;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import javax.crypto.Cipher;

/**
 * The SampleAgent uses an {@link AgentConfigManager} instance to create a minimal SNMP agent using the configuration
 * defined by {@code SampleAgentConfig.properties} in this package. That properties file defines the initial content of
 * the registered MIB objects of this agent which may differ from the hard coded defaults.
 * <p>
 * In order to add a new MIB object, call {@code server.register(..)} or replace the {@code Modules.java} file in this
 * package by the {@code Modules.java} generated by AgenPro for your MIB module(s).
 * <p>
 * The agent uses the {@link ConsoleLogFactory} to log messages.
 *
 */
public class SampleAgent {

    static {
        LogFactory.setLogFactory(new ConsoleLogFactory());
        // This enables logging of user credentials (keys and passwords) in plain text to the DEBUG log
        SNMP4JSettings.setSecretLoggingEnabled(true);
    }
    public static final String COMMAND_LINE_OPTIONS = "-c[s{=SampleAgent.cfg}] -bc[s{=SampleAgent.bc}] +dhks[s] +u[s] " +
            "+tls-trust-ca[s] +tls-peer-id[s] +tls-local-id[s] +tls-version[s{=TLSv1}<(TLSv1|TLSv1.1|TLSv1.2|TLSv1.3)>] +dtls-version[s{=TLSv1.2}<(TLSv1.0|TLSv1.2)>]" +
            "+Djavax.net.ssl.keyStore +Djavax.net.ssl.keyStorePassword " +
            "+Djavax.net.ssl.trustStore +Djavax.net.ssl.trustStorePassword " +
            "+ts[s] +cfg[s] +x ";
    public static final String COMMAND_LINE_PARAMS = "#address[s<(udp|tcp|tls|dtls):.*[/[0-9]+]?>] ..";

    private static final LogAdapter logger = LogFactory.getLogger(SampleAgent.class);

    protected AgentConfigManager agent;
    protected MOServer server;
    private final String configFile;
    private final File bootCounterFile;

    // supported MIBs
    protected Modules modules;

    protected Properties tableSizeLimits;

    @SuppressWarnings("unchecked")
    public SampleAgent(Map<String, List<Object>> args) {
        LogFactory.getLogFactory().getRootLogger().setLogLevel(LogLevel.ALL);
        SNMP4JSettings.setReportSecurityLevelStrategy(SNMP4JSettings.ReportSecurityLevelStrategy.noAuthNoPrivIfNeeded);
        //Security.setProperty("crypto.policy", "unlimited");
        try {
            logger.info("Max supported AES key length is "+ Cipher.getMaxAllowedKeyLength("AES"));
        } catch (NoSuchAlgorithmException e) {
            logger.error("AES privacy not supported by this VM: ", e);
        }

        server = new DefaultMOServer();
        MOServer[] moServers = new MOServer[]{server};
        String configFilename = null;
        if (args.containsKey("cfg")) {
            configFilename = (String) ArgumentParser.getValue(args, "cfg", 0);
        }
        configFile = (String) (args.get("c")).get(0);
        bootCounterFile = new File((String) (args.get("bc")).get(0));

        EngineBootsCounterFile engineBootsCounterFile = new EngineBootsCounterFile(bootCounterFile);
        OctetString ownEngineId = engineBootsCounterFile.getEngineId(new OctetString(MPv3.createLocalEngineID()));

        List<?> tlsVersions = args.get("tls-version");
        if (tlsVersions != null && (tlsVersions.size() > 0)) {
            System.setProperty(SnmpConfigurator.P_TLS_VERSION, (String) tlsVersions.get(0));
        }

        MOInputFactory configurationFactory = null;
        // load initial configuration from properties file only if there is no persistent data for the default context:
        configurationFactory = createMOInputFactory(configFilename, ImportMode.restoreChanges);

        this.tableSizeLimits = getTableSizeLimitsProperties(args);
        String dhKickstartInfoPath = (String) ArgumentParser.getFirstValue(args.get("dhks"));
        DefaultMOPersistenceProvider persistenceProvider = new DefaultMOPersistenceProvider(moServers, configFile);
        setupAgent(args, persistenceProvider, engineBootsCounterFile, ownEngineId,
                moServers, configurationFactory, args.get("address"), dhKickstartInfoPath);
    }

    protected MOInputFactory createMOInputFactory(String configFilename, ImportMode importMode) {
        MOInputFactory configurationFactory;
        InputStream configInputStream = SampleAgent.class.getResourceAsStream("SampleAgentConfig.properties");
        final Properties props = new Properties();

        if (configFilename != null) {
            try {
                configInputStream = new FileInputStream(ResourceUtils.getFile("classpath:SampleAgentConfig.properties"));
            } catch (FileNotFoundException ex1) {
                logger.error("Config file '" + configFilename + "' not found: " + ex1.getMessage(), ex1);
                throw new RuntimeException(ex1);
            }
        }

        try {
            props.load(configInputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        configurationFactory = () -> new PropertyMOInput(props, this.agent, importMode);
        return configurationFactory;
    }

    protected SampleAgent(Map<String, List<Object>> args,
                          MOServer[] moServers, MOPersistenceProvider persistenceProvider,
                          Properties tableSizeLimits, ImportMode importMode) {
        this.server = new DefaultMOServer();
        List<?> tlsVersions = args.get("tls-version");
        if (tlsVersions != null && (tlsVersions.size() > 0)) {
            System.setProperty(SnmpConfigurator.P_TLS_VERSION, (String) tlsVersions.get(0));
        }

        String configFilename = null;
        if (args.containsKey("cfg")) {
            configFilename = (String) ArgumentParser.getValue(args, "cfg", 0);
        }

        configFile = (String) (args.get("c")).get(0);
        this.tableSizeLimits = tableSizeLimits;
        String dhKickstartInfoPath = (String) ArgumentParser.getFirstValue(args.get("dhks"));
        bootCounterFile = new File((String) (args.get("bc")).get(0));

        EngineBootsCounterFile engineBootsCounterFile = new EngineBootsCounterFile(bootCounterFile);
        OctetString ownEngineId = engineBootsCounterFile.getEngineId(new OctetString(MPv3.createLocalEngineID()));
        setupAgent(args, persistenceProvider, engineBootsCounterFile, ownEngineId, moServers,
                createMOInputFactory(configFilename, importMode), args.get("address"), dhKickstartInfoPath);
    }

    protected void setupAgent(Map<String, List<Object>> args,
                              MOPersistenceProvider persistenceProvider,
                              EngineBootsProvider engineBootsProvider,
                              OctetString engineID,
                              MOServer[] moServers, MOInputFactory configurationFactory,
                              List<Object> listenAddress,
                              String dhKickstartInfoPath) {
        MessageDispatcher messageDispatcher = new MessageDispatcherImpl();
        addListenAddresses(messageDispatcher, listenAddress);
        Collection<DHKickstartParameters> dhKickstartParameters = Collections.emptyList();
        if (dhKickstartInfoPath != null) {
            File dhKickstartInfoFile = new File(dhKickstartInfoPath);
            if (dhKickstartInfoFile.canRead()) {
                try {
                    Properties kickstartProperties = new Properties();
                    FileInputStream fileInputStream = new FileInputStream(dhKickstartInfoFile);
                    kickstartProperties.load(fileInputStream);
                    fileInputStream.close();
                    dhKickstartParameters =
                            DHKickstartParametersImpl.readFromProperties("org.snmp4j.", kickstartProperties);
                } catch (IOException iox) {
                    logger.error("Failed to load Diffie Hellman kickstart parameters from '" +
                            dhKickstartInfoPath + "': " + iox.getMessage(), iox);
                }
            } else {
                logger.warn("Diffie Hellman kickstart parameters file cannot be read: " + dhKickstartInfoFile);
            }
        }
        SnmpConfigurator snmpConfigurator = new SnmpConfigurator(true);
        agent = new AgentConfigManager(
                engineID,
                messageDispatcher,
                null,
                moServers,
                ThreadPool.create("SampleAgent", 3),
                configurationFactory,
                persistenceProvider, engineBootsProvider, null, dhKickstartParameters) {

            @Override
            protected Session createSnmpSession(MessageDispatcher dispatcher) {
                Session session = super.createSnmpSession(dispatcher);
                snmpConfigurator.configure(session, getUsm(), messageDispatcher, args);
                return session;
            }
        };
        agent.setContext(new SecurityModels(), new SecurityProtocols(SecurityProtocols.SecurityProtocolSet.maxCompatibility), new CounterSupport());
    }

    protected static Properties getTableSizeLimitsProperties(Map<String, List<Object>> args) {
        InputStream tableSizeLimitsInputStream = SampleAgent.class.getResourceAsStream("SampleAgentTableSizeLimits.properties");

        if (args.containsKey("ts")) {
            try {
                tableSizeLimitsInputStream = new FileInputStream(ResourceUtils.getFile("classpath:SampleAgentTableSizeLimits.properties"));
            } catch (FileNotFoundException ex1) {
                ex1.printStackTrace();
            }
        }

        Properties tableSizeLimits = new Properties();

        try {
            tableSizeLimits.load(tableSizeLimitsInputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return tableSizeLimits;
    }

    protected void addListenAddresses(MessageDispatcher md, List<Object> addresses) {
        for (Object addressString : addresses) {
            Address address = GenericAddress.parse(addressString.toString());

            if (address == null) {
                logger.fatal("Could not parse address string '" + addressString + "'");
                return;
            }

            TransportMapping<? extends Address> tm = TransportMappings.getInstance().createTransportMapping(address);
            if (tm != null) {
                md.addTransportMapping(tm);
            } else {
                logger.warn("No transport mapping available for address '" + address + "'.");
            }
        }
    }

    public void run() {
        // Contexts need to be added programmatically
        server.addContext(new OctetString("context1"));
        // initialize agent before registering our own modules
        agent.initialize();
        SNMPv2MIB context1SNMPv2MIB = new SNMPv2MIB(new OctetString(), new OID(), new Integer32(0));
        // switch logging of notifications to log sent notifications instead
        try {
            context1SNMPv2MIB.registerMOs(server, new OctetString("context1"));
        } catch (DuplicateRegistrationException e) {
            throw new RuntimeException(e);
        }
        // of logging the original internal notification event:
        //agent.getNotificationLogMIB().setLoggerMode(
        //  NotificationLogMib.Snmp4jNotificationLogModeEnum.sent);
        // this requires sysUpTime to be available.
        // add proxy forwarder
        agent.setupProxyForwarder();

        registerMIBs();
        // apply table size limits
        agent.setTableSizeLimits(tableSizeLimits);
        // register shutdown hook to be able to automatically commit configuration to persistent storage
        agent.registerShutdownHook();
        // now continue agent setup and launch it.
        agent.run();
    }

    /**
     * Get the {@link MOFactory} that creates the various MOs (MIB Objects).
     *
     * @return a {@link DefaultMOFactory} instance by default.
     * @since 1.3.2
     */
    protected MOFactory getFactory() {
        return DefaultMOFactory.getInstance();
    }

    /**
     * Register your own MIB modules in the specified context of the agent. The {@link MOFactory} provided to the {@code
     * Modules} constructor is returned by {@link #getFactory()}.
     */
    protected void registerMIBs() {
        if (modules == null) {
            modules = new Modules(getFactory());
            modules.getFmAlarmMib().getFmAlarmEntry().addMOTableRowListener(new FmAlarmRowListener());
        }

        try {
            modules.registerMOs(server, null);
        } catch (DuplicateRegistrationException drex) {
            logger.error("Duplicate registration: " + drex.getMessage() + "." + " MIB object registration may be incomplete!", drex);
        }
    }

    class FmAlarmRowListener implements MOTableRowListener<FmAlarmEntryRow> {
        public void rowChanged(MOTableRowEvent<FmAlarmEntryRow> event) {
            if ((event.getType() == MOTableRowEvent.CREATE) || (event.getType() == MOTableRowEvent.UPDATED)) {
                // ignore
                return;
            }

            UnsignedInteger32 fmAlarmIdValue = (UnsignedInteger32) event.getRow().getValue(FmAlarmMib.idxFmAlarmId);
            OctetString fmAlarmNodeNameValue = (OctetString) event.getRow().getValue(FmAlarmMib.idxFmAlarmNodeName);
            OctetString fmAlarmDateAndTimeValue = (OctetString) event.getRow().getValue(FmAlarmMib.idxFmAlarmDateAndTime);
            UnsignedInteger32 fmAlarmSeverityValue = (UnsignedInteger32) event.getRow().getValue(FmAlarmMib.idxFmAlarmSeverity);
            OctetString fmAlarmFaultCodeValue = (OctetString) event.getRow().getValue(FmAlarmMib.idxFmAlarmFaultCode);
            OctetString fmAlarmMessageValue = (OctetString) event.getRow().getValue(FmAlarmMib.idxFmAlarmMessage);
            OctetString fmAlarmComponentNameValue = (OctetString) event.getRow().getValue(FmAlarmMib.idxFmAlarmComponentName);
            UnsignedInteger32 fmAlarmEventTypeValue = (UnsignedInteger32) event.getRow().getValue(FmAlarmMib.idxFmAlarmEventType);
            UnsignedInteger32 fmAlarmProbableCauseValue = (UnsignedInteger32) event.getRow().getValue(FmAlarmMib.idxFmAlarmProbableCause);
            OctetString fmAlarmAttributesValue = (OctetString) event.getRow().getValue(FmAlarmMib.idxFmAlarmAttributes);

            VariableBinding[] payload = new VariableBinding[10];
            OID table = event.getTable().getOID();

            OID colFmAlarmIdVariable = new OID(table);
            colFmAlarmIdVariable.append(FmAlarmMib.colFmAlarmId);
            colFmAlarmIdVariable.append(event.getRow().getIndex());

            OID colFmAlarmNodeNameVariable = new OID(table);
            colFmAlarmNodeNameVariable.append(FmAlarmMib.colFmAlarmNodeName);
            colFmAlarmNodeNameVariable.append(event.getRow().getIndex());

            OID colFmAlarmDateAndTimeVariable = new OID(table);
            colFmAlarmDateAndTimeVariable.append(FmAlarmMib.colFmAlarmDateAndTime);
            colFmAlarmDateAndTimeVariable.append(event.getRow().getIndex());

            OID colFmAlarmSeverityVariable = new OID(table);
            colFmAlarmSeverityVariable.append(FmAlarmMib.colFmAlarmSeverity);
            colFmAlarmSeverityVariable.append(event.getRow().getIndex());

            OID colFmAlarmFaultCodeVariable = new OID(table);
            colFmAlarmFaultCodeVariable.append(FmAlarmMib.colFmAlarmFaultCode);
            colFmAlarmFaultCodeVariable.append(event.getRow().getIndex());

            OID colFmAlarmMessageVariable = new OID(table);
            colFmAlarmMessageVariable.append(FmAlarmMib.colFmAlarmMessage);
            colFmAlarmMessageVariable.append(event.getRow().getIndex());

            OID colFmAlarmComponentNameVariable = new OID(table);
            colFmAlarmComponentNameVariable.append(FmAlarmMib.colFmAlarmComponentName);
            colFmAlarmComponentNameVariable.append(event.getRow().getIndex());

            OID colFmAlarmEventTypeVariable = new OID(table);
            colFmAlarmEventTypeVariable.append(FmAlarmMib.colFmAlarmEventType);
            colFmAlarmEventTypeVariable.append(event.getRow().getIndex());

            OID colFmAlarmProbableCauseVariable = new OID(table);
            colFmAlarmProbableCauseVariable.append(FmAlarmMib.colFmAlarmProbableCause);
            colFmAlarmProbableCauseVariable.append(event.getRow().getIndex());

            OID colFmAlarmAttributesVariable = new OID(table);
            colFmAlarmAttributesVariable.append(FmAlarmMib.colFmAlarmAttributes);
            colFmAlarmAttributesVariable.append(event.getRow().getIndex());

            payload[0] = new VariableBinding(colFmAlarmIdVariable, fmAlarmIdValue);
            payload[1] = new VariableBinding(colFmAlarmNodeNameVariable, fmAlarmNodeNameValue);
            payload[2] = new VariableBinding(colFmAlarmDateAndTimeVariable, fmAlarmDateAndTimeValue);
            payload[3] = new VariableBinding(colFmAlarmSeverityVariable, fmAlarmSeverityValue);
            payload[4] = new VariableBinding(colFmAlarmFaultCodeVariable, fmAlarmFaultCodeValue);
            payload[5] = new VariableBinding(colFmAlarmMessageVariable, fmAlarmMessageValue);
            payload[6] = new VariableBinding(colFmAlarmComponentNameVariable, fmAlarmComponentNameValue);
            payload[7] = new VariableBinding(colFmAlarmEventTypeVariable, fmAlarmEventTypeValue);
            payload[8] = new VariableBinding(colFmAlarmProbableCauseVariable, fmAlarmProbableCauseValue);
            payload[9] = new VariableBinding(colFmAlarmAttributesVariable, fmAlarmAttributesValue);
            modules.getFmAlarmMib().fmAlarmNotification(
                    agent.getNotificationOriginator(), new OctetString(), payload);
        }
    }

    protected static List<String[]> splitArgsForMultipleAgents(String[] args, String separatorArgs) {
        List<String[]> agentsCommandLines = new ArrayList<>();
        ArrayList<String> agentArgs = new ArrayList<>();
        for (String arg : args) {
            if ("||".equals(arg)) {
                agentsCommandLines.add(agentArgs.toArray(new String[0]));
                agentArgs.clear();
            }
            else {
                agentArgs.add(arg);
            }
        }
        agentsCommandLines.add(agentArgs.toArray(new String[0]));
        return agentsCommandLines;
    }

    /**
     * Runs a sample agent with a default configuration defined by {@code SampleAgentConfig.properties}. A sample
     * command line is:
     * <pre>
     * -c SampleAgent.cfg -bc SampleAgent.bc udp:127.0.0.1/4700 tcp:127.0.0.1/4700 [|| [options..] address [address..]]
     * </pre>
     * Separated by || options for more than one agent in the same Java process can be given.
     *
     * @param args
     *         the command line arguments defining at least the listen addresses. The format is {@code
     *         -c[s{=SampleAgent.cfg}] -bc[s{=SampleAgent.bc}] +ts[s] +cfg[s] #address[s&lt;(udp|tcp|tls):.*[/[0-9]+]?&gt;]
     *         ..}. For the format description see {@link ArgumentParser}. Multiple agent configurations can be given
     *         separated by ||.
     */
    public static void runAgent(String[] args) {

        ArgumentParser parser = new ArgumentParser(COMMAND_LINE_OPTIONS, COMMAND_LINE_PARAMS);
        List<String[]> multiAgentArgs = splitArgsForMultipleAgents(args, "||");
        for (String[] agentArgs : multiAgentArgs) {
            Map<String, List<Object>> commandLineParameters;
            try {
                commandLineParameters = parser.parse(agentArgs);
                if (commandLineParameters.containsKey("x")) {
                    SNMP4JSettings.setExtensibilityEnabled(true);
                }
                SampleAgent sampleAgent = new SampleAgent(commandLineParameters);
                // Add all available security protocols (e.g. SHA,MD5,DES,AES,3DES,..)
                SecurityProtocols.getInstance().addDefaultProtocols();
                // configure system group:
                // Set system description:
                // sampleAgent.agent.getSysDescr().setValue("My system description".getBytes());
                // Set system OID (= OID of the AGENT-CAPABILITIES statement describing
                // the implemented MIB objects of this agent:
                // sampleAgent.agent.getSysOID().setValue("1.3.1.6.1.4.1....");
                // Set the system services
                // sampleAgent.agent.getSysServices().setValue(72);
                sampleAgent.run();
            } catch (ParseException ex) {
                logger.error(ex.getMessage(), ex);
            }
        }
    }
}
