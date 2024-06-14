package ch.donkeycode.obd2.pids;

public enum OBD2ErrorCode {
    GENERAL_REJECT(0x10),
    SERVICE_NOT_SUPPORTED(0x11),
    SUB_FUNCTION_NOT_SUPPORTED(0x12),
    INCORRECT_MESSAGE_LENGTH(0x13),
    BUSY_REPEAT_REQUEST(0x21),
    CONDITIONS_NOT_CORRECT(0x22),
    REQUEST_SEQUENCE_ERROR(0x24),
    NO_RESPONSE_FROM_SUBNET_COMPONENT(0x25),
    FAILURE_PREVENTS_EXECUTION_OF_REQUESTED_ACTION(0x26),
    REQUEST_OUT_OF_RANGE(0x31),
    SECURITY_ACCESS_DENIED(0x33),
    INVALID_KEY(0x35),
    EXCEEDED_NUMBER_OF_ATTEMPTS(0x36),
    REQUIRED_TIME_DELAY_NOT_EXPIRED(0x37),
    UPLOAD_DOWNLOAD_NOT_ACCEPTED(0x70),
    TRANSFER_DATA_SUSPENDED(0x71),
    GENERAL_PROGRAMMING_FAILURE(0x72),
    WRONG_BLOCK_SEQUENCE_COUNTER(0x73),
    RESPONSE_PENDING(0x78),
    SUB_FUNCTION_NOT_SUPPORTED_IN_ACTIVE_SESSION(0x7E),
    SERVICE_NOT_SUPPORTED_IN_ACTIVE_SESSION(0x7F),
    VEHICLE_SPEED_TOO_HIGH(0x81),
    RPM_TOO_HIGH(0x82),
    RPM_TOO_LOW(0x83),
    ENGINE_IS_RUNNING(0x84),
    ENGINE_IS_NOT_RUNNING(0x85),
    ENGINE_RUNTIME_TOO_LOW(0x86),
    TEMPERATURE_TOO_HIGH(0x87),
    TEMPERATURE_TOO_LOW(0x88),
    VEHICLE_SPEED_TOO_LOW(0x89),
    THROTTLE_PEDAL_TOO_HIGH(0x8A),
    THROTTLE_PEDAL_TOO_LOW(0x8B),
    TRANSMISSION_RANGE_NOT_IN_NEUTRAL(0x8C),
    TRANSMISSION_RANGE_NOT_IN_GEAR(0x8D),
    BRAKE_SWITCH_NOT_CLOSED(0x8F),
    SHIFTER_LEVER_NOT_IN_PARK(0x90),
    TORQUE_CONVERTER_CLUTCH_LOCKED(0x91),
    VOLTAGE_TOO_HIGH(0x92),
    VOLTAGE_TOO_LOW(0x93);

    private final int code;

    OBD2ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OBD2ErrorCode fromByte(byte b) {
        int code = b & 0xFF; // Convert byte to an unsigned value
        for (OBD2ErrorCode errorCode : values()) {
            if (errorCode.getCode() == code) {
                return errorCode;
            }
        }
        throw new IllegalArgumentException("Unknown OBD2 error code: " + code);
    }
}

