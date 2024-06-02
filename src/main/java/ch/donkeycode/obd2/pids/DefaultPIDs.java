package ch.donkeycode.obd2.pids;

import ch.donkeycode.obd2.pids.models.SupportedPIDsReport;

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

    public static final ParameterID<Void> CALCULATED_ENGINE_LOAD = ParameterID.<Void>builder()
            .mode(1)
            .id(0x04)
            .returnedBytes(1)
            .description("Calculated engine load.")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> ENGINE_COOLANT_TEMPERATURE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x05)
            .returnedBytes(1)
            .description("Engine coolant temperature.")
            .decoder(bytes -> null) // TODO
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

    public static final ParameterID<Void> INTAKE_MANIFOLD_ABS_PRESSURE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x0B)
            .returnedBytes(1)
            .description("Intake manifold absolute pressure")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> ENGINE_SPEED = ParameterID.<Void>builder()
            .mode(1)
            .id(0x0C)
            .returnedBytes(2)
            .description("Engine speed")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> VEHICLE_SPEED = ParameterID.<Void>builder()
            .mode(1)
            .id(0x0D)
            .returnedBytes(1)
            .description("Vehicle speed")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> TIMING_ADVANCE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x0E)
            .returnedBytes(1)
            .description("Timing advance")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> INTAKE_AIR_TEMPERATURE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x0F)
            .returnedBytes(1)
            .description("Intake air temperature")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> MAF_AIR_FLOW_RATE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x10)
            .returnedBytes(2)
            .description("Mass air flow sensor (MAF) air flow rate")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> THROTTLE_POSITION = ParameterID.<Void>builder()
            .mode(1)
            .id(0x11)
            .returnedBytes(1)
            .description("Throttle position")
            .decoder(bytes -> null) // TODO
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

    public static final ParameterID<Void> VEHICLE_OBD_STANDARDS = ParameterID.<Void>builder()
            .mode(1)
            .id(0x1C)
            .returnedBytes(1)
            .description("OBD standards this vehicle conforms to")
            .decoder(bytes -> null) // TODO
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

    public static final ParameterID<Void> MIL_ON_SINCE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x21)
            .returnedBytes(2)
            .description("Distance traveled with malfunction indicator lamp (MIL) on")
            .decoder(bytes -> null) // TODO
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

    public static final ParameterID<Void> COMMANDED_EGR = ParameterID.<Void>builder()
            .mode(1)
            .id(0x2C)
            .returnedBytes(1)
            .description("Commanded EGR")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> EGR_ERROR = ParameterID.<Void>builder()
            .mode(1)
            .id(0x2D)
            .returnedBytes(1)
            .description("EGR Error")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> COMMANDED_EVAPORATIVE_PURGE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x2E)
            .returnedBytes(1)
            .description("Commanded evaporative purge")
            .decoder(bytes -> null) // TODO
            .build();


    public static final ParameterID<Void> FUEL_TANK_LEVEL_INPUT = ParameterID.<Void>builder()
            .mode(1)
            .id(0x2F)
            .returnedBytes(1)
            .description("Fuel Tank Level Input")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> WARM_UPS_SINCE_CODES_CLEARED = ParameterID.<Void>builder()
            .mode(1)
            .id(0x30)
            .returnedBytes(1)
            .description("Warm-ups since codes cleared")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> DISTANCE_TRAVELED_SINCE_CODES_CLEARED = ParameterID.<Void>builder()
            .mode(1)
            .id(0x31)
            .returnedBytes(2)
            .description("Distance traveled since codes cleared")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> EVAP_SYSTEM_VAPOR_PRESSURE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x32)
            .returnedBytes(2)
            .description("Evap. System Vapor Pressure")
            .decoder(bytes -> null) // TODO
            .build();

    public static final ParameterID<Void> ABSOLUTE_BAROMETRIC_PRESSURE = ParameterID.<Void>builder()
            .mode(1)
            .id(0x33)
            .returnedBytes(2)
            .description("Absolute Barometric Pressure")
            .decoder(bytes -> null) // TODO
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
