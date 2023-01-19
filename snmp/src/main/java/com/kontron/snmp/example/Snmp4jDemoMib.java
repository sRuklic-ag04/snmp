/*_############################################################################
  _## 
  _##  SNMP4J-Agent 3 - Snmp4jDemoMib.java  
  _## 
  _##  Copyright (C) 2005-2021  Frank Fock (SNMP4J.org)
  _##  
  _##  Licensed under the Apache License, Version 2.0 (the "License");
  _##  you may not use this file except in compliance with the License.
  _##  You may obtain a copy of the License at
  _##  
  _##      http://www.apache.org/licenses/LICENSE-2.0
  _##  
  _##  Unless required by applicable law or agreed to in writing, software
  _##  distributed under the License is distributed on an "AS IS" BASIS,
  _##  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  _##  See the License for the specific language governing permissions and
  _##  limitations under the License.
  _##  
  _##########################################################################*/

package com.kontron.snmp.example;
//--AgentGen BEGIN=_BEGIN
//--AgentGen END

import org.snmp4j.smi.*;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.agent.*;
import org.snmp4j.agent.mo.*;
import org.snmp4j.agent.mo.snmp.smi.*;
import org.snmp4j.log.LogFactory;
import org.snmp4j.log.LogAdapter;
import org.snmp4j.agent.mo.snmp.tc.*;

//--AgentGen BEGIN=_IMPORT
//--AgentGen END

public class Snmp4jDemoMib
//--AgentGen BEGIN=_EXTENDS
//--AgentGen END
        implements MOGroup
//--AgentGen BEGIN=_IMPLEMENTS
//--AgentGen END
{

    private static final LogAdapter LOGGER = LogFactory.getLogger(Snmp4jDemoMib.class);

    //--AgentGen BEGIN=_STATIC
    //--AgentGen END

    // Factory
    private MOFactory moFactory =
            DefaultMOFactory.getInstance();

    // Constants

    /**
     * OID of this MIB module for usage which can be
     * used for its identification.
     */
    public static final OID oidSnmp4jDemoMib =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2 });

    // Identities
    // Scalars

    // Tables

    // Notifications
    public static final OID oidSnmp4jSparseEvent =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,3,1 });
    public static final OID oidSnmp4jDemoSparseTableCol1 =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,2 });
    public static final OID oidSnmp4jDemoSparseTableCol2 =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,3 });
    public static final OID oidSnmp4jDemoSparseTableCol3 =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,4 });
    public static final OID oidSnmp4jDemoSparseTableCol4 =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,5 });
    public static final OID oidSnmp4jDemoSparseTableCol5 =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,6 });
    public static final OID oidSnmp4jDemoSparseTableCol6 =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,7 });
    public static final OID oidSnmp4jDemoSparseTableCol7 =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,8 });
    public static final OID oidSnmp4jDemoSparseTableCol8 =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,9 });
    public static final OID oidSnmp4jDemoSparseTableCol9 =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,10 });
    public static final OID oidSnmp4jDemoSparseTableCol10 =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,11 });



    // Enumerations
    public static final class FmSeverity {
        public static final int indeterminate = 1;
        public static final int cleared = 2;
        public static final int normal = 3;
        public static final int warning = 4;
        public static final int minor = 5;
        public static final int major = 6;
        public static final int critical = 7;
    }

    // TextualConventions
    private static final String TC_MODULE_SNMPV2_TC = "SNMPv2-TC";
    private static final String TC_MODULE_SNMP4J_DEMO_MIB = "SNMP4J-DEMO-MIB";
    private static final String TC_SPARSETABLECOLUMN = "SparseTableColumn";
    private static final String TC_STORAGETYPE = "StorageType";
    private static final String TC_DISPLAYSTRING = "DisplayString";
    private static final String TC_ROWSTATUS = "RowStatus";
    private static final String TC_TIMESTAMP = "TimeStamp";
    private static final String TC_IANAITUPROBABLECAUSE = "IANAItuProbableCause";
    private static final String TC_IANAITUEVENTTYPE = "IANAItuEventType";

    // Scalars

    // Column TC definitions for snmp4jDemoEntry:
    public static final String tcModuleSNMPv2Tc = "SNMPv2-TC";
    public static final String tcDefTimeStamp = "TimeStamp";
    public static final String tcDefStorageType = "StorageType";
    public static final String tcDefRowStatus = "RowStatus";

    public static final OID oidSnmp4jDemoSparseEntry =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1 });

    // Index OID definitions
    public static final OID oidSnmp4jDemoSparseTableIndex =
            new OID(new int[] { 1,3,6,1,4,1,20306,11,2,1,1,1,1 });

    // Column TC definitions for snmp4jDemoSparseEntry:
    public static final String tcModuleSnmp4jDemoMib = "SNMP4J-DEMO-MIB";
    public static final String tcDefSparseTableColumn = "SparseTableColumn";

    // Column sub-identifier definitions for snmp4jDemoSparseEntry:
    public static final int colSnmp4jDemoSparseTableCol1 = 2;
    public static final int colSnmp4jDemoSparseTableCol2 = 3;
    public static final int colSnmp4jDemoSparseTableCol3 = 4;
    public static final int colSnmp4jDemoSparseTableCol4 = 5;
    public static final int colSnmp4jDemoSparseTableCol5 = 6;
    public static final int colSnmp4jDemoSparseTableCol6 = 7;
    public static final int colSnmp4jDemoSparseTableCol7 = 8;
    public static final int colSnmp4jDemoSparseTableCol8 = 9;
    public static final int colSnmp4jDemoSparseTableCol9 = 10;
    public static final int colSnmp4jDemoSparseTableCol10 = 11;

    // Column index definitions for snmp4jDemoSparseEntry:
    public static final int idxSnmp4jDemoSparseTableCol1 = 0;
    public static final int idxSnmp4jDemoSparseTableCol2 = 1;
    public static final int idxSnmp4jDemoSparseTableCol3 = 2;
    public static final int idxSnmp4jDemoSparseTableCol4 = 3;
    public static final int idxSnmp4jDemoSparseTableCol5 = 4;
    public static final int idxSnmp4jDemoSparseTableCol6 = 5;
    public static final int idxSnmp4jDemoSparseTableCol7 = 6;
    public static final int idxSnmp4jDemoSparseTableCol8 = 7;
    public static final int idxSnmp4jDemoSparseTableCol9 = 8;
    public static final int idxSnmp4jDemoSparseTableCol10 = 9;

    private MOTableSubIndex[] snmp4jDemoSparseEntryIndexes;
    private MOTableIndex snmp4jDemoSparseEntryIndex;

    @SuppressWarnings("rawtypes")
    private MOTable<Snmp4jDemoSparseEntryRow,
            MOColumn,
            MOMutableTableModel<Snmp4jDemoSparseEntryRow>> snmp4jDemoSparseEntry;
    private MOMutableTableModel<Snmp4jDemoSparseEntryRow> snmp4jDemoSparseEntryModel;


