/*
 * Copyright (C) 2014 Tecomgroup.
 * All Rights Reserved.
 */

package com.kontron.snmp.example.enums;

import org.snmp4j.agent.MOAccess;
import org.snmp4j.agent.mo.MOColumn;
import org.snmp4j.agent.mo.MOFactory;
import org.snmp4j.agent.mo.MOMutableColumn;
import org.snmp4j.agent.mo.MOScalar;
import org.snmp4j.agent.mo.snmp.smi.EnumerationConstraint;
import org.snmp4j.agent.mo.snmp.smi.ValueConstraint;
import org.snmp4j.agent.mo.snmp.smi.ValueConstraintValidator;
import org.snmp4j.agent.mo.snmp.tc.TextualConvention;
import org.snmp4j.smi.AssignableFromLong;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.Variable;

/**
 * Textual convention IANAItuEventType from IANA-ITU-ALARM-TC-MIB.
 *
 * This class was extracted from a more common generated file.
 *
 * @generated
 * @author novohatskiy.r
 */
public class IANAItuEventType implements TextualConvention<Variable> {

    private static final String TC_IANAITUEVENTTYPE = "IANAItuEventType";
    private static final String TC_MODULE_IANA_ITU_ALARM_TC_MIB = "IANA-ITU-ALARM-TC-MIB";

    public static final int other = 1;
    public static final int communicationsAlarm = 2;
    public static final int qualityOfServiceAlarm = 3;
    public static final int processingErrorAlarm = 4;
    public static final int equipmentAlarm = 5;
    public static final int environmentalAlarm = 6;
    public static final int integrityViolation = 7;
    public static final int operationalViolation = 8;
    public static final int physicalViolation = 9;
    public static final int securityServiceOrMechanismViolation = 10;
    public static final int timeDomainViolation = 11;

    private final MOFactory moFactory;

    public IANAItuEventType(final MOFactory moFactory) {
        this.moFactory = moFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public MOColumn<Variable> createColumn(final int columnID,
                                           final int syntax, final MOAccess access,
                                           final Variable defaultValue, final boolean mutableInService) {
        final MOColumn<Variable> col = moFactory.createColumn(columnID, syntax,
                access, defaultValue, mutableInService);
        if (col instanceof MOMutableColumn) {
            final MOMutableColumn<Variable> mcol = (MOMutableColumn<Variable>) col;
            final ValueConstraint vc = new EnumerationConstraint(new int[]{
                    other,
                    communicationsAlarm,
                    qualityOfServiceAlarm,
                    processingErrorAlarm,
                    equipmentAlarm,
                    environmentalAlarm,
                    integrityViolation,
                    operationalViolation,
                    physicalViolation,
                    securityServiceOrMechanismViolation,
                    timeDomainViolation
            });
            mcol.addMOValueValidationListener(new ValueConstraintValidator(vc));
        }
        return col;
    }

    @Override
    public Variable createInitialValue() {
        final Variable v = new Integer32();
        if (v instanceof AssignableFromLong) {
            ((AssignableFromLong) v).setValue(1);
        }
        return v;
    }

    @SuppressWarnings("unchecked")
    @Override
    public MOScalar<Variable> createScalar(final OID oid,
                                           final MOAccess access, final Variable value) {
        final MOScalar<Variable> scalar = moFactory.createScalar(oid, access,
                value);
        final ValueConstraint vc = new EnumerationConstraint(new int[]{
                other,
                communicationsAlarm,
                qualityOfServiceAlarm,
                processingErrorAlarm,
                equipmentAlarm,
                environmentalAlarm,
                integrityViolation,
                operationalViolation,
                physicalViolation,
                securityServiceOrMechanismViolation,
                timeDomainViolation
        });
        scalar.addMOValueValidationListener(new ValueConstraintValidator(vc));
        return scalar;
    }

    @Override
    public String getModuleName() {
        return TC_MODULE_IANA_ITU_ALARM_TC_MIB;
    }

    @Override
    public String getName() {
        return TC_IANAITUEVENTTYPE;
    }
}