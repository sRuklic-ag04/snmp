package com.kontron.snmp.example;
//--AgentGen BEGIN=_BEGIN
//--AgentGen END

import org.snmp4j.smi.*;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.agent.*;
import org.snmp4j.agent.mo.*;
import org.snmp4j.agent.mo.snmp.smi.*;
import org.snmp4j.log.LogFactory;
import org.snmp4j.log.LogAdapter;
import org.snmp4j.agent.mo.snmp.tc.*;

//--AgentGen BEGIN=_IMPORT
//--AgentGen END

public class FmAlarmMib
//--AgentGen BEGIN=_EXTENDS
//--AgentGen END
        implements MOGroup
//--AgentGen BEGIN=_IMPLEMENTS
//--AgentGen END
{

    private static final LogAdapter LOGGER = LogFactory.getLogger(FmAlarmMib.class);

    //--AgentGen BEGIN=_STATIC
    //--AgentGen END

    // Factory
    private MOFactory moFactory =
            DefaultMOFactory.getInstance();

    // Constants

    /**
     * OID of this MIB module for usage which can be
     * used for its identification.
     */
    public static final OID oidFmAlarmMib =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2 });

    // Identities
    // Scalars

    // Tables

    // Notifications
    public static final OID oidFmAlarmNotification =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,3,1 });
    public static final OID oidFmAlarmId =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,2 });
    public static final OID oidFmAlarmNodeName =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,3 });
    public static final OID oidFmAlarmDateAndTime =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,4 });
    public static final OID oidFmAlarmSeverity =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,5 });
    public static final OID oidFmAlarmFaultCode =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,6 });
    public static final OID oidFmAlarmMessage =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,7 });
    public static final OID oidFmAlarmComponentName =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,8 });
    public static final OID oidFmAlarmEventType =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,9 });
    public static final OID oidFmAlarmProbableCause =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,10 });
    public static final OID oidFmAlarmAttributes =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,11 });



    // Enumerations

    // TextualConventions
    private static final String TC_MODULE_SNMPV2_TC = "SNMPv2-TC";
    private static final String TC_MODULE_KTR_FM_MIB = "KTR-FM-MIB";
    private static final String TC_FMALARMCOLUMN = "FmAlarmColumn";
    private static final String TC_STORAGETYPE = "StorageType";
    private static final String TC_DISPLAYSTRING = "DisplayString";
    private static final String TC_ROWSTATUS = "RowStatus";
    private static final String TC_TIMESTAMP = "TimeStamp";
    private static final String TC_IANAITUPROBABLECAUSE = "IANAItuProbableCause";
    private static final String TC_IANAITUEVENTTYPE = "IANAItuEventType";

    // Scalars

    // Column TC definitions for snmp4jDemoEntry:
    public static final String tcModuleSNMPv2Tc = "SNMPv2-TC";
    public static final String tcDefTimeStamp = "TimeStamp";
    public static final String tcDefStorageType = "StorageType";
    public static final String tcDefRowStatus = "RowStatus";

    public static final OID oidFmAlarmActiveEntry =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1 });

    // Index OID definitions
    public static final OID oidFmAlarmIndex =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,1 });

    // Column TC definitions for fmAlarmEntry:
    public static final String tcModuleSnmp4jDemoMib = "SNMP4J-DEMO-MIB";
    public static final String tcDefSparseTableColumn = "FmAlarmColumn";

    // Column sub-identifier definitions for fmAlarmEntry:
    public static final int colFmAlarmId = 2;
    public static final int colFmAlarmNodeName = 3;
    public static final int colFmAlarmDateAndTime = 4;
    public static final int colFmAlarmSeverity = 5;
    public static final int colFmAlarmFaultCode = 6;
    public static final int colFmAlarmMessage = 7;
    public static final int colFmAlarmComponentName = 8;
    public static final int colFmAlarmEventType = 9;
    public static final int colFmAlarmProbableCause = 10;
    public static final int colFmAlarmAttributes = 11;

    // Column index definitions for fmAlarmEntry:
    public static final int idxFmAlarmId = 0;
    public static final int idxFmAlarmNodeName = 1;
    public static final int idxFmAlarmDateAndTime = 2;
    public static final int idxFmAlarmSeverity = 3;
    public static final int idxFmAlarmFaultCode = 4;
    public static final int idxFmAlarmMessage = 5;
    public static final int idxFmAlarmComponentName = 6;
    public static final int idxFmAlarmEventType = 7;
    public static final int idxFmAlarmProbableCause = 8;
    public static final int idxFmAlarmAttributes = 9;

    private MOTableSubIndex[] fmAlarmEntryIndexes;
    private MOTableIndex fmAlarmEntryIndex;

    @SuppressWarnings("rawtypes")
    private MOTable<FmAlarmEntryRow,
            MOColumn,
            MOMutableTableModel<FmAlarmEntryRow>> fmAlarmEntry;
    private MOMutableTableModel<FmAlarmEntryRow> fmAlarmEntryModel;


//--AgentGen BEGIN=_MEMBERS
//--AgentGen END

    /**
     * Constructs a FmAlarmMib instance without actually creating its
     * {@code ManagedObject} instances. This has to be done in a
     * sub-class constructor or after construction by calling
     * {@link #createMO(MOFactory moFactory)}.
     */
    protected FmAlarmMib() {
//--AgentGen BEGIN=_DEFAULTCONSTRUCTOR
//--AgentGen END
    }

    /**
     * Constructs a FmAlarmMib instance and actually creates its
     * {@code ManagedObject} instances using the supplied
     * {@code MOFactory} (by calling
     * {@link #createMO(MOFactory moFactory)}).
     * @param moFactory
     *    the {@code MOFactory} to be used to create the
     *    managed objects for this module.
     */
    public FmAlarmMib(MOFactory moFactory) {
        this();
        createMO(moFactory);
//--AgentGen BEGIN=_FACTORYCONSTRUCTOR
        initializeTable();
//--AgentGen END
    }

