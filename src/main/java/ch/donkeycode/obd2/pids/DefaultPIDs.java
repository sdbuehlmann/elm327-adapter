package ch.donkeycode.obd2.pids;

import ch.donkeycode.obd2.pids.models.DegreesCelsius;
import ch.donkeycode.obd2.pids.models.DistanceInKm;
import ch.donkeycode.obd2.pids.models.FlowRate;
import ch.donkeycode.obd2.pids.models.Percentage;
import ch.donkeycode.obd2.pids.models.Presure;
import ch.donkeycode.obd2.pids.models.RotationPerMinute;
import ch.donkeycode.obd2.pids.models.SpeedInKmPerHour;
import ch.donkeycode.obd2.pids.models.SupportedPIDsReport;
import ch.donkeycode.obd2.pids.models.VehicleDiagnosticStandard;

public class DefaultPIDs {

    public static final ParameterID<Void> PLACEHOLDER = ParameterID.<Void>builder()
            .mode(-1)
            .id(-0x01)
            .returnedBytes(0)
            .description("Placeholder")
            .decoder(bytes -> null)
            .build();


    public static final ParameterID<SupportedPIDsReport> MONITOR_STATUS = ParameterID.<SupportedPIDsReport>builder()
            .mode(1)
            .id(0x01)
            .returnedBytes(4)
            .description("Monitor status since DTCs cleared. (Includes malfunction indicator lamp (MIL), status and number of DTCs, components tests, DTC readiness checks)")
            .decoder(SupportedPIDsReport.deserializer())
            .build();

    public static final ParameterID<Void> FREEZE_FRAME_DTC = ParameterID.<Void>builder()
            .mode(1)
            .id(0x02)
            .returnedBytes(2)
            .description("DTC that caused freeze frame to be stored.")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> FUEL_SYSTEM_STATUS = ParameterID.<Void>builder()
            .mode(1)
            .id(0x03)
            .returnedBytes(2)
            .description("Fuel system status.")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Percentage> CALCULATED_ENGINE_LOAD = ParameterID.<Percentage>builder()
            .mode(1)
            .id(0x04)
            .returnedBytes(1)
            .description("Calculated engine load")
            .decoder(Percentage.deserializer())
            .build();

    public static final ParameterID<DegreesCelsius> ENGINE_COOLANT_TEMPERATURE = ParameterID.<DegreesCelsius>builder()
            .mode(1)
            .id(0x05)
            .returnedBytes(1)
            .description("Engine coolant temperature.")
            .decoder(DegreesCelsius.deserializer())
            .build();

