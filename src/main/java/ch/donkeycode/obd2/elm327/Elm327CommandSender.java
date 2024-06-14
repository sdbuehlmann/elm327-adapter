package ch.donkeycode.obd2.elm327;

import ch.donkeycode.common.StringHelper;
import ch.qos.logback.core.util.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

@Slf4j
@RequiredArgsConstructor
public class Elm327CommandSender {

    private final Connection connection;

    @SneakyThrows
    public <T> String send(Elm327Command<T> command, T data) {
        val atCommand = "AT " + command.getEncoder().apply(data) + "\r\n";

        val response = connection.sendAndReceive(
                        atCommand,
                        Duration.ofSeconds(2))
                .orElseThrow(TimeoutException::new);

        log.debug("Sended {} to ELM327 and received {}", StringHelper.makeControlCharsVisible(atCommand), StringHelper.makeControlCharsVisible(response));

        Thread.sleep(200);

        return response;
    }
}
