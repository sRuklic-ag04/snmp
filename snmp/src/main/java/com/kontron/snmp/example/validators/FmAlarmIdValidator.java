package com.kontron.snmp.example.validators;

import org.snmp4j.agent.mo.MOValueValidationEvent;
import org.snmp4j.agent.mo.MOValueValidationListener;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.Variable;

/**
 * The {@code FmAlarmIdValidator} implements the value
 * validation for {@code FmAlarmId}.
 */
public class FmAlarmIdValidator implements MOValueValidationListener {

    public static final String pattern = "^[a-zA-Z0-9_\\-\\.]{1,256}$";

    public void validate(MOValueValidationEvent validationEvent) {
        Variable newValue = validationEvent.getNewValue();
        OctetString os = (OctetString) newValue;
        if (!(((os.length() >= 0) && (os.length() <= 10)))) {
            validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
            return;
        } else if (!os.toString().matches(pattern)) {
            validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_BAD_VALUE);
            return;
        }
    }
}
