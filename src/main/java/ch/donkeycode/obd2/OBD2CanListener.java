package ch.donkeycode.obd2;

import ch.donkeycode.common.StringHelper;
import ch.donkeycode.obd2.elm327.Connection;
import ch.donkeycode.obd2.elm327.Elm327CommandSender;
import jssc.SerialPortException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.time.Duration;

@Slf4j
public class OBD2CanListener {
    private final Connection connection;
    private final OBD2ATCommandsSender atCommandsSender;

    public OBD2CanListener(Connection connection) {
        this.connection = connection;
        this.atCommandsSender = new OBD2ATCommandsSender(connection);
    }

    @SneakyThrows
    public void start() {
        log.info("CAN listener started");

        atCommandsSender.reset();
        atCommandsSender.setProtocolToISO15765_4_CAN();
        atCommandsSender.enableCANPassTroughMode();
        atCommandsSender.startReadeCANMessages();

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
