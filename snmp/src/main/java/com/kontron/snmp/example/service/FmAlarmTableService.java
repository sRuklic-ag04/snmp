package com.kontron.snmp.example.service;

import com.kontron.snmp.example.endpoint.request.FmAlarmTableRow;

public interface FmAlarmTableService {

    FmAlarmTableRow getRow(Integer id);

    FmAlarmTableRow addRow(FmAlarmTableRow fmAlarmTableRow);

    FmAlarmTableRow updateRow(FmAlarmTableRow fmAlarmTableRow);

    void deleteRow(Integer id);

    void deleteAll();
}
