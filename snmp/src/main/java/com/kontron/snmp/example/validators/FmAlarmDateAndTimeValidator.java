package com.kontron.snmp.example.validators;

import org.snmp4j.agent.mo.MOValueValidationEvent;
import org.snmp4j.agent.mo.MOValueValidationListener;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.Variable;

/**
 * The {@code FmAlarmDateAndTimeValidator} implements the value
 * validation for {@code FmAlarmDateAndTime}.
 */
public class FmAlarmDateAndTimeValidator implements MOValueValidationListener {

    public void validate(MOValueValidationEvent validationEvent) {
        Variable newValue = validationEvent.getNewValue();
        OctetString os = (OctetString) newValue;
        if (!(((os.length() >= 0) && (os.length() <= 10)))) {
            validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
            return;
        }
    }
}