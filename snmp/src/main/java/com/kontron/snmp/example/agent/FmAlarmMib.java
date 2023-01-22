package com.kontron.snmp.example.agent;

import com.kontron.snmp.example.enums.FmSeverity;
import com.kontron.snmp.example.enums.IANAItuEventType;
import com.kontron.snmp.example.enums.IANAItuProbableCause;
import com.kontron.snmp.example.validators.*;
import org.snmp4j.smi.*;
import org.snmp4j.agent.*;
import org.snmp4j.agent.mo.*;
import org.snmp4j.agent.mo.snmp.smi.*;
import org.snmp4j.log.LogFactory;
import org.snmp4j.log.LogAdapter;

import java.util.ArrayList;
import java.util.List;

public class FmAlarmMib implements MOGroup {

    private static final LogAdapter LOGGER = LogFactory.getLogger(FmAlarmMib.class);

    private MOFactory moFactory = DefaultMOFactory.getInstance();

    public static final OID oidFmAlarmMib = new OID(new int[]{1, 3, 6, 1, 4, 1, 20306, 11, 2});

    public static final OID oidFmAlarmNotification = new OID(new int[]{1, 3, 6, 1, 4, 1, 20306, 11, 2, 3, 1});
    public static final OID oidFmAlarmId = new OID(new int[]{1, 3, 6, 1, 4, 1, 20306, 11, 2, 1, 1, 1, 2});
    public static final OID oidFmAlarmNodeName = new OID(new int[]{1, 3, 6, 1, 4, 1, 20306, 11, 2, 1, 1, 1, 3});
    public static final OID oidFmAlarmDateAndTime = new OID(new int[]{1, 3, 6, 1, 4, 1, 20306, 11, 2, 1, 1, 1, 4});
    public static final OID oidFmAlarmSeverity = new OID(new int[]{1, 3, 6, 1, 4, 1, 20306, 11, 2, 1, 1, 1, 5});
    public static final OID oidFmAlarmFaultCode = new OID(new int[]{1, 3, 6, 1, 4, 1, 20306, 11, 2, 1, 1, 1, 6});
    public static final OID oidFmAlarmMessage = new OID(new int[]{1, 3, 6, 1, 4, 1, 20306, 11, 2, 1, 1, 1, 7});
    public static final OID oidFmAlarmComponentName = new OID(new int[]{1, 3, 6, 1, 4, 1, 20306, 11, 2, 1, 1, 1, 8});
    public static final OID oidFmAlarmEventType = new OID(new int[]{1, 3, 6, 1, 4, 1, 20306, 11, 2, 1, 1, 1, 9});
    public static final OID oidFmAlarmProbableCause = new OID(new int[]{1, 3, 6, 1, 4, 1, 20306, 11, 2, 1, 1, 1, 10});
    public static final OID oidFmAlarmAttributes = new OID(new int[]{1, 3, 6, 1, 4, 1, 20306, 11, 2, 1, 1, 1, 11});

    private static final String TC_MODULE_SNMPV2_TC = "SNMPv2-TC";
    private static final String TC_STORAGETYPE = "StorageType";
    private static final String TC_DISPLAYSTRING = "DisplayString";
    private static final String TC_ROWSTATUS = "RowStatus";
    private static final String TC_TIMESTAMP = "TimeStamp";
    private static final String TC_IANAITUPROBABLECAUSE = "IANAItuProbableCause";
    private static final String TC_IANAITUEVENTTYPE = "IANAItuEventType";

    public static final OID oidFmAlarmActiveEntry = new OID(new int[]{1, 3, 6, 1, 4, 1, 20306, 11, 2, 1, 1, 1});
    public static final OID oidFmAlarmIndex = new OID(new int[]{1, 3, 6, 1, 4, 1, 20306, 11, 2, 1, 1, 1, 1});

    // Column sub-identifier definitions for fmAlarmEntry:
    public static final int colFmAlarmId = 2;
    public static final int colFmAlarmNodeName = 3;
    public static final int colFmAlarmDateAndTime = 4;
    public static final int colFmAlarmSeverity = 5;
    public static final int colFmAlarmFaultCode = 6;
    public static final int colFmAlarmMessage = 7;
    public static final int colFmAlarmComponentName = 8;
    public static final int colFmAlarmEventType = 9;
    public static final int colFmAlarmProbableCause = 10;
    public static final int colFmAlarmAttributes = 11;

