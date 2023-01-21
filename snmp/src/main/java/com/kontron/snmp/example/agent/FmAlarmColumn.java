package com.kontron.snmp.example.agent;

import org.snmp4j.agent.MOAccess;
import org.snmp4j.agent.mo.MOColumn;
import org.snmp4j.agent.mo.MOFactory;
import org.snmp4j.agent.mo.MOMutableColumn;
import org.snmp4j.agent.mo.MOScalar;
import org.snmp4j.agent.mo.snmp.smi.Constraint;
import org.snmp4j.agent.mo.snmp.smi.ConstraintsImpl;
import org.snmp4j.agent.mo.snmp.smi.ValueConstraintValidator;
import org.snmp4j.agent.mo.snmp.tc.TextualConvention;
import org.snmp4j.smi.AssignableFromLong;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.Variable;

public class FmAlarmColumn implements TextualConvention<Variable> {

    private static final String TC_MODULE_KTR_FM_MIB = "KTR-FM-MIB";
    private static final String TC_FMALARMCOLUMN = "FmAlarmColumn";

    private MOFactory moFactory;

    public FmAlarmColumn(MOFactory moFactory) {
        this.moFactory = moFactory;
    }

    public FmAlarmColumn() {
    }

    public String getModuleName() {
        return TC_MODULE_KTR_FM_MIB;
    }

    public String getName() {
        return TC_FMALARMCOLUMN;
    }

    public Variable createInitialValue() {
        Variable v = new OctetString();
        if (v instanceof AssignableFromLong) {
            ((AssignableFromLong) v).setValue(0L);
        }

        return v;
    }

    public MOScalar<Variable> createScalar(OID oid, MOAccess access, Variable value) {
        MOScalar<Variable> scalar = moFactory.createScalar(oid, access, value);
        ConstraintsImpl vc = new ConstraintsImpl();
        vc.add(new Constraint(0L, 10L));
        scalar.addMOValueValidationListener(new ValueConstraintValidator(vc));

        return scalar;
    }

    public MOColumn<Variable> createColumn(int columnID, int syntax, MOAccess access, Variable defaultValue, boolean mutableInService) {
        MOColumn<Variable> col = moFactory.createColumn(columnID, syntax, access, defaultValue, mutableInService);
        if (col instanceof MOMutableColumn) {
            MOMutableColumn<Variable> mcol = (MOMutableColumn<Variable>) col;
            ConstraintsImpl vc = new ConstraintsImpl();
            vc.add(new Constraint(0L, 10L));
            mcol.addMOValueValidationListener(new ValueConstraintValidator(vc));
        }

        return col;
    }
}
