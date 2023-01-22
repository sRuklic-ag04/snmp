package com.kontron.snmp.example.endpoint;

import com.kontron.snmp.example.endpoint.request.FmAlarmTableRow;
import com.kontron.snmp.example.service.FmAlarmTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/snmp")
public class FmAlarmTableEndpoint {

    @Autowired
    private FmAlarmTableService fmAlarmTableService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getRow(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(fmAlarmTableService.getRow(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> getRows() {
        try {
            return new ResponseEntity<>(fmAlarmTableService.getRows(), HttpStatus.OK);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> addRow(@RequestBody FmAlarmTableRow fmAlarmTableRow) {
        try {
            FmAlarmTableRow fmAlarmTableRow1 = fmAlarmTableService.addRow(fmAlarmTableRow);
            return new ResponseEntity<>(fmAlarmTableRow1, HttpStatus.OK);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<?> updateRow(@PathVariable("id") Integer id, @RequestBody FmAlarmTableRow fmAlarmTableRow) {
        try {
            FmAlarmTableRow fmAlarmTableRow1 = fmAlarmTableService.updateRow(id, fmAlarmTableRow);
            return new ResponseEntity<>(fmAlarmTableRow1, HttpStatus.OK);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteRow(@PathVariable("id") Integer id) {
        try {
            fmAlarmTableService.deleteRow(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    @DeleteMapping(value = "/")
    public ResponseEntity<?> deleteAllRows() {
        try {
            fmAlarmTableService.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}