    // Column index definitions for fmAlarmEntry:
    public static final int idxFmAlarmId = 0;
    public static final int idxFmAlarmNodeName = 1;
    public static final int idxFmAlarmDateAndTime = 2;
    public static final int idxFmAlarmSeverity = 3;
    public static final int idxFmAlarmFaultCode = 4;
    public static final int idxFmAlarmMessage = 5;
    public static final int idxFmAlarmComponentName = 6;
    public static final int idxFmAlarmEventType = 7;
    public static final int idxFmAlarmProbableCause = 8;
    public static final int idxFmAlarmAttributes = 9;

    private MOTableSubIndex[] fmAlarmEntryIndexes;
    private MOTableIndex fmAlarmEntryIndex;

    @SuppressWarnings("rawtypes")
    private MOTable<FmAlarmEntryRow,
            MOColumn,
            MOMutableTableModel<FmAlarmEntryRow>> fmAlarmEntry;
    private static MOMutableTableModel<FmAlarmEntryRow> fmAlarmEntryModel;


    /**
     * Constructs a FmAlarmMib instance without actually creating its
     * {@code ManagedObject} instances. This has to be done in a
     * sub-class constructor or after construction by calling
     * {@link #createMO(MOFactory moFactory)}.
     */
    public FmAlarmMib() {
    }

    /**
     * Constructs a FmAlarmMib instance and actually creates its
     * {@code ManagedObject} instances using the supplied
     * {@code MOFactory} (by calling
     * {@link #createMO(MOFactory moFactory)}).
     *
     * @param moFactory the {@code MOFactory} to be used to create the
     *                  managed objects for this module.
     */
    public FmAlarmMib(MOFactory moFactory) {
        this();
        createMO(moFactory);
        initializeTable();
    }

    /**
     * Create the ManagedObjects defined for this MIB module
     * using the specified {@link MOFactory}.
     *
     * @param moFactory the {@code MOFactory} instance to use for object
     *                  creation.
     */
    protected void createMO(MOFactory moFactory) {
        addTCsToFactory(moFactory);
        createFmAlarmEntry(moFactory);
    }

    @SuppressWarnings("rawtypes")
    public MOTable<FmAlarmEntryRow, MOColumn, MOMutableTableModel<FmAlarmEntryRow>> getFmAlarmEntry() {
        return fmAlarmEntry;
    }


