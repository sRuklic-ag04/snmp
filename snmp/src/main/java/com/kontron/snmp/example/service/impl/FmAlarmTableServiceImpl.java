package com.kontron.snmp.example.service.impl;

import com.kontron.snmp.example.agent.FmAlarmMib;
import com.kontron.snmp.example.endpoint.mapper.FmAlarmTableRowMapper;
import com.kontron.snmp.example.endpoint.request.FmAlarmTableRow;
import com.kontron.snmp.example.service.FmAlarmTableService;
import org.snmp4j.smi.OID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FmAlarmTableServiceImpl implements FmAlarmTableService {

    @Autowired
    private FmAlarmTableRowMapper fmAlarmTableRowMapper;

    @Override
    public FmAlarmTableRow getRow(Integer id) {
        return fmAlarmTableRowMapper.toFmAlarmTableRow(FmAlarmMib.getRow(new OID(new int[] { id })));
    }

    @Override
    public List<FmAlarmTableRow> getRows() {
        return FmAlarmMib.getRows().stream().map(( row ) -> fmAlarmTableRowMapper.toFmAlarmTableRow(row)).collect(Collectors.toList());
    }

    @Override
    public FmAlarmTableRow addRow(FmAlarmTableRow fmAlarmTableRow) {
        return fmAlarmTableRowMapper.toFmAlarmTableRow(FmAlarmMib.addRow(fmAlarmTableRowMapper.toVariableArray(fmAlarmTableRow)));
    }

    @Override
    public FmAlarmTableRow updateRow(Integer id, FmAlarmTableRow fmAlarmTableRow) {
        return fmAlarmTableRowMapper.toFmAlarmTableRow(FmAlarmMib.updateRow(new OID(new int[] {id}), fmAlarmTableRowMapper.toVariableArray(fmAlarmTableRow)));
    }

    @Override
    public void deleteRow(Integer id) {
        FmAlarmMib.removeRow(id);
    }

    @Override
    public void deleteAll() {
        FmAlarmMib.clearTable();
    }
}
