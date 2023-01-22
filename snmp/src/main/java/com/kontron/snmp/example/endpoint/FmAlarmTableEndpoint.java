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
        return new ResponseEntity<>(fmAlarmTableService.getRow(id), HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> getRows() {
        return new ResponseEntity<>(fmAlarmTableService.getRows(), HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> addRow(@RequestBody FmAlarmTableRow fmAlarmTableRow) {
        fmAlarmTableService.addRow(fmAlarmTableRow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateRow(@PathVariable("id") Integer id, @RequestBody FmAlarmTableRow fmAlarmTableRow) {
        fmAlarmTableService.updateRow(fmAlarmTableRow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteRow(@PathVariable("id") Integer id) {
        fmAlarmTableService.deleteRow(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/")
    public ResponseEntity<?> deleteAllRows() {
        fmAlarmTableService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
