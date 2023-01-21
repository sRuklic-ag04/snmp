package com.kontron.snmp.example.agent;

import org.snmp4j.agent.mo.DefaultMOMutableRow2PC;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UnsignedInteger32;
import org.snmp4j.smi.Variable;

import static com.kontron.snmp.example.agent.FmAlarmMib.*;

public class FmAlarmEntryRow extends DefaultMOMutableRow2PC {

    public FmAlarmEntryRow(OID index, Variable[] values) {
        super(index, values);
    }

    public UnsignedInteger32 getFmAlarmId() {
        return (UnsignedInteger32) super.getValue(idxFmAlarmId);
    }

    public void setFmAlarmId(UnsignedInteger32 newColValue) {
        super.setValue(idxFmAlarmId, newColValue);
    }

    public OctetString getFmAlarmNodeName() {
        return (OctetString) super.getValue(idxFmAlarmNodeName);
    }

    public void setFmAlarmNodeName(OctetString newColValue) {
        super.setValue(idxFmAlarmNodeName, newColValue);
    }

    public OctetString getFmAlarmDateAndTime() {
        return (OctetString) super.getValue(idxFmAlarmDateAndTime);
    }

    public void setFmAlarmDateAndTime(OctetString newColValue) {
        super.setValue(idxFmAlarmDateAndTime, newColValue);
    }

    public UnsignedInteger32 getFmAlarmSeverity() {
        return (UnsignedInteger32) super.getValue(idxFmAlarmSeverity);
    }

    public void setFmAlarmSeverity(UnsignedInteger32 newColValue) {
        super.setValue(idxFmAlarmSeverity, newColValue);
    }

    public OctetString getFmAlarmFaultCode() {
        return (OctetString) super.getValue(idxFmAlarmFaultCode);
    }

    public void setFmAlarmFaultCode(OctetString newColValue) {
        super.setValue(idxFmAlarmFaultCode, newColValue);
    }

    public OctetString getFmAlarmMessage() {
        return (OctetString) super.getValue(idxFmAlarmMessage);
    }

    public void setFmAlarmMessage(OctetString newColValue) {
        super.setValue(idxFmAlarmMessage, newColValue);
    }

    public OctetString getFmAlarmComponentName() {
        return (OctetString) super.getValue(idxFmAlarmComponentName);
    }

    public void setFmAlarmComponentName(OctetString newColValue) {
        super.setValue(idxFmAlarmComponentName, newColValue);
    }

    public UnsignedInteger32 getFmAlarmEventType() {
        return (UnsignedInteger32) super.getValue(idxFmAlarmEventType);
    }

    public void setFmAlarmEventType(UnsignedInteger32 newColValue) {
        super.setValue(idxFmAlarmEventType, newColValue);
    }

    public UnsignedInteger32 getFmAlarmProbableCause() {
        return (UnsignedInteger32) super.getValue(idxFmAlarmProbableCause);
    }

    public void setFmAlarmProbableCause(UnsignedInteger32 newColValue) {
        super.setValue(idxFmAlarmProbableCause, newColValue);
    }

    public OctetString getFmAlarmAttributes() {
        return (OctetString) super.getValue(idxFmAlarmAttributes);
    }

    public void setFmAlarmAttributes(OctetString newColValue) {
        super.setValue(idxFmAlarmAttributes, newColValue);
    }

    public Variable getValue(int column) {

        switch (column) {
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

        switch (column) {
            case idxFmAlarmId:
                setFmAlarmId((UnsignedInteger32) value);
                break;
            case idxFmAlarmNodeName:
                setFmAlarmNodeName((OctetString) value);
                break;
            case idxFmAlarmDateAndTime:
                setFmAlarmDateAndTime((OctetString) value);
                break;
            case idxFmAlarmSeverity:
                setFmAlarmSeverity((UnsignedInteger32) value);
                break;
            case idxFmAlarmFaultCode:
                setFmAlarmFaultCode((OctetString) value);
                break;
            case idxFmAlarmMessage:
                setFmAlarmMessage((OctetString) value);
                break;
            case idxFmAlarmComponentName:
                setFmAlarmComponentName((OctetString) value);
                break;
            case idxFmAlarmEventType:
                setFmAlarmEventType((UnsignedInteger32) value);
                break;
            case idxFmAlarmProbableCause:
                setFmAlarmProbableCause((UnsignedInteger32) value);
                break;
            case idxFmAlarmAttributes:
                setFmAlarmAttributes((OctetString) value);
                break;
            default:
                super.setValue(column, value);
        }
    }
}
