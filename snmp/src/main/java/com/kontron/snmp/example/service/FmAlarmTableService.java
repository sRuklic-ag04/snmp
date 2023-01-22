package com.kontron.snmp.example.service;

import com.kontron.snmp.example.endpoint.request.FmAlarmTableRow;

import java.util.List;

public interface FmAlarmTableService {

    FmAlarmTableRow getRow(Integer id);

    List<FmAlarmTableRow> getRows();

    FmAlarmTableRow addRow(FmAlarmTableRow fmAlarmTableRow);

    FmAlarmTableRow updateRow(Integer id, FmAlarmTableRow fmAlarmTableRow);

    void deleteRow(Integer id);

    void deleteAll();
}