//--AgentGen BEGIN=_MEMBERS
//--AgentGen END

    /**
     * Constructs a Snmp4jDemoMib instance without actually creating its
     * {@code ManagedObject} instances. This has to be done in a
     * sub-class constructor or after construction by calling
     * {@link #createMO(MOFactory moFactory)}.
     */
    protected Snmp4jDemoMib() {
//--AgentGen BEGIN=_DEFAULTCONSTRUCTOR
//--AgentGen END
    }

    /**
     * Constructs a Snmp4jDemoMib instance and actually creates its
     * {@code ManagedObject} instances using the supplied
     * {@code MOFactory} (by calling
     * {@link #createMO(MOFactory moFactory)}).
     * @param moFactory
     *    the {@code MOFactory} to be used to create the
     *    managed objects for this module.
     */
    public Snmp4jDemoMib(MOFactory moFactory) {
        this();
        createMO(moFactory);
//--AgentGen BEGIN=_FACTORYCONSTRUCTOR
        initializeTable();
//--AgentGen END
    }

//--AgentGen BEGIN=_CONSTRUCTORS
//--AgentGen END

    /**
     * Create the ManagedObjects defined for this MIB module
     * using the specified {@link MOFactory}.
     * @param moFactory
     *    the {@code MOFactory} instance to use for object
     *    creation.
     */
    protected void createMO(MOFactory moFactory) {
        addTCsToFactory(moFactory);
        createSnmp4jDemoSparseEntry(moFactory);
    }

    @SuppressWarnings("rawtypes")
    public MOTable<Snmp4jDemoSparseEntryRow,MOColumn,MOMutableTableModel<Snmp4jDemoSparseEntryRow>> getSnmp4jDemoSparseEntry() {
        return snmp4jDemoSparseEntry;
    }


    @SuppressWarnings(value={"unchecked"})
    private void createSnmp4jDemoSparseEntry(MOFactory moFactory) {
        // Index definition
        snmp4jDemoSparseEntryIndexes =
                new MOTableSubIndex[] {
                        moFactory.createSubIndex(oidSnmp4jDemoSparseTableIndex,
                                SMIConstants.SYNTAX_INTEGER, 1, 1)    };

        snmp4jDemoSparseEntryIndex =
                moFactory.createIndex(snmp4jDemoSparseEntryIndexes,
                        false,
                        new MOTableIndexValidator() {
                            public boolean isValidIndex(OID index) {
                                boolean isValidIndex = true;
                                //--AgentGen BEGIN=snmp4jDemoSparseEntry::isValidIndex
                                //--AgentGen END
                                return isValidIndex;
                            }
                        });

        // Columns
        MOColumn<?>[] snmp4jDemoSparseEntryColumns = new MOColumn<?>[10];

        // col1 UnsignedInteger32
        snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol1] =
                new MOMutableColumn<UnsignedInteger32>(colSnmp4jDemoSparseTableCol1,
                        SMIConstants.SYNTAX_UNSIGNED_INTEGER32,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (UnsignedInteger32)null);
        ValueConstraint snmp4jDemoSparseTableCol1VC = new ConstraintsImpl();
        ((ConstraintsImpl)snmp4jDemoSparseTableCol1VC).add(new Constraint(0L, 10L));
        ((MOMutableColumn)snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol1]).
                addMOValueValidationListener(new ValueConstraintValidator(snmp4jDemoSparseTableCol1VC));
        ((MOMutableColumn)snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol1]).
                addMOValueValidationListener(new Snmp4jDemoSparseTableCol1Validator());

        // col2
        snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol2] =
                new MOMutableColumn<OctetString>(colSnmp4jDemoSparseTableCol2,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (OctetString)null);
        ValueConstraint snmp4jDemoSparseTableCol2VC = new ConstraintsImpl();
        ((ConstraintsImpl)snmp4jDemoSparseTableCol2VC).add(new Constraint(0L, 10L));
        ((MOMutableColumn)snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol2]).
                addMOValueValidationListener(new ValueConstraintValidator(snmp4jDemoSparseTableCol2VC));
        ((MOMutableColumn)snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol2]).
                addMOValueValidationListener(new Snmp4jDemoSparseTableCol2Validator());

        // col3
        snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol3] =
                new MOMutableColumn<OctetString>(colSnmp4jDemoSparseTableCol3,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (OctetString)null);
        ValueConstraint snmp4jDemoSparseTableCol3VC = new ConstraintsImpl();
        ((ConstraintsImpl)snmp4jDemoSparseTableCol3VC).add(new Constraint(0L, 10L));
        ((MOMutableColumn)snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol3]).
                addMOValueValidationListener(new ValueConstraintValidator(snmp4jDemoSparseTableCol3VC));
        ((MOMutableColumn)snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol3]).
                addMOValueValidationListener(new Snmp4jDemoSparseTableCol3Validator());

        // col4
        snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol4] =
                new MOMutableColumn<UnsignedInteger32>(colSnmp4jDemoSparseTableCol4,
                        SMIConstants.SYNTAX_UNSIGNED_INTEGER32,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (UnsignedInteger32)null);
        ValueConstraint snmp4jDemoSparseTableCol4VC = new EnumerationConstraint(
                new int[] {
                        FmSeverity.indeterminate,
                        FmSeverity.cleared,
                        FmSeverity.normal,
                        FmSeverity.warning,
                        FmSeverity.minor,
                        FmSeverity.major,
                        FmSeverity.critical
                }
        );
        ((MOMutableColumn)snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol4]).
                addMOValueValidationListener(new ValueConstraintValidator(snmp4jDemoSparseTableCol4VC));
        ((MOMutableColumn)snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol4]).
                addMOValueValidationListener(new Snmp4jDemoSparseTableCol4Validator());

        // col5
        snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol5] =
                new MOMutableColumn<OctetString>(colSnmp4jDemoSparseTableCol5,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (OctetString)null);
        ValueConstraint snmp4jDemoSparseTableCol5VC = new ConstraintsImpl();
        ((ConstraintsImpl)snmp4jDemoSparseTableCol5VC).add(new Constraint(0L, 10L));
        ((MOMutableColumn)snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol5]).
                addMOValueValidationListener(new ValueConstraintValidator(snmp4jDemoSparseTableCol5VC));
        ((MOMutableColumn)snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol5]).
                addMOValueValidationListener(new Snmp4jDemoSparseTableCol5Validator());

        // col6
        snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol6] =
                new MOMutableColumn<OctetString>(colSnmp4jDemoSparseTableCol6,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (OctetString)null);
        ValueConstraint snmp4jDemoSparseTableCol6VC = new ConstraintsImpl();
        ((ConstraintsImpl)snmp4jDemoSparseTableCol6VC).add(new Constraint(0L, 10L));
        ((MOMutableColumn)snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol6]).
                addMOValueValidationListener(new ValueConstraintValidator(snmp4jDemoSparseTableCol6VC));
        ((MOMutableColumn)snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol6]).
                addMOValueValidationListener(new Snmp4jDemoSparseTableCol6Validator());

        // col7
        snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol7] =
                new MOMutableColumn<OctetString>(colSnmp4jDemoSparseTableCol7,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (OctetString)null);
        ValueConstraint snmp4jDemoSparseTableCol7VC = new ConstraintsImpl();
        ((ConstraintsImpl)snmp4jDemoSparseTableCol7VC).add(new Constraint(0L, 10L));
        ((MOMutableColumn)snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol7]).
                addMOValueValidationListener(new ValueConstraintValidator(snmp4jDemoSparseTableCol7VC));
        ((MOMutableColumn)snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol7]).
                addMOValueValidationListener(new Snmp4jDemoSparseTableCol7Validator());

        // col8 IANAItuEventType
        snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol8] =
                new MOMutableColumn<UnsignedInteger32>(colSnmp4jDemoSparseTableCol8,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (UnsignedInteger32)null);
        ValueConstraint snmp4jDemoSparseTableCol8VC = new EnumerationConstraint(
                new int[] {
                        IANAItuEventType.other,
                        IANAItuEventType.communicationsAlarm,
                        IANAItuEventType.qualityOfServiceAlarm,
                        IANAItuEventType.processingErrorAlarm,
                        IANAItuEventType.equipmentAlarm,
                        IANAItuEventType.environmentalAlarm,
                        IANAItuEventType.integrityViolation,
                        IANAItuEventType.operationalViolation,
                        IANAItuEventType.physicalViolation,
                        IANAItuEventType.securityServiceOrMechanismViolation,
                        IANAItuEventType.timeDomainViolation
                }
        );
        ((MOMutableColumn)snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol8]).
                addMOValueValidationListener(new ValueConstraintValidator(snmp4jDemoSparseTableCol8VC));
        ((MOMutableColumn)snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol8]).
                addMOValueValidationListener(new Snmp4jDemoSparseTableCol8Validator());

        // col9 IANAItuProbableCause
        snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol9] =
                new MOMutableColumn<UnsignedInteger32>(colSnmp4jDemoSparseTableCol9,
                        SMIConstants.SYNTAX_UNSIGNED_INTEGER32,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (UnsignedInteger32)null);
        ValueConstraint snmp4jDemoSparseTableCol9VC = new EnumerationConstraint(
                new int[] {
                        IANAItuProbableCause.aIS,
                        IANAItuProbableCause.callSetUpFailure,
                        IANAItuProbableCause.degradedSignal,
                        IANAItuProbableCause.farEndReceiverFailure,
                        IANAItuProbableCause.framingError,
                        IANAItuProbableCause.lossOfFrame,
                        IANAItuProbableCause.lossOfPointer,
                        IANAItuProbableCause.lossOfSignal,
                        IANAItuProbableCause.payloadTypeMismatch,
                        IANAItuProbableCause.transmissionError,
                        IANAItuProbableCause.remoteAlarmInterface,
                        IANAItuProbableCause.excessiveBER,
                        IANAItuProbableCause.pathTraceMismatch,
                        IANAItuProbableCause.unavailable,
                        IANAItuProbableCause.signalLabelMismatch,
                        IANAItuProbableCause.lossOfMultiFrame,
                        IANAItuProbableCause.receiveFailure,
                        IANAItuProbableCause.transmitFailure,
                        IANAItuProbableCause.modulationFailure,
                        IANAItuProbableCause.demodulationFailure,
                        IANAItuProbableCause.broadcastChannelFailure,
                        IANAItuProbableCause.connectionEstablishmentError,
                        IANAItuProbableCause.invalidMessageReceived,
                        IANAItuProbableCause.localNodeTransmissionError,
                        IANAItuProbableCause.remoteNodeTransmissionError,
                        IANAItuProbableCause.routingFailure,
                        IANAItuProbableCause.backplaneFailure,
                        IANAItuProbableCause.dataSetProblem,
                        IANAItuProbableCause.equipmentIdentifierDuplication,
                        IANAItuProbableCause.externalIFDeviceProblem,
                        IANAItuProbableCause.lineCardProblem,
                        IANAItuProbableCause.multiplexerProblem,
                        IANAItuProbableCause.nEIdentifierDuplication,
                        IANAItuProbableCause.powerProblem,
                        IANAItuProbableCause.processorProblem,
                        IANAItuProbableCause.protectionPathFailure,
                        IANAItuProbableCause.receiverFailure,
                        IANAItuProbableCause.replaceableUnitMissing,
                        IANAItuProbableCause.replaceableUnitTypeMismatch,
                        IANAItuProbableCause.synchronizationSourceMismatch,
                        IANAItuProbableCause.terminalProblem,
                        IANAItuProbableCause.timingProblem,
                        IANAItuProbableCause.transmitterFailure,
                        IANAItuProbableCause.trunkCardProblem,
                        IANAItuProbableCause.replaceableUnitProblem,
                        IANAItuProbableCause.realTimeClockFailure,
                        IANAItuProbableCause.antennaFailure,
                        IANAItuProbableCause.batteryChargingFailure,
                        IANAItuProbableCause.diskFailure,
                        IANAItuProbableCause.frequencyHoppingFailure,
                        IANAItuProbableCause.iODeviceError,
                        IANAItuProbableCause.lossOfSynchronisation,
                        IANAItuProbableCause.lossOfRedundancy,
                        IANAItuProbableCause.powerSupplyFailure,
                        IANAItuProbableCause.signalQualityEvaluationFailure,
                        IANAItuProbableCause.tranceiverFailure,
                        IANAItuProbableCause.protectionMechanismFailure,
                        IANAItuProbableCause.protectingResourceFailure,
                        IANAItuProbableCause.airCompressorFailure,
                        IANAItuProbableCause.airConditioningFailure,
                        IANAItuProbableCause.airDryerFailure,
                        IANAItuProbableCause.batteryDischarging,
                        IANAItuProbableCause.batteryFailure,
                        IANAItuProbableCause.commercialPowerFailure,
                        IANAItuProbableCause.coolingFanFailure,
                        IANAItuProbableCause.engineFailure,
                        IANAItuProbableCause.fireDetectorFailure,
                        IANAItuProbableCause.fuseFailure,
                        IANAItuProbableCause.generatorFailure,
                        IANAItuProbableCause.lowBatteryThreshold,
                        IANAItuProbableCause.pumpFailure,
                        IANAItuProbableCause.rectifierFailure,
                        IANAItuProbableCause.rectifierHighVoltage,
                        IANAItuProbableCause.rectifierLowFVoltage,
                        IANAItuProbableCause.ventilationsSystemFailure,
                        IANAItuProbableCause.enclosureDoorOpen,
                        IANAItuProbableCause.explosiveGas,
                        IANAItuProbableCause.fire,
                        IANAItuProbableCause.flood,
                        IANAItuProbableCause.highHumidity,
                        IANAItuProbableCause.highTemperature,
                        IANAItuProbableCause.highWind,
                        IANAItuProbableCause.iceBuildUp,
                        IANAItuProbableCause.intrusionDetection,
                        IANAItuProbableCause.lowFuel,
                        IANAItuProbableCause.lowHumidity,
                        IANAItuProbableCause.lowCablePressure,
                        IANAItuProbableCause.lowTemperatue,
                        IANAItuProbableCause.lowWater,
                        IANAItuProbableCause.smoke,
                        IANAItuProbableCause.toxicGas,
                        IANAItuProbableCause.coolingSystemFailure,
                        IANAItuProbableCause.externalEquipmentFailure,
                        IANAItuProbableCause.externalPointFailure,
                        IANAItuProbableCause.storageCapacityProblem,
                        IANAItuProbableCause.memoryMismatch,
                        IANAItuProbableCause.corruptData,
                        IANAItuProbableCause.outOfCPUCycles,
                        IANAItuProbableCause.sfwrEnvironmentProblem,
                        IANAItuProbableCause.sfwrDownloadFailure,
                        IANAItuProbableCause.lossOfRealTimel,
                        IANAItuProbableCause.applicationSubsystemFailure,
                        IANAItuProbableCause.configurationOrCustomisationError,
                        IANAItuProbableCause.databaseInconsistency,
                        IANAItuProbableCause.fileError,
                        IANAItuProbableCause.outOfMemory,
                        IANAItuProbableCause.softwareError,
                        IANAItuProbableCause.timeoutExpired,
                        IANAItuProbableCause.underlayingResourceUnavailable,
                        IANAItuProbableCause.versionMismatch,
                        IANAItuProbableCause.bandwidthReduced,
                        IANAItuProbableCause.congestion,
                        IANAItuProbableCause.excessiveErrorRate,
                        IANAItuProbableCause.excessiveResponseTime,
                        IANAItuProbableCause.excessiveRetransmissionRate,
                        IANAItuProbableCause.reducedLoggingCapability,
                        IANAItuProbableCause.systemResourcesOverload,
                        IANAItuProbableCause.adapterError,
                        IANAItuProbableCause.applicationSubsystemFailture,
                        IANAItuProbableCause.bandwidthReducedX733,
                        IANAItuProbableCause.callEstablishmentError,
                        IANAItuProbableCause.communicationsProtocolError,
                        IANAItuProbableCause.communicationsSubsystemFailure,
                        IANAItuProbableCause.configurationOrCustomizationError,
                        IANAItuProbableCause.congestionX733,
                        IANAItuProbableCause.coruptData,
                        IANAItuProbableCause.cpuCyclesLimitExceeded,
                        IANAItuProbableCause.dataSetOrModemError,
                        IANAItuProbableCause.degradedSignalX733,
                        IANAItuProbableCause.dteDceInterfaceError,
                        IANAItuProbableCause.enclosureDoorOpenX733,
                        IANAItuProbableCause.equipmentMalfunction,
                        IANAItuProbableCause.excessiveVibration,
                        IANAItuProbableCause.fileErrorX733,
                        IANAItuProbableCause.fireDetected,
                        IANAItuProbableCause.framingErrorX733,
                        IANAItuProbableCause.heatingVentCoolingSystemProblem,
                        IANAItuProbableCause.humidityUnacceptable,
                        IANAItuProbableCause.inputOutputDeviceError,
                        IANAItuProbableCause.inputDeviceError,
                        IANAItuProbableCause.lanError,
                        IANAItuProbableCause.leakDetected,
                        IANAItuProbableCause.localNodeTransmissionErrorX733,
                        IANAItuProbableCause.lossOfFrameX733,
                        IANAItuProbableCause.lossOfSignalX733,
                        IANAItuProbableCause.materialSupplyExhausted,
                        IANAItuProbableCause.multiplexerProblemX733,
                        IANAItuProbableCause.outOfMemoryX733,
                        IANAItuProbableCause.ouputDeviceError,
                        IANAItuProbableCause.performanceDegraded,
                        IANAItuProbableCause.powerProblems,
                        IANAItuProbableCause.pressureUnacceptable,
                        IANAItuProbableCause.processorProblems,
                        IANAItuProbableCause.pumpFailureX733,
                        IANAItuProbableCause.queueSizeExceeded,
                        IANAItuProbableCause.receiveFailureX733,
                        IANAItuProbableCause.receiverFailureX733,
                        IANAItuProbableCause.remoteNodeTransmissionErrorX733,
                        IANAItuProbableCause.resourceAtOrNearingCapacity,
                        IANAItuProbableCause.responseTimeExecessive,
                        IANAItuProbableCause.retransmissionRateExcessive,
                        IANAItuProbableCause.softwareErrorX733,
                        IANAItuProbableCause.softwareProgramAbnormallyTerminated,
                        IANAItuProbableCause.softwareProgramError,
                        IANAItuProbableCause.storageCapacityProblemX733,
                        IANAItuProbableCause.temperatureUnacceptable,
                        IANAItuProbableCause.thresholdCrossed,
                        IANAItuProbableCause.timingProblemX733,
                        IANAItuProbableCause.toxicLeakDetected,
                        IANAItuProbableCause.transmitFailureX733,
                        IANAItuProbableCause.transmiterFailure,
                        IANAItuProbableCause.underlyingResourceUnavailable,
                        IANAItuProbableCause.versionMismatchX733,
                        IANAItuProbableCause.authenticationFailure,
                        IANAItuProbableCause.breachOfConfidentiality,
                        IANAItuProbableCause.cableTamper,
                        IANAItuProbableCause.delayedInformation,
                        IANAItuProbableCause.denialOfService,
                        IANAItuProbableCause.duplicateInformation,
                        IANAItuProbableCause.informationMissing,
                        IANAItuProbableCause.informationModificationDetected,
                        IANAItuProbableCause.informationOutOfSequence,
                        IANAItuProbableCause.keyExpired,
                        IANAItuProbableCause.nonRepudiationFailure,
                        IANAItuProbableCause.outOfHoursActivity,
                        IANAItuProbableCause.outOfService,
                        IANAItuProbableCause.proceduralError,
                        IANAItuProbableCause.unauthorizedAccessAttempt,
                        IANAItuProbableCause.unexpectedInformation,
                        IANAItuProbableCause.other,
                }
        );
        ((MOMutableColumn)snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol9]).
                addMOValueValidationListener(new ValueConstraintValidator(snmp4jDemoSparseTableCol9VC));
        ((MOMutableColumn)snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol9]).
                addMOValueValidationListener(new Snmp4jDemoSparseTableCol9Validator());

        // col10
        snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol10] =
                new MOMutableColumn<OctetString>(colSnmp4jDemoSparseTableCol10,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (OctetString)null);
        ValueConstraint snmp4jDemoSparseTableCol10VC = new ConstraintsImpl();
        ((ConstraintsImpl)snmp4jDemoSparseTableCol10VC).add(new Constraint(0L, 10L));
        ((MOMutableColumn)snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol10]).
                addMOValueValidationListener(new ValueConstraintValidator(snmp4jDemoSparseTableCol10VC));
        ((MOMutableColumn)snmp4jDemoSparseEntryColumns[idxSnmp4jDemoSparseTableCol10]).
                addMOValueValidationListener(new Snmp4jDemoSparseTableCol10Validator());

        // Table model
        snmp4jDemoSparseEntryModel =
                moFactory.createTableModel(oidSnmp4jDemoSparseEntry,
                        snmp4jDemoSparseEntryIndex,
                        snmp4jDemoSparseEntryColumns);
        snmp4jDemoSparseEntryModel.setRowFactory(new Snmp4jDemoSparseEntryRowFactory());
        snmp4jDemoSparseEntry =
                moFactory.createTable(oidSnmp4jDemoSparseEntry,
                        snmp4jDemoSparseEntryIndex,
                        snmp4jDemoSparseEntryColumns,
                        snmp4jDemoSparseEntryModel);
    }



    public void registerMOs(MOServer server, OctetString context)
            throws DuplicateRegistrationException
    {
        // Scalar Objects
        server.register(this.snmp4jDemoSparseEntry, context);
//--AgentGen BEGIN=_registerMOs
//--AgentGen END
    }

    public void unregisterMOs(MOServer server, OctetString context) {
        // Scalar Objects
        server.unregister(this.snmp4jDemoSparseEntry, context);
//--AgentGen BEGIN=_unregisterMOs
//--AgentGen END
    }

    // Notifications
    public void snmp4jDemoEvent(NotificationOriginator notificationOriginator,
                                OctetString context, VariableBinding[] vbs) {
        if (vbs.length < 10) {
            throw new IllegalArgumentException("Too few notification objects (snmp4jDemoEvent): "+
                    vbs.length+" < 10");
        }

        // snmp4jDemoSparseTableCol1
        if (!(vbs[0].getOid().startsWith(oidSnmp4jDemoSparseTableCol1))) {
            throw new IllegalArgumentException("Variable 0 (snmp4jDemoSparseTableCol1)) has wrong OID: " + vbs[0].getOid() +
                    " does not start with "+ oidSnmp4jDemoSparseTableCol1);
        }
        if (!snmp4jDemoSparseEntryIndex.isValidIndex(snmp4jDemoSparseEntry.getIndexPart(vbs[0].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 0 (snmp4jDemoSparseTableCol1)) specified: "+
                    snmp4jDemoSparseEntry.getIndexPart(vbs[0].getOid()));
        }

        // snmp4jDemoSparseTableCol2
        if (!(vbs[1].getOid().startsWith(oidSnmp4jDemoSparseTableCol2))) {
            throw new IllegalArgumentException("Variable 0 (snmp4jDemoSparseTableCol2)) has wrong OID: " + vbs[1].getOid() +
                    " does not start with "+ oidSnmp4jDemoSparseTableCol2);
        }
        if (!snmp4jDemoSparseEntryIndex.isValidIndex(snmp4jDemoSparseEntry.getIndexPart(vbs[1].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 0 (snmp4jDemoSparseTableCol2)) specified: "+
                    snmp4jDemoSparseEntry.getIndexPart(vbs[1].getOid()));
        }

        // snmp4jDemoSparseTableCol3
        if (!(vbs[2].getOid().startsWith(oidSnmp4jDemoSparseTableCol3))) {
            throw new IllegalArgumentException("Variable 0 (snmp4jDemoSparseTableCol3)) has wrong OID: " + vbs[2].getOid() +
                    " does not start with "+ oidSnmp4jDemoSparseTableCol3);
        }
        if (!snmp4jDemoSparseEntryIndex.isValidIndex(snmp4jDemoSparseEntry.getIndexPart(vbs[2].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 0 (snmp4jDemoSparseTableCol3)) specified: "+
                    snmp4jDemoSparseEntry.getIndexPart(vbs[2].getOid()));
        }

        // snmp4jDemoSparseTableCol4
        if (!(vbs[3].getOid().startsWith(oidSnmp4jDemoSparseTableCol4))) {
            throw new IllegalArgumentException("Variable 0 (snmp4jDemoSparseTableCol4)) has wrong OID: " + vbs[3].getOid() +
                    " does not start with "+ oidSnmp4jDemoSparseTableCol4);
        }
        if (!snmp4jDemoSparseEntryIndex.isValidIndex(snmp4jDemoSparseEntry.getIndexPart(vbs[3].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 0 (snmp4jDemoSparseTableCol4)) specified: "+
                    snmp4jDemoSparseEntry.getIndexPart(vbs[3].getOid()));
        }

        // snmp4jDemoSparseTableCol5
        if (!(vbs[4].getOid().startsWith(oidSnmp4jDemoSparseTableCol5))) {
            throw new IllegalArgumentException("Variable 0 (snmp4jDemoSparseTableCol5)) has wrong OID: " + vbs[4].getOid() +
                    " does not start with "+ oidSnmp4jDemoSparseTableCol5);
        }
        if (!snmp4jDemoSparseEntryIndex.isValidIndex(snmp4jDemoSparseEntry.getIndexPart(vbs[4].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 0 (snmp4jDemoSparseTableCol5)) specified: "+
                    snmp4jDemoSparseEntry.getIndexPart(vbs[4].getOid()));
        }

        // snmp4jDemoSparseTableCol6
        if (!(vbs[5].getOid().startsWith(oidSnmp4jDemoSparseTableCol6))) {
            throw new IllegalArgumentException("Variable 0 (snmp4jDemoSparseTableCol6)) has wrong OID: " + vbs[5].getOid() +
                    " does not start with "+ oidSnmp4jDemoSparseTableCol6);
        }
        if (!snmp4jDemoSparseEntryIndex.isValidIndex(snmp4jDemoSparseEntry.getIndexPart(vbs[5].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 0 (snmp4jDemoSparseTableCol6)) specified: "+
                    snmp4jDemoSparseEntry.getIndexPart(vbs[5].getOid()));
        }

        // snmp4jDemoSparseTableCol7
        if (!(vbs[6].getOid().startsWith(oidSnmp4jDemoSparseTableCol7))) {
            throw new IllegalArgumentException("Variable 0 (snmp4jDemoSparseTableCol7)) has wrong OID: " + vbs[6].getOid() +
                    " does not start with "+ oidSnmp4jDemoSparseTableCol7);
        }
        if (!snmp4jDemoSparseEntryIndex.isValidIndex(snmp4jDemoSparseEntry.getIndexPart(vbs[6].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 0 (snmp4jDemoSparseTableCol7)) specified: "+
                    snmp4jDemoSparseEntry.getIndexPart(vbs[6].getOid()));
        }

        // snmp4jDemoSparseTableCol8
        if (!(vbs[7].getOid().startsWith(oidSnmp4jDemoSparseTableCol8))) {
            throw new IllegalArgumentException("Variable 0 (snmp4jDemoSparseTableCol8)) has wrong OID: " + vbs[7].getOid() +
                    " does not start with "+ oidSnmp4jDemoSparseTableCol8);
        }
        if (!snmp4jDemoSparseEntryIndex.isValidIndex(snmp4jDemoSparseEntry.getIndexPart(vbs[7].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 0 (snmp4jDemoSparseTableCol8)) specified: "+
                    snmp4jDemoSparseEntry.getIndexPart(vbs[7].getOid()));
        }

        // snmp4jDemoSparseTableCol9
        if (!(vbs[8].getOid().startsWith(oidSnmp4jDemoSparseTableCol9))) {
            throw new IllegalArgumentException("Variable 0 (snmp4jDemoSparseTableCol9)) has wrong OID: " + vbs[8].getOid() +
                    " does not start with "+ oidSnmp4jDemoSparseTableCol9);
        }
        if (!snmp4jDemoSparseEntryIndex.isValidIndex(snmp4jDemoSparseEntry.getIndexPart(vbs[8].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 0 (snmp4jDemoSparseTableCol9)) specified: "+
                    snmp4jDemoSparseEntry.getIndexPart(vbs[8].getOid()));
        }

        // snmp4jDemoSparseTableCol10
        if (!(vbs[9].getOid().startsWith(oidSnmp4jDemoSparseTableCol10))) {
            throw new IllegalArgumentException("Variable 0 (snmp4jDemoSparseTableCol10)) has wrong OID: " + vbs[9].getOid() +
                    " does not start with "+ oidSnmp4jDemoSparseTableCol10);
        }
        if (!snmp4jDemoSparseEntryIndex.isValidIndex(snmp4jDemoSparseEntry.getIndexPart(vbs[9].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 0 (snmp4jDemoSparseTableCol10)) specified: "+
                    snmp4jDemoSparseEntry.getIndexPart(vbs[9].getOid()));
        }

        notificationOriginator.notify(context, oidSnmp4jSparseEvent, vbs);
    }

    public void initializeTable() {
        snmp4jDemoSparseEntryModel.clear();

        Variable[] values = new Variable[snmp4jDemoSparseEntry.getColumnCount()];
        int colCount = snmp4jDemoSparseEntry.getColumnCount();
        for (int i = 0; i < colCount; i++) {
            if (i == 0) {
                values[i] = new UnsignedInteger32(1);
            } else if (i == 3) {
                values[i] = new UnsignedInteger32(FmSeverity.minor);
            } else if (i == 7) {
                values[i] = new UnsignedInteger32(IANAItuEventType.communicationsAlarm);
            } else if (i == 8) {
                values[i] = new UnsignedInteger32(IANAItuProbableCause.aIS);
            } else {
                values[i] = new OctetString(String.valueOf(i) + "@aaaa$$#");
            }
        }
        Snmp4jDemoSparseEntryRow sparseEntryRow1 = new Snmp4jDemoSparseEntryRow(new OID(new int[] { 1 }), values);
        Snmp4jDemoSparseEntryRow sparseEntryRow2 = new Snmp4jDemoSparseEntryRow(new OID(new int[] { 2 }), values);
        Snmp4jDemoSparseEntryRow sparseEntryRow3 = new Snmp4jDemoSparseEntryRow(new OID(new int[] { 3 }), values);
        Snmp4jDemoSparseEntryRow sparseEntryRow4 = new Snmp4jDemoSparseEntryRow(new OID(new int[] { 4 }), values);

        snmp4jDemoSparseEntryModel.addRow(sparseEntryRow1);
        snmp4jDemoSparseEntryModel.addRow(sparseEntryRow2);
        snmp4jDemoSparseEntryModel.addRow(sparseEntryRow3);
        snmp4jDemoSparseEntryModel.addRow(sparseEntryRow4);

        removeRow(2);
        removeRow(1);


    }

    public void addRow(OID oid, Variable[] values) {
        Snmp4jDemoSparseEntryRow sparseEntryRow = new Snmp4jDemoSparseEntryRow(oid, values);

        snmp4jDemoSparseEntryModel.addRow(sparseEntryRow);
    }

    public void addRow(int oid, Variable[] values) {
        Snmp4jDemoSparseEntryRow sparseEntryRow = new Snmp4jDemoSparseEntryRow(new OID(new int[] { oid }), values);

        snmp4jDemoSparseEntryModel.addRow(sparseEntryRow);
    }

    public void removeRow(OID oid) {
        snmp4jDemoSparseEntryModel.removeRow(oid);
    }

    public void removeRow(int oid) {
        snmp4jDemoSparseEntryModel.removeRow(new OID(new int[] { oid }));
    }

    public void clearTable() {
        snmp4jDemoSparseEntryModel.clear();
    }


    // Value Validators
    /**
     * The {@code Snmp4jDemoSparseTableCol1Validator} implements the value
     * validation for {@code Snmp4jDemoSparseTableCol1}.
     */
    static class Snmp4jDemoSparseTableCol1Validator implements MOValueValidationListener {

        public static final String pattern = "^[a-zA-Z0-9_\\-\\.]{1,256}$";

        public void validate(MOValueValidationEvent validationEvent) {
            Variable newValue = validationEvent.getNewValue();
            OctetString os = (OctetString)newValue;
            if (!(((os.length() >= 0) && (os.length() <= 10)))) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
                return;
            } else if (!os.toString().matches(pattern)) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_BAD_VALUE);
                return;
            }
            //--AgentGen BEGIN=snmp4jDemoSparseTableCol1::validate
            //--AgentGen END
        }
    }
    /**
     * The {@code Snmp4jDemoSparseTableCol2Validator} implements the value
     * validation for {@code Snmp4jDemoSparseTableCol2}.
     */
    static class Snmp4jDemoSparseTableCol2Validator implements MOValueValidationListener {

        public void validate(MOValueValidationEvent validationEvent) {
            Variable newValue = validationEvent.getNewValue();
            OctetString os = (OctetString)newValue;
            if (!(((os.length() >= 0) && (os.length() <= 10)))) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
                return;
            }
            //--AgentGen BEGIN=snmp4jDemoSparseTableCol2::validate
            //--AgentGen END
        }
    }
    /**
     * The {@code Snmp4jDemoSparseTableCol3Validator} implements the value
     * validation for {@code Snmp4jDemoSparseTableCol3}.
     */
    static class Snmp4jDemoSparseTableCol3Validator implements MOValueValidationListener {

        public void validate(MOValueValidationEvent validationEvent) {
            Variable newValue = validationEvent.getNewValue();
            OctetString os = (OctetString)newValue;
            if (!(((os.length() >= 0) && (os.length() <= 10)))) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
                return;
            }
            //--AgentGen BEGIN=snmp4jDemoSparseTableCol3::validate
            //--AgentGen END
        }
    }
    /**
     * The {@code Snmp4jDemoSparseTableCol4Validator} implements the value
     * validation for {@code Snmp4jDemoSparseTableCol4}.
     */
    static class Snmp4jDemoSparseTableCol4Validator implements MOValueValidationListener {

        public void validate(MOValueValidationEvent validationEvent) {
            Variable newValue = validationEvent.getNewValue();
            OctetString os = (OctetString)newValue;
            if (!(((os.length() >= 0) && (os.length() <= 10)))) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
                return;
            }
            //--AgentGen BEGIN=snmp4jDemoSparseTableCol4::validate
            //--AgentGen END
        }
    }
    /**
     * The {@code Snmp4jDemoSparseTableCol5Validator} implements the value
     * validation for {@code Snmp4jDemoSparseTableCol5}.
     */
    static class Snmp4jDemoSparseTableCol5Validator implements MOValueValidationListener {

        public static final String pattern = "^[a-zA-Z0-9_\\-\\.]+$";

        public void validate(MOValueValidationEvent validationEvent) {
            Variable newValue = validationEvent.getNewValue();
            OctetString os = (OctetString)newValue;
            if (!(((os.length() >= 0) && (os.length() <= 10)))) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
                return;
            } else if (!os.toString().matches(pattern)) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_BAD_VALUE);
                return;
            }
            //--AgentGen BEGIN=snmp4jDemoSparseTableCol5::validate
            //--AgentGen END
        }
    }
    /**
     * The {@code Snmp4jDemoSparseTableCol6Validator} implements the value
     * validation for {@code Snmp4jDemoSparseTableCol6}.
     */
    static class Snmp4jDemoSparseTableCol6Validator implements MOValueValidationListener {

        public void validate(MOValueValidationEvent validationEvent) {
            Variable newValue = validationEvent.getNewValue();
            OctetString os = (OctetString)newValue;
            if (!(((os.length() >= 0) && (os.length() <= 10)))) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
                return;
            }
            //--AgentGen BEGIN=snmp4jDemoSparseTableCol6::validate
            //--AgentGen END
        }
    }
    /**
     * The {@code Snmp4jDemoSparseTableCol7Validator} implements the value
     * validation for {@code Snmp4jDemoSparseTableCol7}.
     */
    static class Snmp4jDemoSparseTableCol7Validator implements MOValueValidationListener {

        public void validate(MOValueValidationEvent validationEvent) {
            Variable newValue = validationEvent.getNewValue();
            OctetString os = (OctetString)newValue;
            if (!(((os.length() >= 0) && (os.length() <= 10)))) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
                return;
            }
            //--AgentGen BEGIN=snmp4jDemoSparseTableCol7::validate
            //--AgentGen END
        }
    }
    /**
     * The {@code Snmp4jDemoSparseTableCol8Validator} implements the value
     * validation for {@code Snmp4jDemoSparseTableCol8}.
     */
    static class Snmp4jDemoSparseTableCol8Validator implements MOValueValidationListener {

        public void validate(MOValueValidationEvent validationEvent) {
            Variable newValue = validationEvent.getNewValue();
            OctetString os = (OctetString)newValue;
            if (!(((os.length() >= 0) && (os.length() <= 10)))) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
                return;
            }
            //--AgentGen BEGIN=snmp4jDemoSparseTableCol8::validate
            //--AgentGen END
        }
    }
    /**
     * The {@code Snmp4jDemoSparseTableCol9Validator} implements the value
     * validation for {@code Snmp4jDemoSparseTableCol9}.
     */
    static class Snmp4jDemoSparseTableCol9Validator implements MOValueValidationListener {

        public void validate(MOValueValidationEvent validationEvent) {
            Variable newValue = validationEvent.getNewValue();
            OctetString os = (OctetString)newValue;
            if (!(((os.length() >= 0) && (os.length() <= 10)))) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
                return;
            }
            //--AgentGen BEGIN=snmp4jDemoSparseTableCol9::validate
            //--AgentGen END
        }
    }
    /**
     * The {@code Snmp4jDemoSparseTableCol10Validator} implements the value
     * validation for {@code Snmp4jDemoSparseTableCol10}.
     */
    static class Snmp4jDemoSparseTableCol10Validator implements MOValueValidationListener {

        public void validate(MOValueValidationEvent validationEvent) {
            Variable newValue = validationEvent.getNewValue();
            OctetString os = (OctetString)newValue;
            if (!(((os.length() >= 0) && (os.length() <= 10)))) {
                validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
                return;
            }
            //--AgentGen BEGIN=snmp4jDemoSparseTableCol10::validate
            //--AgentGen END
        }
    }

    public class Snmp4jDemoSparseEntryRow extends DefaultMOMutableRow2PC {

        //--AgentGen BEGIN=snmp4jDemoSparseEntry::RowMembers
        //--AgentGen END

        public Snmp4jDemoSparseEntryRow(OID index, Variable[] values) {
            super(index, values);
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::RowConstructor
            //--AgentGen END
        }

        public UnsignedInteger32 getSnmp4jDemoSparseTableCol1() {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::getSnmp4jDemoSparseTableCol1
            //--AgentGen END
            return (UnsignedInteger32) super.getValue(idxSnmp4jDemoSparseTableCol1);
        }

        public void setSnmp4jDemoSparseTableCol1(UnsignedInteger32 newColValue) {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::setSnmp4jDemoSparseTableCol1
            //--AgentGen END
            super.setValue(idxSnmp4jDemoSparseTableCol1, newColValue);
        }

        public OctetString getSnmp4jDemoSparseTableCol2() {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::getSnmp4jDemoSparseTableCol2
            //--AgentGen END
            return (OctetString) super.getValue(idxSnmp4jDemoSparseTableCol2);
        }

        public void setSnmp4jDemoSparseTableCol2(OctetString newColValue) {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::setSnmp4jDemoSparseTableCol2
            //--AgentGen END
            super.setValue(idxSnmp4jDemoSparseTableCol2, newColValue);
        }

        public OctetString getSnmp4jDemoSparseTableCol3() {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::getSnmp4jDemoSparseTableCol3
            //--AgentGen END
            return (OctetString) super.getValue(idxSnmp4jDemoSparseTableCol3);
        }

        public void setSnmp4jDemoSparseTableCol3(OctetString newColValue) {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::setSnmp4jDemoSparseTableCol3
            //--AgentGen END
            super.setValue(idxSnmp4jDemoSparseTableCol3, newColValue);
        }

        public UnsignedInteger32 getSnmp4jDemoSparseTableCol4() {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::getSnmp4jDemoSparseTableCol4
            //--AgentGen END
            return (UnsignedInteger32) super.getValue(idxSnmp4jDemoSparseTableCol4);
        }

        public void setSnmp4jDemoSparseTableCol4(UnsignedInteger32 newColValue) {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::setSnmp4jDemoSparseTableCol4
            //--AgentGen END
            super.setValue(idxSnmp4jDemoSparseTableCol4, newColValue);
        }

        public OctetString getSnmp4jDemoSparseTableCol5() {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::getSnmp4jDemoSparseTableCol5
            //--AgentGen END
            return (OctetString) super.getValue(idxSnmp4jDemoSparseTableCol5);
        }

        public void setSnmp4jDemoSparseTableCol5(OctetString newColValue) {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::setSnmp4jDemoSparseTableCol5
            //--AgentGen END
            super.setValue(idxSnmp4jDemoSparseTableCol5, newColValue);
        }

        public OctetString getSnmp4jDemoSparseTableCol6() {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::getSnmp4jDemoSparseTableCol6
            //--AgentGen END
            return (OctetString) super.getValue(idxSnmp4jDemoSparseTableCol6);
        }

        public void setSnmp4jDemoSparseTableCol6(OctetString newColValue) {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::setSnmp4jDemoSparseTableCol6
            //--AgentGen END
            super.setValue(idxSnmp4jDemoSparseTableCol6, newColValue);
        }

        public OctetString getSnmp4jDemoSparseTableCol7() {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::getSnmp4jDemoSparseTableCol7
            //--AgentGen END
            return (OctetString) super.getValue(idxSnmp4jDemoSparseTableCol7);
        }

        public void setSnmp4jDemoSparseTableCol7(OctetString newColValue) {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::setSnmp4jDemoSparseTableCol7
            //--AgentGen END
            super.setValue(idxSnmp4jDemoSparseTableCol7, newColValue);
        }

        public UnsignedInteger32 getSnmp4jDemoSparseTableCol8() {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::getSnmp4jDemoSparseTableCol8
            //--AgentGen END
            return (UnsignedInteger32) super.getValue(idxSnmp4jDemoSparseTableCol8);
        }

        public void setSnmp4jDemoSparseTableCol8(UnsignedInteger32 newColValue) {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::setSnmp4jDemoSparseTableCol8
            //--AgentGen END
            super.setValue(idxSnmp4jDemoSparseTableCol8, newColValue);
        }

        public UnsignedInteger32 getSnmp4jDemoSparseTableCol9() {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::getSnmp4jDemoSparseTableCol9
            //--AgentGen END
            return (UnsignedInteger32) super.getValue(idxSnmp4jDemoSparseTableCol9);
        }

        public void setSnmp4jDemoSparseTableCol9(UnsignedInteger32 newColValue) {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::setSnmp4jDemoSparseTableCol9
            //--AgentGen END
            super.setValue(idxSnmp4jDemoSparseTableCol9, newColValue);
        }

        public OctetString getSnmp4jDemoSparseTableCol10() {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::getSnmp4jDemoSparseTableCol10
            //--AgentGen END
            return (OctetString) super.getValue(idxSnmp4jDemoSparseTableCol10);
        }

        public void setSnmp4jDemoSparseTableCol10(OctetString newColValue) {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::setSnmp4jDemoSparseTableCol10
            //--AgentGen END
            super.setValue(idxSnmp4jDemoSparseTableCol10, newColValue);
        }

        public Variable getValue(int column) {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::RowGetValue
            //--AgentGen END
            switch(column) {
                case idxSnmp4jDemoSparseTableCol1:
                    return getSnmp4jDemoSparseTableCol1();
                case idxSnmp4jDemoSparseTableCol2:
                    return getSnmp4jDemoSparseTableCol2();
                case idxSnmp4jDemoSparseTableCol3:
                    return getSnmp4jDemoSparseTableCol3();
                case idxSnmp4jDemoSparseTableCol4:
                    return getSnmp4jDemoSparseTableCol4();
                case idxSnmp4jDemoSparseTableCol5:
                    return getSnmp4jDemoSparseTableCol5();
                case idxSnmp4jDemoSparseTableCol6:
                    return getSnmp4jDemoSparseTableCol6();
                case idxSnmp4jDemoSparseTableCol7:
                    return getSnmp4jDemoSparseTableCol7();
                case idxSnmp4jDemoSparseTableCol8:
                    return getSnmp4jDemoSparseTableCol8();
                case idxSnmp4jDemoSparseTableCol9:
                    return getSnmp4jDemoSparseTableCol9();
                case idxSnmp4jDemoSparseTableCol10:
                    return getSnmp4jDemoSparseTableCol10();
                default:
                    return super.getValue(column);
            }
        }

        public void setValue(int column, Variable value) {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::RowSetValue
            //--AgentGen END
            switch(column) {
                case idxSnmp4jDemoSparseTableCol1:
                    setSnmp4jDemoSparseTableCol1((UnsignedInteger32)value);
                    break;
                case idxSnmp4jDemoSparseTableCol2:
                    setSnmp4jDemoSparseTableCol2((OctetString)value);
                    break;
                case idxSnmp4jDemoSparseTableCol3:
                    setSnmp4jDemoSparseTableCol3((OctetString)value);
                    break;
                case idxSnmp4jDemoSparseTableCol4:
                    setSnmp4jDemoSparseTableCol4((UnsignedInteger32)value);
                    break;
                case idxSnmp4jDemoSparseTableCol5:
                    setSnmp4jDemoSparseTableCol5((OctetString)value);
                    break;
                case idxSnmp4jDemoSparseTableCol6:
                    setSnmp4jDemoSparseTableCol6((OctetString)value);
                    break;
                case idxSnmp4jDemoSparseTableCol7:
                    setSnmp4jDemoSparseTableCol7((OctetString)value);
                    break;
                case idxSnmp4jDemoSparseTableCol8:
                    setSnmp4jDemoSparseTableCol8((UnsignedInteger32)value);
                    break;
                case idxSnmp4jDemoSparseTableCol9:
                    setSnmp4jDemoSparseTableCol9((UnsignedInteger32)value);
                    break;
                case idxSnmp4jDemoSparseTableCol10:
                    setSnmp4jDemoSparseTableCol10((OctetString)value);
                    break;
                default:
                    super.setValue(column, value);
            }
        }

        //--AgentGen BEGIN=snmp4jDemoSparseEntry::Row
        //--AgentGen END
    }

    class Snmp4jDemoSparseEntryRowFactory
            implements MOTableRowFactory<Snmp4jDemoSparseEntryRow>
    {
        public synchronized Snmp4jDemoSparseEntryRow createRow(OID index, Variable[] values)
                throws UnsupportedOperationException
        {
            Snmp4jDemoSparseEntryRow row =
                    new Snmp4jDemoSparseEntryRow(index, values);
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::createRow
            //--AgentGen END
            return row;
        }

        public synchronized void freeRow(Snmp4jDemoSparseEntryRow row) {
            //--AgentGen BEGIN=snmp4jDemoSparseEntry::freeRow
            //--AgentGen END
        }

        //--AgentGen BEGIN=snmp4jDemoSparseEntry::RowFactory
        //--AgentGen END
    }


