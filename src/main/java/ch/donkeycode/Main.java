package ch.donkeycode;

import ch.donkeycode.common.StringHelper;
import ch.donkeycode.obd2.OBD2Reader;
import ch.donkeycode.obd2.elm327.Connection;
import ch.donkeycode.obd2.pids.DefaultPIDs;
import jssc.SerialPortException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.time.Duration;

@Slf4j
public class Main {
    public static void main(String[] args) throws SerialPortException {
        val connection = new Connection("COM3");
        val reader = new OBD2Reader(connection);

        connection.sendAndReceive("AT Z\r", Duration.ofSeconds(5)) // Reset
                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));

        connection.sendAndReceive("AT SP 0\n", Duration.ofSeconds(5)) // Auto-Protokoll
                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));

        connection.sendAndReceive("ATE0\n", Duration.ofSeconds(5)) // Echo ausschalten
                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));

        connection.sendAndReceive("ATS0\n", Duration.ofSeconds(5)) // Leerzeichen ausschalten
                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));

        connection.sendAndReceive("ATH0\n", Duration.ofSeconds(5)) // Header einschalten
                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));

        connection.sendAndReceive("ATL0\n", Duration.ofSeconds(5)) //  Zeilenumbrüche ausschalten
                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));

        log.info("Supported PIDs: {}", reader.tryRead(DefaultPIDs.PIDS_SUPPORTED_OX01_TO_0X20));
        log.info("Supported PIDs: {}", reader.tryRead(DefaultPIDs.PIDS_SUPPORTED_OX21_TO_0X40));
        log.info("Supported PIDs: {}", reader.tryRead(DefaultPIDs.PIDS_SUPPORTED_OX41_TO_0X60));
        log.info("Supported PIDs: {}", reader.tryRead(DefaultPIDs.PIDS_SUPPORTED_OX61_TO_0X80));
        log.info("Supported PIDs: {}", reader.tryRead(DefaultPIDs.PIDS_SUPPORTED_OX81_TO_0XA0));
        log.info("Supported PIDs: {}", reader.tryRead(DefaultPIDs.PIDS_SUPPORTED_OXA1_TO_0XC0));
        log.info("Supported PIDs: {}", reader.tryRead(DefaultPIDs.PIDS_SUPPORTED_OXC1_TO_0XE0));

        connection.sendAndReceive("AT Z\r", Duration.ofSeconds(5)) // Reset
                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));
        connection.close();
    }
}