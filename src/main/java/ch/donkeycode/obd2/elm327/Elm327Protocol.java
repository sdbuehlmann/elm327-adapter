package ch.donkeycode.obd2.elm327;

public enum Elm327Protocol {
    AUTO("0"),
    SAE_J1850_PWM("1"),
    SAE_J1850_VPW("2"),
    ISO_9141_2("3"),
    ISO_14230_4_KWP("4"),
    ISO_14230_4_KWP_FAST("5"),
    ISO_15765_4_CAN_11_BIT_500_KBPS("6"),
    ISO_15765_4_CAN_29_BIT_500_KBPS("7"),
    ISO_15765_4_CAN_11_BIT_250_KBPS("8"),
    ISO_15765_4_CAN_29_BIT_250_KBPS("9"),
    SAE_J1939_CAN("A"),
    USER1_CAN("B"),
    USER2_CAN("C");

    private final String code;

    Elm327Protocol(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return this.name() + " (" + this.code + ")";
    }

    public static Elm327Protocol fromCode(String code) {
        for (Elm327Protocol protocol : Elm327Protocol.values()) {
            if (protocol.getCode().equals(code)) {
                return protocol;
            }
        }
        throw new IllegalArgumentException("Unknown protocol code: " + code);
    }
}