//--AgentGen BEGIN=_METHODS
//--AgentGen END

    // Textual Definitions of MIB module Snmp4jDemoMib
    protected void addTCsToFactory(MOFactory moFactory) {
        moFactory.addTextualConvention(new SparseTableColumn());
    }


    public class SparseTableColumn implements TextualConvention<Variable> {

        public SparseTableColumn() {
        }

        public String getModuleName() {
            return TC_MODULE_SNMP4J_DEMO_MIB;
        }

        public String getName() {
            return TC_SPARSETABLECOLUMN;
        }

        public Variable createInitialValue() {
            Variable v = new OctetString();
            if (v instanceof AssignableFromLong) {
                ((AssignableFromLong)v).setValue(0L);
            }
            // further modify value to comply with TC constraints here:
            //--AgentGen BEGIN=SparseTableColumn::createInitialValue
            //--AgentGen END
            return v;
        }

        public MOScalar<Variable> createScalar(OID oid, MOAccess access, Variable value) {
            MOScalar<Variable> scalar = moFactory.createScalar(oid, access, value);
            ConstraintsImpl vc = new ConstraintsImpl();
            vc.add(new Constraint(0L, 10L));
            scalar.addMOValueValidationListener(new ValueConstraintValidator(vc));
            //--AgentGen BEGIN=SparseTableColumn::createScalar
            //--AgentGen END
            return scalar;
        }

        public MOColumn<Variable> createColumn(int columnID, int syntax, MOAccess access,
                                               Variable defaultValue, boolean mutableInService) {
            MOColumn<Variable> col = moFactory.createColumn(columnID, syntax, access, defaultValue, mutableInService);
            if (col instanceof MOMutableColumn) {
                MOMutableColumn<Variable> mcol = (MOMutableColumn<Variable>)col;
                ConstraintsImpl vc = new ConstraintsImpl();
                vc.add(new Constraint(0L, 10L));
                mcol.addMOValueValidationListener(new ValueConstraintValidator(vc));
            }
            //--AgentGen BEGIN=SparseTableColumn::createColumn
            //--AgentGen END
            return col;
        }
    }

//--AgentGen BEGIN=_TC_CLASSES_IMPORTED_MODULES_BEGIN
//--AgentGen END

    // Textual Definitions of other MIB modules
    public void addImportedTCsToFactory(MOFactory moFactory) {
        moFactory.addTextualConvention(new IANAItuProbableCause(moFactory));
        moFactory.addTextualConvention(new IANAItuEventType(moFactory));
    }


//--AgentGen BEGIN=_TC_CLASSES_IMPORTED_MODULES_END
//--AgentGen END

//--AgentGen BEGIN=_CLASSES
//--AgentGen END

//--AgentGen BEGIN=_END
//--AgentGen END
}


