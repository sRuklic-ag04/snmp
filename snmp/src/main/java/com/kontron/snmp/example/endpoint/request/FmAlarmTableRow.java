package com.kontron.snmp.example.endpoint.request;

public class FmAlarmTableRow {
    private Integer fmAlarmId;
    private String fmAlarmNodeName;
    private String fmAlarmDateAndTime;
    private Integer fmAlarmSeverity;
    private String fmAlarmFaultCode;
    private String fmAlarmMessage;
    private String fmAlarmComponentName;
    private Integer fmAlarmEventType;
    private Integer fmAlarmProbableCause;
    private String fmAlarmAttributes;

    public Integer getFmAlarmId() {
        return fmAlarmId;
    }

    public void setFmAlarmId(Integer fmAlarmId) {
        this.fmAlarmId = fmAlarmId;
    }

    public String getFmAlarmNodeName() {
        return fmAlarmNodeName;
    }

    public void setFmAlarmNodeName(String fmAlarmNodeName) {
        this.fmAlarmNodeName = fmAlarmNodeName;
    }

    public String getFmAlarmDateAndTime() {
        return fmAlarmDateAndTime;
    }

    public void setFmAlarmDateAndTime(String fmAlarmDateAndTime) {
        this.fmAlarmDateAndTime = fmAlarmDateAndTime;
    }

    public Integer getFmAlarmSeverity() {
        return fmAlarmSeverity;
    }

    public void setFmAlarmSeverity(Integer fmAlarmSeverity) {
        this.fmAlarmSeverity = fmAlarmSeverity;
    }

    public String getFmAlarmFaultCode() {
        return fmAlarmFaultCode;
    }

    public void setFmAlarmFaultCode(String fmAlarmFaultCode) {
        this.fmAlarmFaultCode = fmAlarmFaultCode;
    }

    public String getFmAlarmMessage() {
        return fmAlarmMessage;
    }

    public void setFmAlarmMessage(String fmAlarmMessage) {
        this.fmAlarmMessage = fmAlarmMessage;
    }

    public String getFmAlarmComponentName() {
        return fmAlarmComponentName;
    }

    public void setFmAlarmComponentName(String fmAlarmComponentName) {
        this.fmAlarmComponentName = fmAlarmComponentName;
    }

    public Integer getFmAlarmEventType() {
        return fmAlarmEventType;
    }

    public void setFmAlarmEventType(Integer fmAlarmEventType) {
        this.fmAlarmEventType = fmAlarmEventType;
    }

    public Integer getFmAlarmProbableCause() {
        return fmAlarmProbableCause;
    }

    public void setFmAlarmProbableCause(Integer fmAlarmProbableCause) {
        this.fmAlarmProbableCause = fmAlarmProbableCause;
    }

    public String getFmAlarmAttributes() {
        return fmAlarmAttributes;
    }

    public void setFmAlarmAttributes(String fmAlarmAttributes) {
        this.fmAlarmAttributes = fmAlarmAttributes;
    }
}