    @SuppressWarnings(value = {"unchecked"})
    private void createFmAlarmEntry(MOFactory moFactory) {
        fmAlarmEntryIndexes = new MOTableSubIndex[]{
                moFactory.createSubIndex(oidFmAlarmIndex, SMIConstants.SYNTAX_INTEGER, 1, 1)
        };

        fmAlarmEntryIndex = moFactory.createIndex(
                fmAlarmEntryIndexes,
                false,
                new MOTableIndexValidator() {
                    public boolean isValidIndex(OID index) {
                        boolean isValidIndex = true;
                        return isValidIndex;
                    }
                });

        MOColumn<?>[] fmAlarmEntryColumns = new MOColumn<?>[10];

        fmAlarmEntryColumns[idxFmAlarmId] =
                new MOMutableColumn<UnsignedInteger32>(colFmAlarmId,
                        SMIConstants.SYNTAX_UNSIGNED_INTEGER32,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (UnsignedInteger32) null);
        ValueConstraint fmAlarmIdVC = new ConstraintsImpl();
        ((ConstraintsImpl) fmAlarmIdVC).add(new Constraint(0L, 10L));
        ((MOMutableColumn) fmAlarmEntryColumns[idxFmAlarmId]).
                addMOValueValidationListener(new ValueConstraintValidator(fmAlarmIdVC));
        ((MOMutableColumn) fmAlarmEntryColumns[idxFmAlarmId]).
                addMOValueValidationListener(new FmAlarmIdValidator());

        fmAlarmEntryColumns[idxFmAlarmNodeName] =
                new MOMutableColumn<OctetString>(colFmAlarmNodeName,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (OctetString) null);
        ValueConstraint fmAlarmNodeNameVC = new ConstraintsImpl();
        ((ConstraintsImpl) fmAlarmNodeNameVC).add(new Constraint(0L, 10L));
        ((MOMutableColumn) fmAlarmEntryColumns[idxFmAlarmNodeName]).
                addMOValueValidationListener(new ValueConstraintValidator(fmAlarmNodeNameVC));
        ((MOMutableColumn) fmAlarmEntryColumns[idxFmAlarmNodeName]).
                addMOValueValidationListener(new FmAlarmNodeNameValidator());

        fmAlarmEntryColumns[idxFmAlarmDateAndTime] =
                new MOMutableColumn<OctetString>(colFmAlarmDateAndTime,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (OctetString) null);
        ValueConstraint fmAlarmDateAndTimeVC = new ConstraintsImpl();
        ((ConstraintsImpl) fmAlarmDateAndTimeVC).add(new Constraint(0L, 10L));
        ((MOMutableColumn) fmAlarmEntryColumns[idxFmAlarmDateAndTime]).
                addMOValueValidationListener(new ValueConstraintValidator(fmAlarmDateAndTimeVC));
        ((MOMutableColumn) fmAlarmEntryColumns[idxFmAlarmDateAndTime]).
                addMOValueValidationListener(new FmAlarmDateAndTimeValidator());

        fmAlarmEntryColumns[idxFmAlarmSeverity] =
                new MOMutableColumn<UnsignedInteger32>(colFmAlarmSeverity,
                        SMIConstants.SYNTAX_UNSIGNED_INTEGER32,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (UnsignedInteger32) null);
        ValueConstraint fmAlarmSeverityVC = new EnumerationConstraint(
                new int[]{
                        FmSeverity.indeterminate,
                        FmSeverity.cleared,
                        FmSeverity.normal,
                        FmSeverity.warning,
                        FmSeverity.minor,
                        FmSeverity.major,
                        FmSeverity.critical
                }
        );
        ((MOMutableColumn) fmAlarmEntryColumns[idxFmAlarmSeverity]).
                addMOValueValidationListener(new ValueConstraintValidator(fmAlarmSeverityVC));
        ((MOMutableColumn) fmAlarmEntryColumns[idxFmAlarmSeverity]).
                addMOValueValidationListener(new FmAlarmSeverityValidator());

        fmAlarmEntryColumns[idxFmAlarmFaultCode] =
                new MOMutableColumn<OctetString>(colFmAlarmFaultCode,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (OctetString) null);
        ValueConstraint fmAlarmFaultCodeVC = new ConstraintsImpl();
        ((ConstraintsImpl) fmAlarmFaultCodeVC).add(new Constraint(0L, 10L));
        ((MOMutableColumn) fmAlarmEntryColumns[idxFmAlarmFaultCode]).
                addMOValueValidationListener(new ValueConstraintValidator(fmAlarmFaultCodeVC));
        ((MOMutableColumn) fmAlarmEntryColumns[idxFmAlarmFaultCode]).
                addMOValueValidationListener(new FmAlarmFaultCodeValidator());

        fmAlarmEntryColumns[idxFmAlarmMessage] =
                new MOMutableColumn<OctetString>(colFmAlarmMessage,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (OctetString) null);
        ValueConstraint fmAlarmMessageVC = new ConstraintsImpl();
        ((ConstraintsImpl) fmAlarmMessageVC).add(new Constraint(0L, 10L));
        ((MOMutableColumn) fmAlarmEntryColumns[idxFmAlarmMessage]).
                addMOValueValidationListener(new ValueConstraintValidator(fmAlarmMessageVC));
        ((MOMutableColumn) fmAlarmEntryColumns[idxFmAlarmMessage]).
                addMOValueValidationListener(new FmAlarmMessageValidator());

        fmAlarmEntryColumns[idxFmAlarmComponentName] =
                new MOMutableColumn<OctetString>(colFmAlarmComponentName,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (OctetString) null);
        ValueConstraint fmAlarmComponentNameVC = new ConstraintsImpl();
        ((ConstraintsImpl) fmAlarmComponentNameVC).add(new Constraint(0L, 10L));
        ((MOMutableColumn) fmAlarmEntryColumns[idxFmAlarmComponentName]).
                addMOValueValidationListener(new ValueConstraintValidator(fmAlarmComponentNameVC));
        ((MOMutableColumn) fmAlarmEntryColumns[idxFmAlarmComponentName]).
                addMOValueValidationListener(new FmAlarmComponentNameValidator());

        fmAlarmEntryColumns[idxFmAlarmEventType] =
                new MOMutableColumn<UnsignedInteger32>(colFmAlarmEventType,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (UnsignedInteger32) null);
        ValueConstraint fmAlarmEventTypeVC = new EnumerationConstraint(
                new int[]{
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
        ((MOMutableColumn) fmAlarmEntryColumns[idxFmAlarmEventType]).
                addMOValueValidationListener(new ValueConstraintValidator(fmAlarmEventTypeVC));
        ((MOMutableColumn) fmAlarmEntryColumns[idxFmAlarmEventType]).
                addMOValueValidationListener(new FmAlarmEventTypeValidator());

        fmAlarmEntryColumns[idxFmAlarmProbableCause] =
                new MOMutableColumn<UnsignedInteger32>(colFmAlarmProbableCause,
                        SMIConstants.SYNTAX_UNSIGNED_INTEGER32,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (UnsignedInteger32) null);
        ValueConstraint fmAlarmProbableCauseVC = new EnumerationConstraint(
                new int[]{
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
        ((MOMutableColumn) fmAlarmEntryColumns[idxFmAlarmProbableCause]).
                addMOValueValidationListener(new ValueConstraintValidator(fmAlarmProbableCauseVC));
        ((MOMutableColumn) fmAlarmEntryColumns[idxFmAlarmProbableCause]).
                addMOValueValidationListener(new FmAlarmProbableCauseValidator());

        fmAlarmEntryColumns[idxFmAlarmAttributes] =
                new MOMutableColumn<OctetString>(colFmAlarmAttributes,
                        SMIConstants.SYNTAX_OCTET_STRING,
                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_CREATE),
                        (OctetString) null);
        ValueConstraint fmAlarmAttributesVC = new ConstraintsImpl();
        ((ConstraintsImpl) fmAlarmAttributesVC).add(new Constraint(0L, 10L));
        ((MOMutableColumn) fmAlarmEntryColumns[idxFmAlarmAttributes]).
                addMOValueValidationListener(new ValueConstraintValidator(fmAlarmAttributesVC));
        ((MOMutableColumn) fmAlarmEntryColumns[idxFmAlarmAttributes]).
                addMOValueValidationListener(new FmAlarmAttributesValidator());

        fmAlarmEntryModel = moFactory.createTableModel(
                oidFmAlarmActiveEntry,
                fmAlarmEntryIndex,
                fmAlarmEntryColumns
        );

        fmAlarmEntryModel.setRowFactory(new FmAlarmEntryRowFactory());

        fmAlarmEntry = moFactory.createTable(
                oidFmAlarmActiveEntry,
                fmAlarmEntryIndex,
                fmAlarmEntryColumns,
                fmAlarmEntryModel
        );
    }


    public void registerMOs(MOServer server, OctetString context) throws DuplicateRegistrationException {
        server.register(this.fmAlarmEntry, context);
    }

    public void unregisterMOs(MOServer server, OctetString context) {
        server.unregister(this.fmAlarmEntry, context);
    }

    public void fmAlarmNotification(NotificationOriginator notificationOriginator, OctetString context, VariableBinding[] vbs) {
        if (vbs.length < 10) {
            throw new IllegalArgumentException("Too few notification objects (snmp4jDemoEvent): " + vbs.length + " < 10");
        }

        if (!(vbs[0].getOid().startsWith(oidFmAlarmId))) {
            throw new IllegalArgumentException("Variable 0 (fmAlarmId)) has wrong OID: " + vbs[0].getOid() +
                    " does not start with " + oidFmAlarmId);
        }
        if (!fmAlarmEntryIndex.isValidIndex(fmAlarmEntry.getIndexPart(vbs[0].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 0 (fmAlarmId)) specified: " +
                    fmAlarmEntry.getIndexPart(vbs[0].getOid()));
        }

        if (!(vbs[1].getOid().startsWith(oidFmAlarmNodeName))) {
            throw new IllegalArgumentException("Variable 1 (fmAlarmNodeName)) has wrong OID: " + vbs[1].getOid() +
                    " does not start with " + oidFmAlarmNodeName);
        }
        if (!fmAlarmEntryIndex.isValidIndex(fmAlarmEntry.getIndexPart(vbs[1].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 1 (fmAlarmNodeName)) specified: " +
                    fmAlarmEntry.getIndexPart(vbs[1].getOid()));
        }

        if (!(vbs[2].getOid().startsWith(oidFmAlarmDateAndTime))) {
            throw new IllegalArgumentException("Variable 2 (fmAlarmDateAndTime)) has wrong OID: " + vbs[2].getOid() +
                    " does not start with " + oidFmAlarmDateAndTime);
        }
        if (!fmAlarmEntryIndex.isValidIndex(fmAlarmEntry.getIndexPart(vbs[2].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 2 (fmAlarmDateAndTime)) specified: " +
                    fmAlarmEntry.getIndexPart(vbs[2].getOid()));
        }

        if (!(vbs[3].getOid().startsWith(oidFmAlarmSeverity))) {
            throw new IllegalArgumentException("Variable 3 (fmAlarmSeverity)) has wrong OID: " + vbs[3].getOid() +
                    " does not start with " + oidFmAlarmSeverity);
        }
        if (!fmAlarmEntryIndex.isValidIndex(fmAlarmEntry.getIndexPart(vbs[3].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 3 (fmAlarmSeverity)) specified: " +
                    fmAlarmEntry.getIndexPart(vbs[3].getOid()));
        }

        if (!(vbs[4].getOid().startsWith(oidFmAlarmFaultCode))) {
            throw new IllegalArgumentException("Variable 4 (fmAlarmFaultCode)) has wrong OID: " + vbs[4].getOid() +
                    " does not start with " + oidFmAlarmFaultCode);
        }
        if (!fmAlarmEntryIndex.isValidIndex(fmAlarmEntry.getIndexPart(vbs[4].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 4 (fmAlarmFaultCode)) specified: " +
                    fmAlarmEntry.getIndexPart(vbs[4].getOid()));
        }

        if (!(vbs[5].getOid().startsWith(oidFmAlarmMessage))) {
            throw new IllegalArgumentException("Variable 5 (fmAlarmMessage)) has wrong OID: " + vbs[5].getOid() +
                    " does not start with " + oidFmAlarmMessage);
        }
        if (!fmAlarmEntryIndex.isValidIndex(fmAlarmEntry.getIndexPart(vbs[5].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 5 (fmAlarmMessage)) specified: " +
                    fmAlarmEntry.getIndexPart(vbs[5].getOid()));
        }

        if (!(vbs[6].getOid().startsWith(oidFmAlarmComponentName))) {
            throw new IllegalArgumentException("Variable 6 (fmAlarmComponentName)) has wrong OID: " + vbs[6].getOid() +
                    " does not start with " + oidFmAlarmComponentName);
        }
        if (!fmAlarmEntryIndex.isValidIndex(fmAlarmEntry.getIndexPart(vbs[6].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 6 (fmAlarmComponentName)) specified: " +
                    fmAlarmEntry.getIndexPart(vbs[6].getOid()));
        }

        if (!(vbs[7].getOid().startsWith(oidFmAlarmEventType))) {
            throw new IllegalArgumentException("Variable 7 (fmAlarmEventType)) has wrong OID: " + vbs[7].getOid() +
                    " does not start with " + oidFmAlarmEventType);
        }
        if (!fmAlarmEntryIndex.isValidIndex(fmAlarmEntry.getIndexPart(vbs[7].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 7 (fmAlarmEventType)) specified: " +
                    fmAlarmEntry.getIndexPart(vbs[7].getOid()));
        }

        if (!(vbs[8].getOid().startsWith(oidFmAlarmProbableCause))) {
            throw new IllegalArgumentException("Variable 8 (fmAlarmProbableCause)) has wrong OID: " + vbs[8].getOid() +
                    " does not start with " + oidFmAlarmProbableCause);
        }
        if (!fmAlarmEntryIndex.isValidIndex(fmAlarmEntry.getIndexPart(vbs[8].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 8 (fmAlarmProbableCause)) specified: " +
                    fmAlarmEntry.getIndexPart(vbs[8].getOid()));
        }

        if (!(vbs[9].getOid().startsWith(oidFmAlarmAttributes))) {
            throw new IllegalArgumentException("Variable 9 (fmAlarmAttributes)) has wrong OID: " + vbs[9].getOid() +
                    " does not start with " + oidFmAlarmAttributes);
        }
        if (!fmAlarmEntryIndex.isValidIndex(fmAlarmEntry.getIndexPart(vbs[9].getOid()))) {
            throw new IllegalArgumentException("Illegal index for variable 9 (fmAlarmAttributes)) specified: " +
                    fmAlarmEntry.getIndexPart(vbs[9].getOid()));
        }

        notificationOriginator.notify(context, oidFmAlarmNotification, vbs);
    }

    public void initializeTable() {
        fmAlarmEntryModel.clear();

        Variable[] values = new Variable[fmAlarmEntry.getColumnCount()];
        int colCount = fmAlarmEntry.getColumnCount();
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
                values[i] = new OctetString(String.valueOf(i) + "aaaaaa");
            }
        }

        FmAlarmEntryRow fmAlarmEntryRow1 = new FmAlarmEntryRow(new OID(new int[]{1}), values);
        FmAlarmEntryRow fmAlarmEntryRow2 = new FmAlarmEntryRow(new OID(new int[]{2}), values);
        FmAlarmEntryRow fmAlarmEntryRow3 = new FmAlarmEntryRow(new OID(new int[]{3}), values);
        FmAlarmEntryRow fmAlarmEntryRow4 = new FmAlarmEntryRow(new OID(new int[]{4}), values);

        fmAlarmEntryModel.addRow(fmAlarmEntryRow1);
        fmAlarmEntryModel.addRow(fmAlarmEntryRow2);
        fmAlarmEntryModel.addRow(fmAlarmEntryRow3);
        fmAlarmEntryModel.addRow(fmAlarmEntryRow4);

        removeRow(2);
        removeRow(1);
    }

    public static FmAlarmEntryRow getRow(OID oid) {

        return fmAlarmEntryModel.getRow(oid);
    }

    public static List<FmAlarmEntryRow> getRows() {
        List<FmAlarmEntryRow> fmAlarmEntryRows = new ArrayList<>();
        fmAlarmEntryModel.iterator().forEachRemaining(fmAlarmEntryRows::add);

        return fmAlarmEntryRows;
    }

    public static void addRow(OID oid, Variable[] values) {
        FmAlarmEntryRow fmAlarmEntryRow = new FmAlarmEntryRow(oid, values);

        fmAlarmEntryModel.addRow(fmAlarmEntryRow);
    }

    public static void updateRow(OID oid, Variable[] values) {
        FmAlarmEntryRow fmAlarmEntryRow = new FmAlarmEntryRow(oid, values);

        fmAlarmEntryModel.removeRow(oid); // TODO
        fmAlarmEntryModel.addRow(fmAlarmEntryRow);
    }

    public void addRow(int oid, Variable[] values) {
        FmAlarmEntryRow fmAlarmEntryRow = new FmAlarmEntryRow(new OID(new int[]{oid}), values);

        fmAlarmEntryModel.addRow(fmAlarmEntryRow);
    }

    public static void removeRow(OID oid) {
        fmAlarmEntryModel.removeRow(oid);
    }

    public static void removeRow(int oid) {
        fmAlarmEntryModel.removeRow(new OID(new int[]{oid}));
    }

    public static void clearTable() {
        fmAlarmEntryModel.clear();
    }


    // Textual Definitions of MIB module FmAlarmMib
    protected void addTCsToFactory(MOFactory moFactory) {
        moFactory.addTextualConvention(new FmAlarmColumn(moFactory));
    }

    // Textual Definitions of other MIB modules
    public void addImportedTCsToFactory(MOFactory moFactory) {
        moFactory.addTextualConvention(new IANAItuProbableCause(moFactory));
        moFactory.addTextualConvention(new IANAItuEventType(moFactory));
    }
}