//--AgentGen BEGIN=_CONSTRUCTORS
//--AgentGen END

    /**
     * Create the ManagedObjects defined for this MIB module
     * using the specified {@link MOFactory}.
     * @param moFactory
     *    the {@code MOFactory} instance to use for object
     *    creation.
     */
    protected void createMO(MOFactory moFactory) {
        addTCsToFactory(moFactory);
        createFmAlarmEntry(moFactory);
    }

    @SuppressWarnings("rawtypes")
    public MOTable<FmAlarmEntryRow,MOColumn,MOMutableTableModel<FmAlarmEntryRow>> getFmAlarmEntry() {
        return fmAlarmEntry;
    }


    @SuppressWarnings(value={"unchecked"})
    private void createFmAlarmEntry(MOFactory moFactory) {
        // Index definition
        fmAlarmEntryIndexes =
                new MOTableSubIndex[] {
                        moFactory.createSubIndex(oidFmAlarmIndex,
                                SMIConstants.SYNTAX_INTEGER, 1, 1)    };

        fmAlarmEntryIndex =
                moFactory.createIndex(fmAlarmEntryIndexes,
                        false,
                        new MOTableIndexValidator() {
                            public boolean isValidIndex(OID index) {
                                boolean isValidIndex = true;
                                //--AgentGen BEGIN=fmAlarmEntry::isValidIndex
                                //--AgentGen END
                                return isValidIndex;
                            }
                        });

        // Columns
        MOColumn<?>[] fmAlarmEntryColumns = new MOColumn<?>[10];

        // col1 UnsignedInteger32
        fmAlarmEntryColumns[idxFmAlarmId] =
                new MOMutableColumn<UnsignedInteger32>(colFmAlarmId,
                        SMIConstants.SYNTAX_UNSIGNED_INTEGER32,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (UnsignedInteger32)null);
        ValueConstraint fmAlarmIdVC = new ConstraintsImpl();
        ((ConstraintsImpl)fmAlarmIdVC).add(new Constraint(0L, 10L));
        ((MOMutableColumn)fmAlarmEntryColumns[idxFmAlarmId]).
                addMOValueValidationListener(new ValueConstraintValidator(fmAlarmIdVC));
        ((MOMutableColumn)fmAlarmEntryColumns[idxFmAlarmId]).
                addMOValueValidationListener(new FmAlarmIdValidator());

        // col2
        fmAlarmEntryColumns[idxFmAlarmNodeName] =
                new MOMutableColumn<OctetString>(colFmAlarmNodeName,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (OctetString)null);
        ValueConstraint fmAlarmNodeNameVC = new ConstraintsImpl();
        ((ConstraintsImpl)fmAlarmNodeNameVC).add(new Constraint(0L, 10L));
        ((MOMutableColumn)fmAlarmEntryColumns[idxFmAlarmNodeName]).
                addMOValueValidationListener(new ValueConstraintValidator(fmAlarmNodeNameVC));
        ((MOMutableColumn)fmAlarmEntryColumns[idxFmAlarmNodeName]).
                addMOValueValidationListener(new FmAlarmNodeNameValidator());

        // col3
        fmAlarmEntryColumns[idxFmAlarmDateAndTime] =
                new MOMutableColumn<OctetString>(colFmAlarmDateAndTime,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (OctetString)null);
        ValueConstraint fmAlarmDateAndTimeVC = new ConstraintsImpl();
        ((ConstraintsImpl)fmAlarmDateAndTimeVC).add(new Constraint(0L, 10L));
        ((MOMutableColumn)fmAlarmEntryColumns[idxFmAlarmDateAndTime]).
                addMOValueValidationListener(new ValueConstraintValidator(fmAlarmDateAndTimeVC));
        ((MOMutableColumn)fmAlarmEntryColumns[idxFmAlarmDateAndTime]).
                addMOValueValidationListener(new FmAlarmDateAndTimeValidator());

        // col4
        fmAlarmEntryColumns[idxFmAlarmSeverity] =
                new MOMutableColumn<UnsignedInteger32>(colFmAlarmSeverity,
                        SMIConstants.SYNTAX_UNSIGNED_INTEGER32,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (UnsignedInteger32)null);
        ValueConstraint fmAlarmSeverityVC = new EnumerationConstraint(
                new int[] {
                        FmSeverity.indeterminate,
                        FmSeverity.cleared,
                        FmSeverity.normal,
                        FmSeverity.warning,
                        FmSeverity.minor,
                        FmSeverity.major,
                        FmSeverity.critical
                }
        );
        ((MOMutableColumn)fmAlarmEntryColumns[idxFmAlarmSeverity]).
                addMOValueValidationListener(new ValueConstraintValidator(fmAlarmSeverityVC));
        ((MOMutableColumn)fmAlarmEntryColumns[idxFmAlarmSeverity]).
                addMOValueValidationListener(new FmAlarmSeverityValidator());

        // col5
        fmAlarmEntryColumns[idxFmAlarmFaultCode] =
                new MOMutableColumn<OctetString>(colFmAlarmFaultCode,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (OctetString)null);
        ValueConstraint fmAlarmFaultCodeVC = new ConstraintsImpl();
        ((ConstraintsImpl)fmAlarmFaultCodeVC).add(new Constraint(0L, 10L));
        ((MOMutableColumn)fmAlarmEntryColumns[idxFmAlarmFaultCode]).
                addMOValueValidationListener(new ValueConstraintValidator(fmAlarmFaultCodeVC));
        ((MOMutableColumn)fmAlarmEntryColumns[idxFmAlarmFaultCode]).
                addMOValueValidationListener(new FmAlarmFaultCodeValidator());

        // col6
        fmAlarmEntryColumns[idxFmAlarmMessage] =
                new MOMutableColumn<OctetString>(colFmAlarmMessage,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (OctetString)null);
        ValueConstraint fmAlarmMessageVC = new ConstraintsImpl();
        ((ConstraintsImpl)fmAlarmMessageVC).add(new Constraint(0L, 10L));
        ((MOMutableColumn)fmAlarmEntryColumns[idxFmAlarmMessage]).
                addMOValueValidationListener(new ValueConstraintValidator(fmAlarmMessageVC));
        ((MOMutableColumn)fmAlarmEntryColumns[idxFmAlarmMessage]).
                addMOValueValidationListener(new FmAlarmMessageValidator());

        // col7
        fmAlarmEntryColumns[idxFmAlarmComponentName] =
                new MOMutableColumn<OctetString>(colFmAlarmComponentName,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (OctetString)null);
        ValueConstraint fmAlarmComponentNameVC = new ConstraintsImpl();
        ((ConstraintsImpl)fmAlarmComponentNameVC).add(new Constraint(0L, 10L));
        ((MOMutableColumn)fmAlarmEntryColumns[idxFmAlarmComponentName]).
                addMOValueValidationListener(new ValueConstraintValidator(fmAlarmComponentNameVC));
        ((MOMutableColumn)fmAlarmEntryColumns[idxFmAlarmComponentName]).
                addMOValueValidationListener(new FmAlarmComponentNameValidator());

        // col8 IANAItuEventType
        fmAlarmEntryColumns[idxFmAlarmEventType] =
                new MOMutableColumn<UnsignedInteger32>(colFmAlarmEventType,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (UnsignedInteger32)null);
        ValueConstraint fmAlarmEventTypeVC = new EnumerationConstraint(
                new int[] {
                        IANAItuEventType.other,
                        IANAItuEventType.communicationsAlarm,
                        IANAItuEventType.qualityOfServiceAlarm,
                        IANAItuEventType.processingErrorAlarm,
                        IANAItuEventType.equipmentAlarm,
                        IANAItuEventType.environmentalAlarm,
                        IANAItuEventType.integrityViolation,
                        IANAItuEventType.operationalViolation,
                        IANAItuEventType.physicalViolation,
                        IANAItuEventType.securityServiceOrMechanismViolation,
                        IANAItuEventType.timeDomainViolation
                }
        );
        ((MOMutableColumn)fmAlarmEntryColumns[idxFmAlarmEventType]).
                addMOValueValidationListener(new ValueConstraintValidator(fmAlarmEventTypeVC));
        ((MOMutableColumn)fmAlarmEntryColumns[idxFmAlarmEventType]).
                addMOValueValidationListener(new FmAlarmEventTypeValidator());

        // col9 IANAItuProbableCause
        fmAlarmEntryColumns[idxFmAlarmProbableCause] =
                new MOMutableColumn<UnsignedInteger32>(colFmAlarmProbableCause,
                        SMIConstants.SYNTAX_UNSIGNED_INTEGER32,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (UnsignedInteger32)null);
        ValueConstraint fmAlarmProbableCauseVC = new EnumerationConstraint(
                new int[] {
                        IANAItuProbableCause.aIS,
                        IANAItuProbableCause.callSetUpFailure,
                        IANAItuProbableCause.degradedSignal,
                        IANAItuProbableCause.farEndReceiverFailure,
                        IANAItuProbableCause.framingError,
                        IANAItuProbableCause.lossOfFrame,
                        IANAItuProbableCause.lossOfPointer,
                        IANAItuProbableCause.lossOfSignal,
                        IANAItuProbableCause.payloadTypeMismatch,
                        IANAItuProbableCause.transmissionError,
                        IANAItuProbableCause.remoteAlarmInterface,
                        IANAItuProbableCause.excessiveBER,
                        IANAItuProbableCause.pathTraceMismatch,
                        IANAItuProbableCause.unavailable,
                        IANAItuProbableCause.signalLabelMismatch,
                        IANAItuProbableCause.lossOfMultiFrame,
                        IANAItuProbableCause.receiveFailure,
                        IANAItuProbableCause.transmitFailure,
                        IANAItuProbableCause.modulationFailure,
                        IANAItuProbableCause.demodulationFailure,
                        IANAItuProbableCause.broadcastChannelFailure,
                        IANAItuProbableCause.connectionEstablishmentError,
                        IANAItuProbableCause.invalidMessageReceived,
                        IANAItuProbableCause.localNodeTransmissionError,
                        IANAItuProbableCause.remoteNodeTransmissionError,
                        IANAItuProbableCause.routingFailure,
                        IANAItuProbableCause.backplaneFailure,
                        IANAItuProbableCause.dataSetProblem,
                        IANAItuProbableCause.equipmentIdentifierDuplication,
                        IANAItuProbableCause.externalIFDeviceProblem,
                        IANAItuProbableCause.lineCardProblem,
                        IANAItuProbableCause.multiplexerProblem,
                        IANAItuProbableCause.nEIdentifierDuplication,
                        IANAItuProbableCause.powerProblem,
                        IANAItuProbableCause.processorProblem,
                        IANAItuProbableCause.protectionPathFailure,
                        IANAItuProbableCause.receiverFailure,
                        IANAItuProbableCause.replaceableUnitMissing,
                        IANAItuProbableCause.replaceableUnitTypeMismatch,
                        IANAItuProbableCause.synchronizationSourceMismatch,
                        IANAItuProbableCause.terminalProblem,
                        IANAItuProbableCause.timingProblem,
                        IANAItuProbableCause.transmitterFailure,
                        IANAItuProbableCause.trunkCardProblem,
                        IANAItuProbableCause.replaceableUnitProblem,
                        IANAItuProbableCause.realTimeClockFailure,
                        IANAItuProbableCause.antennaFailure,
                        IANAItuProbableCause.batteryChargingFailure,
                        IANAItuProbableCause.diskFailure,
                        IANAItuProbableCause.frequencyHoppingFailure,
                        IANAItuProbableCause.iODeviceError,
                        IANAItuProbableCause.lossOfSynchronisation,
                        IANAItuProbableCause.lossOfRedundancy,
                        IANAItuProbableCause.powerSupplyFailure,
                        IANAItuProbableCause.signalQualityEvaluationFailure,
                        IANAItuProbableCause.tranceiverFailure,
                        IANAItuProbableCause.protectionMechanismFailure,
                        IANAItuProbableCause.protectingResourceFailure,
                        IANAItuProbableCause.airCompressorFailure,
                        IANAItuProbableCause.airConditioningFailure,
                        IANAItuProbableCause.airDryerFailure,
                        IANAItuProbableCause.batteryDischarging,
                        IANAItuProbableCause.batteryFailure,
                        IANAItuProbableCause.commercialPowerFailure,
                        IANAItuProbableCause.coolingFanFailure,
                        IANAItuProbableCause.engineFailure,
                        IANAItuProbableCause.fireDetectorFailure,
                        IANAItuProbableCause.fuseFailure,
                        IANAItuProbableCause.generatorFailure,
                        IANAItuProbableCause.lowBatteryThreshold,
                        IANAItuProbableCause.pumpFailure,
                        IANAItuProbableCause.rectifierFailure,
                        IANAItuProbableCause.rectifierHighVoltage,
                        IANAItuProbableCause.rectifierLowFVoltage,
                        IANAItuProbableCause.ventilationsSystemFailure,
                        IANAItuProbableCause.enclosureDoorOpen,
                        IANAItuProbableCause.explosiveGas,
                        IANAItuProbableCause.fire,
                        IANAItuProbableCause.flood,
                        IANAItuProbableCause.highHumidity,
                        IANAItuProbableCause.highTemperature,
                        IANAItuProbableCause.highWind,
                        IANAItuProbableCause.iceBuildUp,
                        IANAItuProbableCause.intrusionDetection,
                        IANAItuProbableCause.lowFuel,
                        IANAItuProbableCause.lowHumidity,
                        IANAItuProbableCause.lowCablePressure,
                        IANAItuProbableCause.lowTemperatue,
                        IANAItuProbableCause.lowWater,
                        IANAItuProbableCause.smoke,
                        IANAItuProbableCause.toxicGas,
                        IANAItuProbableCause.coolingSystemFailure,
                        IANAItuProbableCause.externalEquipmentFailure,
                        IANAItuProbableCause.externalPointFailure,
                        IANAItuProbableCause.storageCapacityProblem,
                        IANAItuProbableCause.memoryMismatch,
                        IANAItuProbableCause.corruptData,
                        IANAItuProbableCause.outOfCPUCycles,
                        IANAItuProbableCause.sfwrEnvironmentProblem,
                        IANAItuProbableCause.sfwrDownloadFailure,
                        IANAItuProbableCause.lossOfRealTimel,
                        IANAItuProbableCause.applicationSubsystemFailure,
                        IANAItuProbableCause.configurationOrCustomisationError,
                        IANAItuProbableCause.databaseInconsistency,
                        IANAItuProbableCause.fileError,
                        IANAItuProbableCause.outOfMemory,
                        IANAItuProbableCause.softwareError,
                        IANAItuProbableCause.timeoutExpired,
                        IANAItuProbableCause.underlayingResourceUnavailable,
                        IANAItuProbableCause.versionMismatch,
                        IANAItuProbableCause.bandwidthReduced,
                        IANAItuProbableCause.congestion,
                        IANAItuProbableCause.excessiveErrorRate,
                        IANAItuProbableCause.excessiveResponseTime,
                        IANAItuProbableCause.excessiveRetransmissionRate,
                        IANAItuProbableCause.reducedLoggingCapability,
                        IANAItuProbableCause.systemResourcesOverload,
                        IANAItuProbableCause.adapterError,
                        IANAItuProbableCause.applicationSubsystemFailture,
                        IANAItuProbableCause.bandwidthReducedX733,
                        IANAItuProbableCause.callEstablishmentError,
                        IANAItuProbableCause.communicationsProtocolError,
                        IANAItuProbableCause.communicationsSubsystemFailure,
                        IANAItuProbableCause.configurationOrCustomizationError,
                        IANAItuProbableCause.congestionX733,
                        IANAItuProbableCause.coruptData,
                        IANAItuProbableCause.cpuCyclesLimitExceeded,
                        IANAItuProbableCause.dataSetOrModemError,
                        IANAItuProbableCause.degradedSignalX733,
                        IANAItuProbableCause.dteDceInterfaceError,
                        IANAItuProbableCause.enclosureDoorOpenX733,
                        IANAItuProbableCause.equipmentMalfunction,
                        IANAItuProbableCause.excessiveVibration,
                        IANAItuProbableCause.fileErrorX733,
                        IANAItuProbableCause.fireDetected,
                        IANAItuProbableCause.framingErrorX733,
                        IANAItuProbableCause.heatingVentCoolingSystemProblem,
                        IANAItuProbableCause.humidityUnacceptable,
                        IANAItuProbableCause.inputOutputDeviceError,
                        IANAItuProbableCause.inputDeviceError,
                        IANAItuProbableCause.lanError,
                        IANAItuProbableCause.leakDetected,
                        IANAItuProbableCause.localNodeTransmissionErrorX733,
                        IANAItuProbableCause.lossOfFrameX733,
                        IANAItuProbableCause.lossOfSignalX733,
                        IANAItuProbableCause.materialSupplyExhausted,
                        IANAItuProbableCause.multiplexerProblemX733,
                        IANAItuProbableCause.outOfMemoryX733,
                        IANAItuProbableCause.ouputDeviceError,
                        IANAItuProbableCause.performanceDegraded,
                        IANAItuProbableCause.powerProblems,
                        IANAItuProbableCause.pressureUnacceptable,
                        IANAItuProbableCause.processorProblems,
                        IANAItuProbableCause.pumpFailureX733,
                        IANAItuProbableCause.queueSizeExceeded,
                        IANAItuProbableCause.receiveFailureX733,
                        IANAItuProbableCause.receiverFailureX733,
                        IANAItuProbableCause.remoteNodeTransmissionErrorX733,
                        IANAItuProbableCause.resourceAtOrNearingCapacity,
                        IANAItuProbableCause.responseTimeExecessive,
                        IANAItuProbableCause.retransmissionRateExcessive,
                        IANAItuProbableCause.softwareErrorX733,
                        IANAItuProbableCause.softwareProgramAbnormallyTerminated,
                        IANAItuProbableCause.softwareProgramError,
                        IANAItuProbableCause.storageCapacityProblemX733,
                        IANAItuProbableCause.temperatureUnacceptable,
                        IANAItuProbableCause.thresholdCrossed,
                        IANAItuProbableCause.timingProblemX733,
                        IANAItuProbableCause.toxicLeakDetected,
                        IANAItuProbableCause.transmitFailureX733,
                        IANAItuProbableCause.transmiterFailure,
                        IANAItuProbableCause.underlyingResourceUnavailable,
                        IANAItuProbableCause.versionMismatchX733,
                        IANAItuProbableCause.authenticationFailure,
                        IANAItuProbableCause.breachOfConfidentiality,
                        IANAItuProbableCause.cableTamper,
                        IANAItuProbableCause.delayedInformation,
                        IANAItuProbableCause.denialOfService,
                        IANAItuProbableCause.duplicateInformation,
                        IANAItuProbableCause.informationMissing,
                        IANAItuProbableCause.informationModificationDetected,
                        IANAItuProbableCause.informationOutOfSequence,
                        IANAItuProbableCause.keyExpired,
                        IANAItuProbableCause.nonRepudiationFailure,
                        IANAItuProbableCause.outOfHoursActivity,
                        IANAItuProbableCause.outOfService,
                        IANAItuProbableCause.proceduralError,
                        IANAItuProbableCause.unauthorizedAccessAttempt,
                        IANAItuProbableCause.unexpectedInformation,
                        IANAItuProbableCause.other,
                }
        );
        ((MOMutableColumn)fmAlarmEntryColumns[idxFmAlarmProbableCause]).
                addMOValueValidationListener(new ValueConstraintValidator(fmAlarmProbableCauseVC));
        ((MOMutableColumn)fmAlarmEntryColumns[idxFmAlarmProbableCause]).
                addMOValueValidationListener(new FmAlarmProbableCauseValidator());

        // col10
        fmAlarmEntryColumns[idxFmAlarmAttributes] =
                new MOMutableColumn<OctetString>(colFmAlarmAttributes,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (OctetString)null);
        ValueConstraint fmAlarmAttributesVC = new ConstraintsImpl();
        ((ConstraintsImpl)fmAlarmAttributesVC).add(new Constraint(0L, 10L));
        ((MOMutableColumn)fmAlarmEntryColumns[idxFmAlarmAttributes]).
                addMOValueValidationListener(new ValueConstraintValidator(fmAlarmAttributesVC));
        ((MOMutableColumn)fmAlarmEntryColumns[idxFmAlarmAttributes]).
                addMOValueValidationListener(new FmAlarmAttributesValidator());

        // Table model
        fmAlarmEntryModel =
                moFactory.createTableModel(oidFmAlarmActiveEntry,
                        fmAlarmEntryIndex,
                        fmAlarmEntryColumns);
        fmAlarmEntryModel.setRowFactory(new FmAlarmEntryRowFactory());
        fmAlarmEntry =
                moFactory.createTable(oidFmAlarmActiveEntry,
                        fmAlarmEntryIndex,
                        fmAlarmEntryColumns,
                        fmAlarmEntryModel);
    }



    public void registerMOs(MOServer server, OctetString context)
            throws DuplicateRegistrationException
    {
        // Scalar Objects
        server.register(this.fmAlarmEntry, context);
//--AgentGen BEGIN=_registerMOs
//--AgentGen END
    }

    public void unregisterMOs(MOServer server, OctetString context) {
        // Scalar Objects
        server.unregister(this.fmAlarmEntry, context);
//--AgentGen BEGIN=_unregisterMOs
//--AgentGen END
    }

    // Notifications
    public void fmAlarmNotification(NotificationOriginator notificationOriginator,
                                    OctetString context, VariableBinding[] vbs) {
        if (vbs.length < 10) {
            throw new IllegalArgumentException("Too few notification objects (snmp4jDemoEvent): "+
                    vbs.length+" < 10");
        }

        // snmp4jDemoSparseTableCol1
        if (!(vbs[0].getOid().startsWith(oidFmAlarmId))) {
            throw new IllegalArgumentException("Variable 0 (fmAlarmId)) has wrong OID: " + vbs[0].getOid() +
                    " does not start with "+ oidFmAlarmId);
        }
        if (!fmAlarmEntryIndex.isValidIndex(fmAlarmEntry.getIndexPart(vbs[0].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 0 (fmAlarmId)) specified: "+
                    fmAlarmEntry.getIndexPart(vbs[0].getOid()));
        }

        // snmp4jDemoSparseTableCol2
        if (!(vbs[1].getOid().startsWith(oidFmAlarmNodeName))) {
            throw new IllegalArgumentException("Variable 1 (fmAlarmNodeName)) has wrong OID: " + vbs[1].getOid() +
                    " does not start with "+ oidFmAlarmNodeName);
        }
        if (!fmAlarmEntryIndex.isValidIndex(fmAlarmEntry.getIndexPart(vbs[1].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 1 (fmAlarmNodeName)) specified: "+
                    fmAlarmEntry.getIndexPart(vbs[1].getOid()));
        }

        // snmp4jDemoSparseTableCol3
        if (!(vbs[2].getOid().startsWith(oidFmAlarmDateAndTime))) {
            throw new IllegalArgumentException("Variable 2 (fmAlarmDateAndTime)) has wrong OID: " + vbs[2].getOid() +
                    " does not start with "+ oidFmAlarmDateAndTime);
        }
        if (!fmAlarmEntryIndex.isValidIndex(fmAlarmEntry.getIndexPart(vbs[2].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 2 (fmAlarmDateAndTime)) specified: "+
                    fmAlarmEntry.getIndexPart(vbs[2].getOid()));
        }

        // snmp4jDemoSparseTableCol4
        if (!(vbs[3].getOid().startsWith(oidFmAlarmSeverity))) {
            throw new IllegalArgumentException("Variable 3 (fmAlarmSeverity)) has wrong OID: " + vbs[3].getOid() +
                    " does not start with "+ oidFmAlarmSeverity);
        }
        if (!fmAlarmEntryIndex.isValidIndex(fmAlarmEntry.getIndexPart(vbs[3].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 3 (fmAlarmSeverity)) specified: "+
                    fmAlarmEntry.getIndexPart(vbs[3].getOid()));
        }

        // snmp4jDemoSparseTableCol5
        if (!(vbs[4].getOid().startsWith(oidFmAlarmFaultCode))) {
            throw new IllegalArgumentException("Variable 4 (fmAlarmFaultCode)) has wrong OID: " + vbs[4].getOid() +
                    " does not start with "+ oidFmAlarmFaultCode);
        }
        if (!fmAlarmEntryIndex.isValidIndex(fmAlarmEntry.getIndexPart(vbs[4].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 4 (fmAlarmFaultCode)) specified: "+
                    fmAlarmEntry.getIndexPart(vbs[4].getOid()));
        }

        // snmp4jDemoSparseTableCol6
        if (!(vbs[5].getOid().startsWith(oidFmAlarmMessage))) {
            throw new IllegalArgumentException("Variable 5 (fmAlarmMessage)) has wrong OID: " + vbs[5].getOid() +
                    " does not start with "+ oidFmAlarmMessage);
        }
        if (!fmAlarmEntryIndex.isValidIndex(fmAlarmEntry.getIndexPart(vbs[5].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 5 (fmAlarmMessage)) specified: "+
                    fmAlarmEntry.getIndexPart(vbs[5].getOid()));
        }

        // snmp4jDemoSparseTableCol7
        if (!(vbs[6].getOid().startsWith(oidFmAlarmComponentName))) {
            throw new IllegalArgumentException("Variable 6 (fmAlarmComponentName)) has wrong OID: " + vbs[6].getOid() +
                    " does not start with "+ oidFmAlarmComponentName);
        }
        if (!fmAlarmEntryIndex.isValidIndex(fmAlarmEntry.getIndexPart(vbs[6].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 6 (fmAlarmComponentName)) specified: "+
                    fmAlarmEntry.getIndexPart(vbs[6].getOid()));
        }

        // snmp4jDemoSparseTableCol8
        if (!(vbs[7].getOid().startsWith(oidFmAlarmEventType))) {
            throw new IllegalArgumentException("Variable 7 (fmAlarmEventType)) has wrong OID: " + vbs[7].getOid() +
                    " does not start with "+ oidFmAlarmEventType);
        }
        if (!fmAlarmEntryIndex.isValidIndex(fmAlarmEntry.getIndexPart(vbs[7].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 7 (fmAlarmEventType)) specified: "+
                    fmAlarmEntry.getIndexPart(vbs[7].getOid()));
        }

        // snmp4jDemoSparseTableCol9
        if (!(vbs[8].getOid().startsWith(oidFmAlarmProbableCause))) {
            throw new IllegalArgumentException("Variable 8 (fmAlarmProbableCause)) has wrong OID: " + vbs[8].getOid() +
                    " does not start with "+ oidFmAlarmProbableCause);
        }
        if (!fmAlarmEntryIndex.isValidIndex(fmAlarmEntry.getIndexPart(vbs[8].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 8 (fmAlarmProbableCause)) specified: "+
                    fmAlarmEntry.getIndexPart(vbs[8].getOid()));
        }

        // snmp4jDemoSparseTableCol10
        if (!(vbs[9].getOid().startsWith(oidFmAlarmAttributes))) {
            throw new IllegalArgumentException("Variable 9 (fmAlarmAttributes)) has wrong OID: " + vbs[9].getOid() +
                    " does not start with "+ oidFmAlarmAttributes);
        }
        if (!fmAlarmEntryIndex.isValidIndex(fmAlarmEntry.getIndexPart(vbs[9].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 9 (fmAlarmAttributes)) specified: "+
                    fmAlarmEntry.getIndexPart(vbs[9].getOid()));
        }

        notificationOriginator.notify(context, oidFmAlarmNotification, vbs);
    }

    public void initializeTable() {
        fmAlarmEntryModel.clear();

        Variable[] values = new Variable[fmAlarmEntry.getColumnCount()];
        int colCount = fmAlarmEntry.getColumnCount();
        for (int i = 0; i < colCount; i++) {
            if (i == 0) {
                values[i] = new UnsignedInteger32(1);
            } else if (i == 3) {
                values[i] = new UnsignedInteger32(FmSeverity.minor);
            } else if (i == 7) {
                values[i] = new UnsignedInteger32(IANAItuEventType.communicationsAlarm);
            } else if (i == 8) {
                values[i] = new UnsignedInteger32(IANAItuProbableCause.aIS);
            } else {
                values[i] = new OctetString(String.valueOf(i) + "bbbbbb");
            }
        }

        FmAlarmEntryRow fmAlarmEntryRow1 = new FmAlarmEntryRow(new OID(new int[] { 1 }), values);
        FmAlarmEntryRow fmAlarmEntryRow2 = new FmAlarmEntryRow(new OID(new int[] { 2 }), values);
        FmAlarmEntryRow fmAlarmEntryRow3 = new FmAlarmEntryRow(new OID(new int[] { 3 }), values);
        FmAlarmEntryRow fmAlarmEntryRow4 = new FmAlarmEntryRow(new OID(new int[] { 4 }), values);

        fmAlarmEntryModel.addRow(fmAlarmEntryRow1);
        fmAlarmEntryModel.addRow(fmAlarmEntryRow2);
        fmAlarmEntryModel.addRow(fmAlarmEntryRow3);
        fmAlarmEntryModel.addRow(fmAlarmEntryRow4);

        removeRow(2);
        removeRow(1);
    }

    public void addRow(OID oid, Variable[] values) {
        FmAlarmEntryRow fmAlarmEntryRow = new FmAlarmEntryRow(oid, values);

        fmAlarmEntryModel.addRow(fmAlarmEntryRow);
    }

    public void addRow(int oid, Variable[] values) {
        FmAlarmEntryRow fmAlarmEntryRow = new FmAlarmEntryRow(new OID(new int[] { oid }), values);

        fmAlarmEntryModel.addRow(fmAlarmEntryRow);
    }

    public void removeRow(OID oid) {
        fmAlarmEntryModel.removeRow(oid);
    }

    public void removeRow(int oid) {
        fmAlarmEntryModel.removeRow(new OID(new int[] { oid }));
    }

    public void clearTable() {
        fmAlarmEntryModel.clear();
    }


    // Value Validators
    /**
     * The {@code FmAlarmIdValidator} implements the value
     * validation for {@code Snmp4jDemoSparseTableCol1}.
     */
    static class FmAlarmIdValidator implements MOValueValidationListener {

        public static final String pattern = "^[a-zA-Z0-9_\\-\\.]{1,256}$";

        public void validate(MOValueValidationEvent validationEvent) {
            Variable newValue = validationEvent.getNewValue();
            OctetString os = (OctetString)newValue;
            if (!(((os.length() >= 0) && (os.length() <= 10)))) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
                return;
            } else if (!os.toString().matches(pattern)) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_BAD_VALUE);
                return;
            }
            //--AgentGen BEGIN=snmp4jDemoSparseTableCol1::validate
            //--AgentGen END
        }
    }
    /**
     * The {@code FmAlarmNodeNameValidator} implements the value
     * validation for {@code Snmp4jDemoSparseTableCol2}.
     */
    static class FmAlarmNodeNameValidator implements MOValueValidationListener {

        public void validate(MOValueValidationEvent validationEvent) {
            Variable newValue = validationEvent.getNewValue();
            OctetString os = (OctetString)newValue;
            if (!(((os.length() >= 0) && (os.length() <= 10)))) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
                return;
            }
            //--AgentGen BEGIN=snmp4jDemoSparseTableCol2::validate
            //--AgentGen END
        }
    }
    /**
     * The {@code FmAlarmDateAndTimeValidator} implements the value
     * validation for {@code Snmp4jDemoSparseTableCol3}.
     */
    static class FmAlarmDateAndTimeValidator implements MOValueValidationListener {

        public void validate(MOValueValidationEvent validationEvent) {
            Variable newValue = validationEvent.getNewValue();
            OctetString os = (OctetString)newValue;
            if (!(((os.length() >= 0) && (os.length() <= 10)))) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
                return;
            }
            //--AgentGen BEGIN=snmp4jDemoSparseTableCol3::validate
            //--AgentGen END
        }
    }
    /**
     * The {@code FmAlarmSeverityValidator} implements the value
     * validation for {@code Snmp4jDemoSparseTableCol4}.
     */
    static class FmAlarmSeverityValidator implements MOValueValidationListener {

        public void validate(MOValueValidationEvent validationEvent) {
            Variable newValue = validationEvent.getNewValue();
            OctetString os = (OctetString)newValue;
            if (!(((os.length() >= 0) && (os.length() <= 10)))) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
                return;
            }
            //--AgentGen BEGIN=snmp4jDemoSparseTableCol4::validate
            //--AgentGen END
        }
    }
    /**
     * The {@code FmAlarmFaultCodeValidator} implements the value
     * validation for {@code Snmp4jDemoSparseTableCol5}.
     */
    static class FmAlarmFaultCodeValidator implements MOValueValidationListener {

        public static final String pattern = "^[a-zA-Z0-9_\\-\\.]+$";

        public void validate(MOValueValidationEvent validationEvent) {
            Variable newValue = validationEvent.getNewValue();
            OctetString os = (OctetString)newValue;
            if (!(((os.length() >= 0) && (os.length() <= 10)))) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
                return;
            } else if (!os.toString().matches(pattern)) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_BAD_VALUE);
                return;
            }
            //--AgentGen BEGIN=snmp4jDemoSparseTableCol5::validate
            //--AgentGen END
        }
    }
    /**
     * The {@code FmAlarmMessageValidator} implements the value
     * validation for {@code Snmp4jDemoSparseTableCol6}.
     */
    static class FmAlarmMessageValidator implements MOValueValidationListener {

        public void validate(MOValueValidationEvent validationEvent) {
            Variable newValue = validationEvent.getNewValue();
            OctetString os = (OctetString)newValue;
            if (!(((os.length() >= 0) && (os.length() <= 10)))) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
                return;
            }
            //--AgentGen BEGIN=snmp4jDemoSparseTableCol6::validate
            //--AgentGen END
        }
    }
    /**
     * The {@code FmAlarmComponentNameValidator} implements the value
     * validation for {@code Snmp4jDemoSparseTableCol7}.
     */
    static class FmAlarmComponentNameValidator implements MOValueValidationListener {

        public void validate(MOValueValidationEvent validationEvent) {
            Variable newValue = validationEvent.getNewValue();
            OctetString os = (OctetString)newValue;
            if (!(((os.length() >= 0) && (os.length() <= 10)))) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
                return;
            }
            //--AgentGen BEGIN=snmp4jDemoSparseTableCol7::validate
            //--AgentGen END
        }
    }
    /**
     * The {@code FmAlarmEventTypeValidator} implements the value
     * validation for {@code Snmp4jDemoSparseTableCol8}.
     */
    static class FmAlarmEventTypeValidator implements MOValueValidationListener {

        public void validate(MOValueValidationEvent validationEvent) {
            Variable newValue = validationEvent.getNewValue();
            OctetString os = (OctetString)newValue;
            if (!(((os.length() >= 0) && (os.length() <= 10)))) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
                return;
            }
            //--AgentGen BEGIN=snmp4jDemoSparseTableCol8::validate
            //--AgentGen END
        }
    }
    /**
     * The {@code FmAlarmProbableCauseValidator} implements the value
     * validation for {@code Snmp4jDemoSparseTableCol9}.
     */
    static class FmAlarmProbableCauseValidator implements MOValueValidationListener {

        public void validate(MOValueValidationEvent validationEvent) {
            Variable newValue = validationEvent.getNewValue();
            OctetString os = (OctetString)newValue;
            if (!(((os.length() >= 0) && (os.length() <= 10)))) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
                return;
            }
            //--AgentGen BEGIN=snmp4jDemoSparseTableCol9::validate
            //--AgentGen END
        }
    }
    /**
     * The {@code FmAlarmAttributesValidator} implements the value
     * validation for {@code Snmp4jDemoSparseTableCol10}.
     */
    static class FmAlarmAttributesValidator implements MOValueValidationListener {

        public void validate(MOValueValidationEvent validationEvent) {
            Variable newValue = validationEvent.getNewValue();
            OctetString os = (OctetString)newValue;
            if (!(((os.length() >= 0) && (os.length() <= 10)))) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
                return;
            }
            //--AgentGen BEGIN=snmp4jDemoSparseTableCol10::validate
            //--AgentGen END
        }
    }

    public class FmAlarmEntryRow extends DefaultMOMutableRow2PC {

        //--AgentGen BEGIN=fmAlarmEntry::RowMembers
        //--AgentGen END

        public FmAlarmEntryRow(OID index, Variable[] values) {
            super(index, values);
            //--AgentGen BEGIN=fmAlarmEntry::RowConstructor
            //--AgentGen END
        }

        public UnsignedInteger32 getFmAlarmId() {
            //--AgentGen BEGIN=fmAlarmEntry::getSnmp4jDemoSparseTableCol1
            //--AgentGen END
            return (UnsignedInteger32) super.getValue(idxFmAlarmId);
        }

        public void setFmAlarmId(UnsignedInteger32 newColValue) {
            //--AgentGen BEGIN=fmAlarmEntry::setSnmp4jDemoSparseTableCol1
            //--AgentGen END
            super.setValue(idxFmAlarmId, newColValue);
        }

        public OctetString getFmAlarmNodeName() {
            //--AgentGen BEGIN=fmAlarmEntry::getSnmp4jDemoSparseTableCol2
            //--AgentGen END
            return (OctetString) super.getValue(idxFmAlarmNodeName);
        }

        public void setFmAlarmNodeName(OctetString newColValue) {
            //--AgentGen BEGIN=fmAlarmEntry::setSnmp4jDemoSparseTableCol2
            //--AgentGen END
            super.setValue(idxFmAlarmNodeName, newColValue);
        }

        public OctetString getFmAlarmDateAndTime() {
            //--AgentGen BEGIN=fmAlarmEntry::getSnmp4jDemoSparseTableCol3
            //--AgentGen END
            return (OctetString) super.getValue(idxFmAlarmDateAndTime);
        }

        public void setFmAlarmDateAndTime(OctetString newColValue) {
            //--AgentGen BEGIN=fmAlarmEntry::setSnmp4jDemoSparseTableCol3
            //--AgentGen END
            super.setValue(idxFmAlarmDateAndTime, newColValue);
        }

        public UnsignedInteger32 getFmAlarmSeverity() {
            //--AgentGen BEGIN=fmAlarmEntry::getSnmp4jDemoSparseTableCol4
            //--AgentGen END
            return (UnsignedInteger32) super.getValue(idxFmAlarmSeverity);
        }

        public void setFmAlarmSeverity(UnsignedInteger32 newColValue) {
            //--AgentGen BEGIN=fmAlarmEntry::setSnmp4jDemoSparseTableCol4
            //--AgentGen END
            super.setValue(idxFmAlarmSeverity, newColValue);
        }

        public OctetString getFmAlarmFaultCode() {
            //--AgentGen BEGIN=fmAlarmEntry::getSnmp4jDemoSparseTableCol5
            //--AgentGen END
            return (OctetString) super.getValue(idxFmAlarmFaultCode);
        }

        public void setFmAlarmFaultCode(OctetString newColValue) {
            //--AgentGen BEGIN=fmAlarmEntry::setSnmp4jDemoSparseTableCol5
            //--AgentGen END
            super.setValue(idxFmAlarmFaultCode, newColValue);
        }

        public OctetString getFmAlarmMessage() {
            //--AgentGen BEGIN=fmAlarmEntry::getSnmp4jDemoSparseTableCol6
            //--AgentGen END
            return (OctetString) super.getValue(idxFmAlarmMessage);
        }

        public void setFmAlarmMessage(OctetString newColValue) {
            //--AgentGen BEGIN=fmAlarmEntry::setSnmp4jDemoSparseTableCol6
            //--AgentGen END
            super.setValue(idxFmAlarmMessage, newColValue);
        }

        public OctetString getFmAlarmComponentName() {
            //--AgentGen BEGIN=fmAlarmEntry::getSnmp4jDemoSparseTableCol7
            //--AgentGen END
            return (OctetString) super.getValue(idxFmAlarmComponentName);
        }

        public void setFmAlarmComponentName(OctetString newColValue) {
            //--AgentGen BEGIN=fmAlarmEntry::setSnmp4jDemoSparseTableCol7
            //--AgentGen END
            super.setValue(idxFmAlarmComponentName, newColValue);
        }

        public UnsignedInteger32 getFmAlarmEventType() {
            //--AgentGen BEGIN=fmAlarmEntry::getSnmp4jDemoSparseTableCol8
            //--AgentGen END
            return (UnsignedInteger32) super.getValue(idxFmAlarmEventType);
        }

        public void setFmAlarmEventType(UnsignedInteger32 newColValue) {
            //--AgentGen BEGIN=fmAlarmEntry::setSnmp4jDemoSparseTableCol8
            //--AgentGen END
            super.setValue(idxFmAlarmEventType, newColValue);
        }

        public UnsignedInteger32 getFmAlarmProbableCause() {
            //--AgentGen BEGIN=fmAlarmEntry::getSnmp4jDemoSparseTableCol9
            //--AgentGen END
            return (UnsignedInteger32) super.getValue(idxFmAlarmProbableCause);
        }

        public void setFmAlarmProbableCause(UnsignedInteger32 newColValue) {
            //--AgentGen BEGIN=fmAlarmEntry::setSnmp4jDemoSparseTableCol9
            //--AgentGen END
            super.setValue(idxFmAlarmProbableCause, newColValue);
        }

        public OctetString getFmAlarmAttributes() {
            //--AgentGen BEGIN=fmAlarmEntry::getSnmp4jDemoSparseTableCol10
            //--AgentGen END
            return (OctetString) super.getValue(idxFmAlarmAttributes);
        }

        public void setFmAlarmAttributes(OctetString newColValue) {
            //--AgentGen BEGIN=fmAlarmEntry::setSnmp4jDemoSparseTableCol10
            //--AgentGen END
            super.setValue(idxFmAlarmAttributes, newColValue);
        }

        public Variable getValue(int column) {
            //--AgentGen BEGIN=fmAlarmEntry::RowGetValue
            //--AgentGen END
            switch(column) {
                case idxFmAlarmId:
                    return getFmAlarmId();
                case idxFmAlarmNodeName:
                    return getFmAlarmNodeName();
                case idxFmAlarmDateAndTime:
                    return getFmAlarmDateAndTime();
                case idxFmAlarmSeverity:
                    return getFmAlarmSeverity();
                case idxFmAlarmFaultCode:
                    return getFmAlarmFaultCode();
                case idxFmAlarmMessage:
                    return getFmAlarmMessage();
                case idxFmAlarmComponentName:
                    return getFmAlarmComponentName();
                case idxFmAlarmEventType:
                    return getFmAlarmEventType();
                case idxFmAlarmProbableCause:
                    return getFmAlarmProbableCause();
                case idxFmAlarmAttributes:
                    return getFmAlarmAttributes();
                default:
                    return super.getValue(column);
            }
        }

        public void setValue(int column, Variable value) {
            //--AgentGen BEGIN=fmAlarmEntry::RowSetValue
            //--AgentGen END
            switch(column) {
                case idxFmAlarmId:
                    setFmAlarmId((UnsignedInteger32)value);
                    break;
                case idxFmAlarmNodeName:
                    setFmAlarmNodeName((OctetString)value);
                    break;
                case idxFmAlarmDateAndTime:
                    setFmAlarmDateAndTime((OctetString)value);
                    break;
                case idxFmAlarmSeverity:
                    setFmAlarmSeverity((UnsignedInteger32)value);
                    break;
                case idxFmAlarmFaultCode:
                    setFmAlarmFaultCode((OctetString)value);
                    break;
                case idxFmAlarmMessage:
                    setFmAlarmMessage((OctetString)value);
                    break;
                case idxFmAlarmComponentName:
                    setFmAlarmComponentName((OctetString)value);
                    break;
                case idxFmAlarmEventType:
                    setFmAlarmEventType((UnsignedInteger32)value);
                    break;
                case idxFmAlarmProbableCause:
                    setFmAlarmProbableCause((UnsignedInteger32)value);
                    break;
                case idxFmAlarmAttributes:
                    setFmAlarmAttributes((OctetString)value);
                    break;
                default:
                    super.setValue(column, value);
            }
        }

        //--AgentGen BEGIN=fmAlarmEntry::Row
        //--AgentGen END
    }

    class FmAlarmEntryRowFactory
            implements MOTableRowFactory<FmAlarmEntryRow>
    {
        public synchronized FmAlarmEntryRow createRow(OID index, Variable[] values)
                throws UnsupportedOperationException
        {
            FmAlarmEntryRow row =
                    new FmAlarmEntryRow(index, values);
            //--AgentGen BEGIN=fmAlarmEntry::createRow
            //--AgentGen END
            return row;
        }

        public synchronized void freeRow(FmAlarmEntryRow row) {
            //--AgentGen BEGIN=fmAlarmEntry::freeRow
            //--AgentGen END
        }

        //--AgentGen BEGIN=fmAlarmEntry::RowFactory
        //--AgentGen END
    }