    public static final ParameterID<Void> STFT_1 = ParameterID.<Void>builder()
            .mode(1)
            .id(0x06)
            .returnedBytes(1)
            .description("Short term fuel trim (STFT)—Bank 1.")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> LTFT_1 = ParameterID.<Void>builder()
            .mode(1)
            .id(0x07)
            .returnedBytes(1)
            .description("Long term fuel trim (LTFT)—Bank 1.")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> STFT_2 = ParameterID.<Void>builder()
            .mode(1)
            .id(0x08)
            .returnedBytes(1)
            .description("Short term fuel trim (STFT)—Bank 2.")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> LTFT_2 = ParameterID.<Void>builder()
            .mode(1)
            .id(0x09)
            .returnedBytes(1)
            .description("Long term fuel trim (LTFT)—Bank 2.")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> FUEL_PRESURE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x0A)
            .returnedBytes(1)
            .description("Fuel pressure (gauge pressure)")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Presure> INTAKE_MANIFOLD_ABS_PRESSURE = ParameterID.<Presure>builder()
            .mode(1)
            .id(0x0B)
            .returnedBytes(1)
            .description("Intake manifold absolute pressure")
            .decoder(Presure.deserializer())
            .build();

    public static final ParameterID<RotationPerMinute> ENGINE_SPEED = ParameterID.<RotationPerMinute>builder()
            .mode(1)
            .id(0x0C)
            .returnedBytes(2)
            .description("Engine speed")
            .decoder(RotationPerMinute.deserializer())
            .build();

    public static final ParameterID<SpeedInKmPerHour> VEHICLE_SPEED = ParameterID.<SpeedInKmPerHour>builder()
            .mode(1)
            .id(0x0D)
            .returnedBytes(1)
            .description("Vehicle speed")
            .decoder(SpeedInKmPerHour.deserializer())
            .build();

    public static final ParameterID<Void> TIMING_ADVANCE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x0E)
            .returnedBytes(1)
            .description("Timing advance")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<DegreesCelsius> INTAKE_AIR_TEMPERATURE = ParameterID.<DegreesCelsius>builder()
            .mode(1)
            .id(0x0F)
            .returnedBytes(1)
            .description("Intake air temperature")
            .decoder(DegreesCelsius.deserializer())
            .build();

    public static final ParameterID<FlowRate> MAF_AIR_FLOW_RATE = ParameterID.<FlowRate>builder()
            .mode(1)
            .id(0x10)
            .returnedBytes(2)
            .description("Mass air flow sensor (MAF) air flow rate")
            .decoder(FlowRate.deserializer())
            .build();

    public static final ParameterID<Percentage> THROTTLE_POSITION = ParameterID.<Percentage>builder()
            .mode(1)
            .id(0x11)
            .returnedBytes(1)
            .description("Throttle position")
            .decoder(Percentage.deserializer())
            .build();

    public static final ParameterID<Void> COMMANDED_SECONDARY_AIR_STATUS = ParameterID.<Void>builder()
            .mode(1)
            .id(0x12)
            .returnedBytes(1)
            .description("Commanded secondary air status")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSORS_PRESENT = ParameterID.<Void>builder()
            .mode(1)
            .id(0x13)
            .returnedBytes(1)
            .description("Oxygen sensors present (in 2 banks)")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_1 = ParameterID.<Void>builder()
            .mode(1)
            .id(0x14)
            .returnedBytes(2)
            .description("Oxygen Sensor 1")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_2 = ParameterID.<Void>builder()
            .mode(1)
            .id(0x15)
            .returnedBytes(2)
            .description("Oxygen Sensor 2")
            .decoder(bytes -> null) // TODO
            .build();


    public static final ParameterID<Void> OXYGEN_SENSOR_3 = ParameterID.<Void>builder()
            .mode(1)
            .id(0x16)
            .returnedBytes(2)
            .description("Oxygen Sensor 3")
            .decoder(bytes -> null) // TODO
            .build();


    public static final ParameterID<Void> OXYGEN_SENSOR_4 = ParameterID.<Void>builder()
            .mode(1)
            .id(0x17)
            .returnedBytes(2)
            .description("Oxygen Sensor 4")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_5 = ParameterID.<Void>builder()
            .mode(1)
            .id(0x18)
            .returnedBytes(2)
            .description("Oxygen Sensor 5")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_6 = ParameterID.<Void>builder()
            .mode(1)
            .id(0x19)
            .returnedBytes(2)
            .description("Oxygen Sensor 6")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_7 = ParameterID.<Void>builder()
            .mode(1)
            .id(0x1A)
            .returnedBytes(2)
            .description("Oxygen Sensor 7")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_8 = ParameterID.<Void>builder()
            .mode(1)
            .id(0x1B)
            .returnedBytes(2)
            .description("Oxygen Sensor 8")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<VehicleDiagnosticStandard> VEHICLE_OBD_STANDARDS = ParameterID.<VehicleDiagnosticStandard>builder()
            .mode(1)
            .id(0x1C)
            .returnedBytes(1)
            .description("OBD standards this vehicle conforms to")
            .decoder(VehicleDiagnosticStandard.deserializer())
            .build();

    public static final ParameterID<Void> OXYGEN_SENSORS_PRESENT_4_BANKS = ParameterID.<Void>builder()
            .mode(1)
            .id(0x1D)
            .returnedBytes(1)
            .description("Oxygen sensors present (in 4 banks)")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> AUXILIARY_INPUT_STATUS = ParameterID.<Void>builder()
            .mode(1)
            .id(0x1E)
            .returnedBytes(1)
            .description("Auxiliary input status")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> RUN_TIME_SINCE_ENGINE_START = ParameterID.<Void>builder()
            .mode(1)
            .id(0x20)
            .returnedBytes(2)
            .description("Auxiliary input status")
            .decoder(bytes -> null) // TODO
            .build();

    // PIDs 0x21 to 0x40 ============================================================================================

    public static final ParameterID<DistanceInKm> MIL_ON_SINCE = ParameterID.<DistanceInKm>builder()
            .mode(1)
            .id(0x21)
            .returnedBytes(2)
            .description("Distance traveled with malfunction indicator lamp (MIL) on")
            .decoder(DistanceInKm.deserializerSmall())
            .build();

    public static final ParameterID<Void> FUEL_RAIL_PRESSURE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x22)
            .returnedBytes(2)
            .description("Fuel Rail Pressure (relative to manifold vacuum)")
            .decoder(bytes -> null) // TODO
            .build();


    public static final ParameterID<Void> FUEL_RAIL_GAUGE_PRESSURE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x23)
            .returnedBytes(2)
            .description("Fuel Rail Gauge Pressure (diesel, or gasoline direct injection)")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_1_VOLTAGE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x24)
            .returnedBytes(4)
            .description("Oxygen Sensor 1")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_2_VOLTAGE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x25)
            .returnedBytes(4)
            .description("Oxygen Sensor 2")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_3_VOLTAGE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x26)
            .returnedBytes(4)
            .description("Oxygen Sensor 3")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_4_VOLTAGE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x27)
            .returnedBytes(4)
            .description("Oxygen Sensor 4")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_5_VOLTAGE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x28)
            .returnedBytes(4)
            .description("Oxygen Sensor 5")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_6_VOLTAGE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x29)
            .returnedBytes(4)
            .description("Oxygen Sensor 6")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_7_VOLTAGE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x2a)
            .returnedBytes(4)
            .description("Oxygen Sensor 7")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_8_VOLTAGE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x2B)
            .returnedBytes(4)
            .description("Oxygen Sensor 8")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Percentage> COMMANDED_EGR = ParameterID.<Percentage>builder()
            .mode(1)
            .id(0x2C)
            .returnedBytes(1)
            .description("Commanded EGR")
            .decoder(Percentage.deserializer())
            .build();

    public static final ParameterID<Void> EGR_ERROR = ParameterID.<Void>builder()
            .mode(1)
            .id(0x2D)
            .returnedBytes(1)
            .description("EGR Error")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Percentage> COMMANDED_EVAPORATIVE_PURGE = ParameterID.<Percentage>builder()
            .mode(1)
            .id(0x2E)
            .returnedBytes(1)
            .description("Commanded evaporative purge")
            .decoder(Percentage.deserializer()) // TODO
            .build();


    public static final ParameterID<Percentage> FUEL_TANK_LEVEL_INPUT = ParameterID.<Percentage>builder()
            .mode(1)
            .id(0x2F)
            .returnedBytes(1)
            .description("Fuel Tank Level Input")
            .decoder(Percentage.deserializer())
            .build();

    public static final ParameterID<Void> WARM_UPS_SINCE_CODES_CLEARED = ParameterID.<Void>builder()
            .mode(1)
            .id(0x30)
            .returnedBytes(1)
            .description("Warm-ups since codes cleared")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<DistanceInKm> DISTANCE_TRAVELED_SINCE_CODES_CLEARED = ParameterID.<DistanceInKm>builder()
            .mode(1)
            .id(0x31)
            .returnedBytes(2)
            .description("Distance traveled since codes cleared")
            .decoder(DistanceInKm.deserializerSmall())
            .build();

    public static final ParameterID<Void> EVAP_SYSTEM_VAPOR_PRESSURE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x32)
            .returnedBytes(2)
            .description("Evap. System Vapor Pressure")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Presure> ABSOLUTE_BAROMETRIC_PRESSURE = ParameterID.<Presure>builder()
            .mode(1)
            .id(0x33)
            .returnedBytes(2)
            .description("Absolute Barometric Pressure")
            .decoder(Presure.deserializer())
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_1_CURRENT = ParameterID.<Void>builder()
            .mode(1)
            .id(0x34)
            .returnedBytes(4)
            .description("Oxygen Sensor 1")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_2_CURRENT = ParameterID.<Void>builder()
            .mode(1)
            .id(0x35)
            .returnedBytes(4)
            .description("Oxygen Sensor 2")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_3_CURRENT = ParameterID.<Void>builder()
            .mode(1)
            .id(0x36)
            .returnedBytes(4)
            .description("Oxygen Sensor 3")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_4_CURRENT = ParameterID.<Void>builder()
            .mode(1)
            .id(0x37)
            .returnedBytes(4)
            .description("Oxygen Sensor 4")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_5_CURRENT = ParameterID.<Void>builder()
            .mode(1)
            .id(0x38)
            .returnedBytes(4)
            .description("Oxygen Sensor 5")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_6_CURRENT = ParameterID.<Void>builder()
            .mode(1)
            .id(0x39)
            .returnedBytes(4)
            .description("Oxygen Sensor 6")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_7_CURRENT = ParameterID.<Void>builder()
            .mode(1)
            .id(0x3A)
            .returnedBytes(4)
            .description("Oxygen Sensor 7")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> OXYGEN_SENSOR_8_CURRENT = ParameterID.<Void>builder()
            .mode(1)
            .id(0x3B)
            .returnedBytes(4)
            .description("Oxygen Sensor 8")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> CAT_TEMPERATURE_BANK_1_SENSOR_1 = ParameterID.<Void>builder()
            .mode(1)
            .id(0x3c)
            .returnedBytes(2)
            .description("Catalyst Temperature: Bank 1, Sensor 1")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> CAT_TEMPERATURE_BANK_2_SENSOR_1 = ParameterID.<Void>builder()
            .mode(1)
            .id(0x3D)
            .returnedBytes(2)
            .description("Catalyst Temperature: Bank 2, Sensor 1")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> CAT_TEMPERATURE_BANK_1_SENSOR_2 = ParameterID.<Void>builder()
            .mode(1)
            .id(0x3E)
            .returnedBytes(2)
            .description("Catalyst Temperature: Bank 1, Sensor 2")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> CAT_TEMPERATURE_BANK_2_SENSOR_2 = ParameterID.<Void>builder()
            .mode(1)
            .id(0x3F)
            .returnedBytes(2)
            .description("Catalyst Temperature: Bank 2, Sensor 1")
            .decoder(bytes -> null) // TODO
            .build();

    // PIDs 0x41 to 0x60 ============================================================================================

    public static final ParameterID<Void> MONITOR_STATUS_THIS_DRIVE_CYCLE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x41)
            .returnedBytes(4)
            .description("Monitor status this drive cycle")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> CONTROL_MODULE_VOLTAGE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x42)
            .returnedBytes(2)
            .description("Control module voltage")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> ABSOLUTE_LOAD_VALUE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x43)
            .returnedBytes(2)
            .description("Absolute load value")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> COMMANDED_AIR_FUEL_EQUIVALENCE_RATIO = ParameterID.<Void>builder()
            .mode(1)
            .id(0x44)
            .returnedBytes(2)
            .description("Commanded Air-Fuel Equivalence Ratio")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Percentage> RELATIVE_THROTTLE_POSITION = ParameterID.<Percentage>builder()
            .mode(1)
            .id(0x45)
            .returnedBytes(1)
            .description("Relative throttle position")
            .decoder(Percentage.deserializer())
            .build();

    public static final ParameterID<DegreesCelsius> AMBIENT_AIR_TEMPERATURE = ParameterID.<DegreesCelsius>builder()
            .mode(1)
            .id(0x46)
            .returnedBytes(1)
            .description("Ambient air temperature")
            .decoder(DegreesCelsius.deserializer()) // TODO
            .build();

    public static final ParameterID<Percentage> ABSOLUTE_THROTTLE_POSITION_B = ParameterID.<Percentage>builder()
            .mode(1)
            .id(0x47)
            .returnedBytes(1)
            .description("Absolute throttle position B")
            .decoder(Percentage.deserializer())
            .build();

    public static final ParameterID<Percentage> ABSOLUTE_THROTTLE_POSITION_C = ParameterID.<Percentage>builder()
            .mode(1)
            .id(0x48)
            .returnedBytes(1)
            .description("Absolute throttle position C")
            .decoder(Percentage.deserializer())
            .build();

    public static final ParameterID<Percentage> ACCELERATOR_PEDAL_POSITION_D = ParameterID.<Percentage>builder()
            .mode(1)
            .id(0x49)
            .returnedBytes(1)
            .description("Accelerator pedal position D")
            .decoder(Percentage.deserializer())
            .build();

    public static final ParameterID<Percentage> ACCELERATOR_PEDAL_POSITION_E = ParameterID.<Percentage>builder()
            .mode(1)
            .id(0x4A)
            .returnedBytes(1)
            .description("Accelerator pedal position E")
            .decoder(Percentage.deserializer())
            .build();

    public static final ParameterID<Percentage> ACCELERATOR_PEDAL_POSITION_F = ParameterID.<Percentage>builder()
            .mode(1)
            .id(0x4B)
            .returnedBytes(1)
            .description("Accelerator pedal position F")
            .decoder(Percentage.deserializer())
            .build();

    public static final ParameterID<Percentage> COMMANDED_THROTTLE_ACTUATOR = ParameterID.<Percentage>builder()
            .mode(1)
            .id(0x4C)
            .returnedBytes(1)
            .description("Commanded throttle actuator")
            .decoder(Percentage.deserializer())
            .build();

    public static final ParameterID<Void> TIME_RUN_WITH_MIL_ON = ParameterID.<Void>builder()
            .mode(1)
            .id(0x4D)
            .returnedBytes(2)
            .description("Time run with MIL on")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> TIME_SINCE_TROUBLE_CODES_CLEARED = ParameterID.<Void>builder()
            .mode(1)
            .id(0x4E)
            .returnedBytes(2)
            .description("Time since trouble codes cleared")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> MAX_VALUES_FAER_OSV_OSC_IIMAP = ParameterID.<Void>builder()
            .mode(1)
            .id(0x4F)
            .returnedBytes(4)
            .description("Maximum value for Fuel–Air equivalence ratio, oxygen sensor voltage, oxygen sensor current, and intake manifold absolute pressure")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> MAX_VALUE_EFR = ParameterID.<Void>builder()
            .mode(1)
            .id(0x50)
            .returnedBytes(4)
            .description("Maximum value for air flow rate from mass air flow sensor")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> FUEL_TYPE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x51)
            .returnedBytes(1)
            .description("Fuel Type")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Percentage> ETHANOL_FUEL_PERCENTAGE = ParameterID.<Percentage>builder()
            .mode(1)
            .id(0x52)
            .returnedBytes(1)
            .description("Ethanol fuel %")
            .decoder(Percentage.deserializer())
            .build();

    public static final ParameterID<Void> ABSOLUTE_EVAP_SYSTEM_VAPOR_PRESSURE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x53)
            .returnedBytes(2)
            .description("Absolute Evap system Vapor Pressure")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> EVAP_SYSTEM_VAPOR_PRESSURE_2 = ParameterID.<Void>builder()
            .mode(1)
            .id(0x54)
            .returnedBytes(2)
            .description("Evap system vapor pressure")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> SHORT_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_A_BANK_1_B_BANK_3 = ParameterID.<Void>builder()
            .mode(1)
            .id(0x55)
            .returnedBytes(2)
            .description("Short term secondary oxygen sensor trim, A: bank 1, B: bank 3")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> LONG_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_A_BANK_1_B_BANK_3 = ParameterID.<Void>builder()
            .mode(1)
            .id(0x56)
            .returnedBytes(2)
            .description("Long term secondary oxygen sensor trim, A: bank 1, B: bank 3")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> SHORT_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_A_BANK_2_B_BANK_4 = ParameterID.<Void>builder()
            .mode(1)
            .id(0x57)
            .returnedBytes(2)
            .description("Short term secondary oxygen sensor trim, A: bank 2, B: bank 4")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> LONG_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_A_BANK_2_B_BANK_4 = ParameterID.<Void>builder()
            .mode(1)
            .id(0x58)
            .returnedBytes(2)
            .description("Long term secondary oxygen sensor trim, A: bank 2, B: bank 4")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> FUEL_RAIL_ABSOLUTE_PRESSURE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x59)
            .returnedBytes(2)
            .description("Fuel rail absolute pressure")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Percentage> RELATIVE_ACCELERATOR_PEDAL_POSITION = ParameterID.<Percentage>builder()
            .mode(1)
            .id(0x5A)
            .returnedBytes(1)
            .description("Relative accelerator pedal position")
            .decoder(Percentage.deserializer())
            .build();

    public static final ParameterID<Percentage> HYBRID_BATTERY_PACK_REMAINING_LIFE = ParameterID.<Percentage>builder()
            .mode(1)
            .id(0x5B)
            .returnedBytes(1)
            .description("Hybrid battery pack remaining life")
            .decoder(Percentage.deserializer())
            .build();

    public static final ParameterID<DegreesCelsius> ENGINE_OIL_TEMPERATURE = ParameterID.<DegreesCelsius>builder()
            .mode(1)
            .id(0x5C)
            .returnedBytes(1)
            .description("Engine oil temperature")
            .decoder(DegreesCelsius.deserializer())
            .build();

 public static final ParameterID<Void> FUEL_INJECTION_TIMING = ParameterID.<Void>builder()
            .mode(1)
            .id(0x5D)
            .returnedBytes(2)
            .description("Fuel injection timing")
            .decoder(bytes -> null) // TODO
            .build();

 public static final ParameterID<Void> ENGINE_FUEL_RATE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x5E)
            .returnedBytes(2)
            .description("Engine fuel rate")
            .decoder(bytes -> null) // TODO
            .build();

 public static final ParameterID<Void> VEHICLE_EMISSION_REQUIREMENTS = ParameterID.<Void>builder()
            .mode(1)
            .id(0x5F)
            .returnedBytes(1)
            .description("Emission requirements to which vehicle is designed")
            .decoder(bytes -> null) // TODO
            .build();


    public static final ParameterID<SupportedPIDsReport> PIDS_SUPPORTED_OXC1_TO_0XE0 = ParameterID.<SupportedPIDsReport>builder()
            .mode(1)
            .id(0xC0)
            .returnedBytes(4)
            .description("PIDs supported [$C1 - $E0]")
            .decoder(SupportedPIDsReport.deserializer(
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,

                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,

                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,

                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER
            ))
            .build();

    public static final ParameterID<SupportedPIDsReport> PIDS_SUPPORTED_OXA1_TO_0XC0 = ParameterID.<SupportedPIDsReport>builder()
            .mode(1)
            .id(0xA0)
            .returnedBytes(4)
            .description("PIDs supported [$A1 - $C0]")
            .decoder(SupportedPIDsReport.deserializer(
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,

                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,

                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,

                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER
            ))
            .build();

    public static final ParameterID<SupportedPIDsReport> PIDS_SUPPORTED_OX81_TO_0XA0 = ParameterID.<SupportedPIDsReport>builder()
            .mode(1)
            .id(0x80)
            .returnedBytes(4)
            .description("PIDs supported [$81 - $A0]")
            .decoder(SupportedPIDsReport.deserializer(
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,

                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,

                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,

                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER
            ))
            .build();


    public static final ParameterID<SupportedPIDsReport> PIDS_SUPPORTED_OX61_TO_0X80 = ParameterID.<SupportedPIDsReport>builder()
            .mode(1)
            .id(0x60)
            .returnedBytes(4)
            .description("PIDs supported [$61 - $80]")
            .decoder(SupportedPIDsReport.deserializer(
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,

                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,

                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,

                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER
            ))
            .build();


    public static final ParameterID<SupportedPIDsReport> PIDS_SUPPORTED_OX41_TO_0X60 = ParameterID.<SupportedPIDsReport>builder()
            .mode(1)
            .id(0x40)
            .returnedBytes(4)
            .description("PIDs supported [$41 - $60]")
            .decoder(SupportedPIDsReport.deserializer(
                    MONITOR_STATUS_THIS_DRIVE_CYCLE,
                    CONTROL_MODULE_VOLTAGE,
                    ABSOLUTE_LOAD_VALUE,
                    COMMANDED_AIR_FUEL_EQUIVALENCE_RATIO,
                    RELATIVE_THROTTLE_POSITION,
                    AMBIENT_AIR_TEMPERATURE,
                    ABSOLUTE_THROTTLE_POSITION_B,
                    ABSOLUTE_THROTTLE_POSITION_C,

                    ACCELERATOR_PEDAL_POSITION_D,
                    ACCELERATOR_PEDAL_POSITION_E,
                    ACCELERATOR_PEDAL_POSITION_F,
                    COMMANDED_THROTTLE_ACTUATOR,
                    TIME_RUN_WITH_MIL_ON,
                    TIME_SINCE_TROUBLE_CODES_CLEARED,
                    MAX_VALUES_FAER_OSV_OSC_IIMAP,
                    MAX_VALUE_EFR,

                    FUEL_TYPE,
                    ETHANOL_FUEL_PERCENTAGE,
                    ABSOLUTE_EVAP_SYSTEM_VAPOR_PRESSURE,
                    EVAP_SYSTEM_VAPOR_PRESSURE_2,
                    SHORT_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_A_BANK_1_B_BANK_3,
                    LONG_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_A_BANK_1_B_BANK_3,
                    SHORT_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_A_BANK_2_B_BANK_4,
                    LONG_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_A_BANK_2_B_BANK_4,

                    FUEL_RAIL_ABSOLUTE_PRESSURE,
                    RELATIVE_ACCELERATOR_PEDAL_POSITION,
                    HYBRID_BATTERY_PACK_REMAINING_LIFE,
                    ENGINE_OIL_TEMPERATURE,
                    FUEL_INJECTION_TIMING,
                    ENGINE_FUEL_RATE,
                    VEHICLE_EMISSION_REQUIREMENTS,
                    PIDS_SUPPORTED_OX61_TO_0X80
            ))
            .build();

    public static final ParameterID<SupportedPIDsReport> PIDS_SUPPORTED_OX21_TO_0X40 = ParameterID.<SupportedPIDsReport>builder()
            .mode(1)
            .id(0x20)
            .returnedBytes(4)
            .description("PIDs supported [$21 - $40]")
            .decoder(SupportedPIDsReport.deserializer(
                    MIL_ON_SINCE,
                    FUEL_RAIL_PRESSURE,
                    FUEL_RAIL_GAUGE_PRESSURE,
                    OXYGEN_SENSOR_1_VOLTAGE,
                    OXYGEN_SENSOR_2_VOLTAGE,
                    OXYGEN_SENSOR_3_VOLTAGE,
                    OXYGEN_SENSOR_4_VOLTAGE,
                    OXYGEN_SENSOR_5_VOLTAGE,
                    OXYGEN_SENSOR_6_VOLTAGE,
                    OXYGEN_SENSOR_7_VOLTAGE,
                    OXYGEN_SENSOR_8_VOLTAGE,
                    COMMANDED_EGR,
                    EGR_ERROR,
                    COMMANDED_EVAPORATIVE_PURGE,
                    FUEL_TANK_LEVEL_INPUT,
                    WARM_UPS_SINCE_CODES_CLEARED,
                    DISTANCE_TRAVELED_SINCE_CODES_CLEARED,
                    EVAP_SYSTEM_VAPOR_PRESSURE,
                    ABSOLUTE_BAROMETRIC_PRESSURE,
                    OXYGEN_SENSOR_1_CURRENT,
                    OXYGEN_SENSOR_2_CURRENT,
                    OXYGEN_SENSOR_3_CURRENT,
                    OXYGEN_SENSOR_4_CURRENT,
                    OXYGEN_SENSOR_5_CURRENT,
                    OXYGEN_SENSOR_6_CURRENT,
                    OXYGEN_SENSOR_7_CURRENT,
                    OXYGEN_SENSOR_8_CURRENT,
                    CAT_TEMPERATURE_BANK_1_SENSOR_1,
                    CAT_TEMPERATURE_BANK_2_SENSOR_1,
                    CAT_TEMPERATURE_BANK_1_SENSOR_2,
                    CAT_TEMPERATURE_BANK_2_SENSOR_2,
                    PIDS_SUPPORTED_OX41_TO_0X60
            ))
            .build();

    public static final ParameterID<SupportedPIDsReport> PIDS_SUPPORTED_OX01_TO_0X20 = ParameterID.<SupportedPIDsReport>builder()
            .mode(1)
            .id(0x00)
            .returnedBytes(4)
            .description("PIDs supported [$01 - $20]")
            .decoder(SupportedPIDsReport.deserializer(
                    MONITOR_STATUS,
                    FREEZE_FRAME_DTC,
                    FUEL_SYSTEM_STATUS,
                    CALCULATED_ENGINE_LOAD,
                    ENGINE_COOLANT_TEMPERATURE,
                    STFT_1,
                    LTFT_1,
                    STFT_2,
                    LTFT_2,
                    FUEL_PRESURE,
                    INTAKE_MANIFOLD_ABS_PRESSURE,
                    ENGINE_SPEED,
                    VEHICLE_SPEED,
                    TIMING_ADVANCE,
                    INTAKE_AIR_TEMPERATURE,
                    MAF_AIR_FLOW_RATE,
                    THROTTLE_POSITION,
                    COMMANDED_SECONDARY_AIR_STATUS,
                    OXYGEN_SENSORS_PRESENT,
                    OXYGEN_SENSOR_1,
                    OXYGEN_SENSOR_2,
                    OXYGEN_SENSOR_3,
                    OXYGEN_SENSOR_4,
                    OXYGEN_SENSOR_5,
                    OXYGEN_SENSOR_6,
                    OXYGEN_SENSOR_7,
                    OXYGEN_SENSOR_8,
                    VEHICLE_OBD_STANDARDS,
                    OXYGEN_SENSORS_PRESENT_4_BANKS,
                    AUXILIARY_INPUT_STATUS,
                    RUN_TIME_SINCE_ENGINE_START,
                    PIDS_SUPPORTED_OX41_TO_0X60
            ))
            .build();
}
