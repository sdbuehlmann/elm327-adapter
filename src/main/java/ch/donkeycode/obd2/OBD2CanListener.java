package ch.donkeycode.obd2;

import ch.donkeycode.common.StringHelper;
import ch.donkeycode.obd2.elm327.Connection;
import ch.donkeycode.obd2.elm327.Elm327Command;
import ch.donkeycode.obd2.elm327.Elm327CommandSender;
import ch.donkeycode.obd2.elm327.Elm327Commands;
import ch.donkeycode.obd2.elm327.Elm327Protocol;
import jssc.SerialPortException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.time.Duration;

@Slf4j
public class OBD2CanListener {
    private final Connection connection;
    private final Elm327CommandSender elm327CommandSender;

    public OBD2CanListener(Connection connection) {
        this.connection = connection;
        this.elm327CommandSender = new Elm327CommandSender(connection);
    }

    @SneakyThrows
    public void start() {
        log.info("CAN listener started");

        elm327CommandSender.send(Elm327Commands.RESET, null);
        elm327CommandSender.send(Elm327Commands.SET_PROTOCOL, Elm327Protocol.ISO_14230_4_KWP_FAST);
        elm327CommandSender.send(Elm327Commands.ECHO_MODE, false);
        //atSender.send(Elm327Commands.SEPARATE_HEX_WITH_SPACE, false);
        //atSender.send(Elm327Commands.SHOW_HEADER_INFO, false);
        //atSender.send(Elm327Commands.APPEND_LF, false);
        elm327CommandSender.send(Elm327Commands.RESET_CAN_RECEIVE_FILTERS, null);
        elm327CommandSender.send(Elm327Commands.MONITOR_ALL, null);

        val thread = new Thread(() -> {
            while (true) {
                try {
                    connection.readResponseBlocking(Duration.ofSeconds(2))
                            .ifPresentOrElse(
                                    s -> System.out.println("CAN message: " + s),
                                    () -> System.out.println("No CAN message received"));
                } catch (SerialPortException e) {
                    log.error("Unexpected exception", e);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        thread.start();
    }
}
