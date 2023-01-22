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
        try {
            return fmAlarmTableRowMapper.toFmAlarmTableRow(FmAlarmMib.getRow(new OID(new int[] { id })));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<FmAlarmTableRow> getRows() {
        try {
            return FmAlarmMib.getRows().stream().map(( row ) -> fmAlarmTableRowMapper.toFmAlarmTableRow(row)).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public FmAlarmTableRow addRow(FmAlarmTableRow fmAlarmTableRow) {
        try {
            FmAlarmMib.addRow(new OID( new int[] {fmAlarmTableRow.getFmAlarmId()}), fmAlarmTableRowMapper.toVariableArray(fmAlarmTableRow));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public FmAlarmTableRow updateRow(FmAlarmTableRow fmAlarmTableRow) {
        try {
            FmAlarmMib.updateRow(new OID(new int[] {fmAlarmTableRow.getFmAlarmId()}), fmAlarmTableRowMapper.toVariableArray(fmAlarmTableRow));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteRow(Integer id) {
        try {
            FmAlarmMib.removeRow(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAll() {
        try {
            FmAlarmMib.clearTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
