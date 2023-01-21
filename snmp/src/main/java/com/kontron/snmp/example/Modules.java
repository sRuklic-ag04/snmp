package com.kontron.snmp.example;

import com.kontron.snmp.example.agent.FmAlarmMib;
import org.snmp4j.agent.mo.*;
import org.snmp4j.log.LogFactory;
import org.snmp4j.log.LogAdapter;
import org.snmp4j.agent.MOGroup;
import org.snmp4j.agent.MOServer;
import org.snmp4j.agent.DuplicateRegistrationException;
import org.snmp4j.smi.OctetString;

public class Modules implements MOGroup {

    private static final LogAdapter LOGGER = LogFactory.getLogger(Modules.class);

    private FmAlarmMib fmAlarmMib;

    private MOFactory factory;

    public Modules() {
        fmAlarmMib = new FmAlarmMib();
    }

    public Modules(MOFactory factory) {
        fmAlarmMib = new FmAlarmMib(factory);
    }

    public void registerMOs(MOServer server, OctetString context) throws DuplicateRegistrationException {
        fmAlarmMib.registerMOs(server, context);
    }

    public void unregisterMOs(MOServer server, OctetString context) {
        fmAlarmMib.unregisterMOs(server, context);
    }

    public FmAlarmMib getFmAlarmMib() {
        return fmAlarmMib;
    }
}

