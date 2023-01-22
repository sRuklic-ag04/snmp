package com.kontron.snmp.example.endpoint.mapper;

import com.kontron.snmp.example.agent.FmAlarmEntryRow;
import com.kontron.snmp.example.endpoint.request.FmAlarmTableRow;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UnsignedInteger32;
import org.snmp4j.smi.Variable;
import org.springframework.stereotype.Component;

@Component
public class FmAlarmTableRowMapper {

    public Variable[] toVariableArray(FmAlarmTableRow fmAlarmTableRow) {
        Variable[] row = new Variable[10];

        row[0] = new UnsignedInteger32(fmAlarmTableRow.getFmAlarmId());
        row[1] = new OctetString(fmAlarmTableRow.getFmAlarmNodeName());
        row[2] = new OctetString(fmAlarmTableRow.getFmAlarmDateAndTime());
        row[3] = new UnsignedInteger32(fmAlarmTableRow.getFmAlarmSeverity());
        row[4] = new OctetString(fmAlarmTableRow.getFmAlarmFaultCode());
        row[5] = new OctetString(fmAlarmTableRow.getFmAlarmMessage());
        row[6] = new OctetString(fmAlarmTableRow.getFmAlarmComponentName());
        row[7] = new UnsignedInteger32(fmAlarmTableRow.getFmAlarmEventType());
        row[8] = new UnsignedInteger32(fmAlarmTableRow.getFmAlarmProbableCause());
        row[9] = new OctetString(fmAlarmTableRow.getFmAlarmAttributes());

        return row;
    }

    public FmAlarmTableRow toFmAlarmTableRow(FmAlarmEntryRow row) {
        FmAlarmTableRow fmAlarmTableRow = new FmAlarmTableRow();

        fmAlarmTableRow.setFmAlarmId(row.getFmAlarmId().toInt());
        fmAlarmTableRow.setFmAlarmNodeName(row.getFmAlarmNodeName().toString());
        fmAlarmTableRow.setFmAlarmDateAndTime(row.getFmAlarmDateAndTime().toString());
        fmAlarmTableRow.setFmAlarmSeverity(row.getFmAlarmSeverity().toInt());
        fmAlarmTableRow.setFmAlarmFaultCode(row.getFmAlarmFaultCode().toString());
        fmAlarmTableRow.setFmAlarmMessage(row.getFmAlarmMessage().toString());
        fmAlarmTableRow.setFmAlarmComponentName(row.getFmAlarmComponentName().toString());
        fmAlarmTableRow.setFmAlarmEventType(row.getFmAlarmEventType().toInt());
        fmAlarmTableRow.setFmAlarmProbableCause(row.getFmAlarmProbableCause().toInt());
        fmAlarmTableRow.setFmAlarmAttributes(row.getFmAlarmAttributes().toString());

        return fmAlarmTableRow;
    }
}
