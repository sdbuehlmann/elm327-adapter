package ch.donkeycode.obd2;

import ch.donkeycode.common.StringHelper;
import ch.donkeycode.obd2.elm327.Connection;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

@Slf4j
@RequiredArgsConstructor
public class OBD2ATCommandsSender {
    private final Connection connection;

    @SneakyThrows
    public void reset() {
        connection.sendAndReceive("AT Z\r", Duration.ofSeconds(5))
                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));
    }

    @SneakyThrows
    public void setProtocolToISO15765_4_CAN() {
        connection.sendAndReceive("AT SP 6\r", Duration.ofSeconds(5))
                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));
    }

    @SneakyThrows
    public void enableCANPassTroughMode() {
        connection.sendAndReceive("AT CRA 000\r", Duration.ofSeconds(5))
                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));
    }

    @SneakyThrows
    public void startReadeCANMessages() {
        connection.sendAndReceive("AT MA\r", Duration.ofSeconds(5))
                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));
    }

}
