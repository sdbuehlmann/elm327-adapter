package ch.donkeycode.obd2.elm327;

public class Elm327Commands {

    public static final Elm327Command<Void> RESET = Elm327Command.<Void>builder()
            .description("Reset the ELM327")
            .encoder(unused -> "Z")
            .build();

    public static final Elm327Command<Elm327Protocol> SET_PROTOCOL = Elm327Command.<Elm327Protocol>builder()
            .description("Set protocol of the bus system of the car")
            .encoder(elm327Protocol -> "SP " + elm327Protocol.getCode())
            .build();

    public static final Elm327Command<Void> TEST_PROTOCOL = Elm327Command.<Void>builder()
            .description("Tests a specific protocol if it matches the protocol of the car")
            .encoder(unused -> "TP")
            .build();

    public static final Elm327Command<Void> DESCRIBE_PROTOCOL = Elm327Command.<Void>builder()
            .description("The DP command is a convenient means of asking\n" +
                    "what protocol the IC is currently set to (even if it has\n" +
                    "not yet ‘connected’ to the vehicle).\n")
            .encoder(unused -> "DP")
            .build();
public static final Elm327Command<Void> DESCRIBE_PROTOCOL_BY_NUMBER = Elm327Command.<Void>builder()
            .description("The DP command is a convenient means of asking\n" +
                    "what protocol the IC is currently set to (even if it has\n" +
                    "not yet ‘connected’ to the vehicle).\n")
            .encoder(unused -> "DPN")
            .build();

    public static final Elm327Command<Void> MONITOR_ALL = Elm327Command.<Void>builder()
            .description("Display any information that the ELM327 sees on the OBD bus")
            .encoder(unused -> "MA")
            .build();

    public static final Elm327Command<Boolean> ECHO_MODE = Elm327Command.<Boolean>builder()
            .description("Controls whether or not the chars received on the RS232 port are echoed or not back to the host")
            .encoder(echOn -> echOn ? "E1" : "E0")
            .build();

    public static final Elm327Command<Boolean> SEPARATE_HEX_WITH_SPACE = Elm327Command.<Boolean>builder()
            .description("The ELM327 normally reports ECU repsonses as a series of hex chars that are separated by space char")
            .encoder(addWhitespace -> addWhitespace ? "S1" : "S0")
            .build();

    public static final Elm327Command<Boolean> APPEND_LF = Elm327Command.<Boolean>builder()
            .description("This option controlls the sending of linefeed chars after each carriage return char")
            .encoder(appendLf -> appendLf ? "L1" : "L0")
            .build();

    public static final Elm327Command<Boolean> SHOW_HEADER_INFO = Elm327Command.<Boolean>builder()
            .description("This option controlls wether or not the additional (header) bytes of information are shown in the response")
            .encoder(showHeader -> showHeader ? "H1" : "H0")
            .build();

    public static final Elm327Command<Void> RESET_CAN_RECEIVE_FILTERS = Elm327Command.<Void>builder()
            .description("The AT CRA command is used to restore the CAN receive filters to their default values.")
            .encoder(unused -> "CRA")
            .build();
}