//--AgentGen BEGIN=_METHODS
//--AgentGen END

    // Textual Definitions of MIB module FmAlarmMib
    protected void addTCsToFactory(MOFactory moFactory) {
        moFactory.addTextualConvention(new FmAlarmColumn());
    }


    public class FmAlarmColumn implements TextualConvention<Variable> {

        public FmAlarmColumn() {
        }

        public String getModuleName() {
            return TC_MODULE_KTR_FM_MIB;
        }

        public String getName() {
            return TC_FMALARMCOLUMN;
        }

        public Variable createInitialValue() {
            Variable v = new OctetString();
            if (v instanceof AssignableFromLong) {
                ((AssignableFromLong)v).setValue(0L);
            }
            // further modify value to comply with TC constraints here:
            //--AgentGen BEGIN=FmAlarmColumn::createInitialValue
            //--AgentGen END
            return v;
        }

        public MOScalar<Variable> createScalar(OID oid, MOAccess access, Variable value) {
            MOScalar<Variable> scalar = moFactory.createScalar(oid, access, value);
            ConstraintsImpl vc = new ConstraintsImpl();
            vc.add(new Constraint(0L, 10L));
            scalar.addMOValueValidationListener(new ValueConstraintValidator(vc));
            //--AgentGen BEGIN=FmAlarmColumn::createScalar
            //--AgentGen END
            return scalar;
        }

        public MOColumn<Variable> createColumn(int columnID, int syntax, MOAccess access,
                                               Variable defaultValue, boolean mutableInService) {
            MOColumn<Variable> col = moFactory.createColumn(columnID, syntax, access, defaultValue, mutableInService);
            if (col instanceof MOMutableColumn) {
                MOMutableColumn<Variable> mcol = (MOMutableColumn<Variable>)col;
                ConstraintsImpl vc = new ConstraintsImpl();
                vc.add(new Constraint(0L, 10L));
                mcol.addMOValueValidationListener(new ValueConstraintValidator(vc));
            }
            //--AgentGen BEGIN=FmAlarmColumn::createColumn
            //--AgentGen END
            return col;
        }
    }

//--AgentGen BEGIN=_TC_CLASSES_IMPORTED_MODULES_BEGIN
//--AgentGen END

    // Textual Definitions of other MIB modules
    public void addImportedTCsToFactory(MOFactory moFactory) {
        moFactory.addTextualConvention(new IANAItuProbableCause(moFactory));
        moFactory.addTextualConvention(new IANAItuEventType(moFactory));
    }


//--AgentGen BEGIN=_TC_CLASSES_IMPORTED_MODULES_END
//--AgentGen END

//--AgentGen BEGIN=_CLASSES
//--AgentGen END

//--AgentGen BEGIN=_END
//--AgentGen END
}


