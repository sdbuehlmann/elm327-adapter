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

    public static final ParameterID<SupportedPIDsReport> PIDS_SUPPORTED = ParameterID.<SupportedPIDsReport>builder()
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
                    RUN_TIME_SINCE_ENGINE_START
            ))
            .build();




}
