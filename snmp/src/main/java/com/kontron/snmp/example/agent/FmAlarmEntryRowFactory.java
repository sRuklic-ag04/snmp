package com.kontron.snmp.example.agent;

import org.snmp4j.agent.mo.MOTableRowFactory;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.Variable;

class FmAlarmEntryRowFactory implements MOTableRowFactory<FmAlarmEntryRow> {

    public synchronized FmAlarmEntryRow createRow(OID index, Variable[] values) throws UnsupportedOperationException {
        FmAlarmEntryRow row = new FmAlarmEntryRow(index, values);

        return row;
    }

    public synchronized void freeRow(FmAlarmEntryRow row) {
    }
}
