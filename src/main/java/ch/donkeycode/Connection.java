package ch.donkeycode;

import jssc.SerialPort;
import jssc.SerialPortException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
public class Connection {

    private final SerialPort serialPort;

    public Connection(String portName) throws SerialPortException {
        log.info("Start serial connection for port {}...", portName);
        serialPort = new SerialPort(portName);

        serialPort.openPort();
        serialPort.setParams(SerialPort.BAUDRATE_38400,
                SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE);
    }

    public Optional<String> sendAndReceive(String command, Duration maxTimeout) throws SerialPortException {
        send(command);
        return readResponseBlocking(maxTimeout);
    }

    public void send(String command) throws SerialPortException {
        log.debug("Send command: {}", StringHelper.makeControlCharsVisible(command));
        serialPort.writeString(command);
    }

    public Optional<String> readResponseBlocking(Duration maxTimeout) throws SerialPortException {
        val startedAt = LocalDateTime.now();
        val maxBlockUntil = startedAt.plus(maxTimeout);

        val response = new StringBuilder();

        while (true) {
            byte[] buffer = serialPort.readBytes(1);
            if (buffer != null && buffer.length > 0) {
                char c = (char) buffer[0];
                response.append(c);
                if (response.toString().endsWith(">")) {
                    break;
                }
            }

            if (LocalDateTime.now().isAfter(maxBlockUntil)) {
                log.info("No complete response received in time. Dropped received data: {}", StringHelper.makeControlCharsVisible(response.toString()));
                return Optional.empty();
            }
        }

        return Optional.of(response.toString());
    }

    public void close() throws SerialPortException {
        log.info("Close serial connection...");
        serialPort.closePort();
    }
}
