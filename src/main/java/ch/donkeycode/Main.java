package ch.donkeycode;

import ch.donkeycode.common.StringHelper;
import ch.donkeycode.obd2.pids.DefaultPIDs;
import ch.donkeycode.obd2.OBD2Reader;
import ch.donkeycode.obd2.elm327.Connection;
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

        val response = reader.read(DefaultPIDs.PIDS_SUPPORTED);
        log.info("Supported PIDs: {}", response);


//        connection.sendAndReceive("AT Z\r", Duration.ofSeconds(5)) // Reset
//                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));
//
//        connection.sendAndReceive("AT SP 0\n", Duration.ofSeconds(5)) // Auto-Protokoll
//                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));
//
//
//        connection.sendAndReceive("03\r", Duration.ofSeconds(30)) // Error codes
//                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));
//
//        connection.sendAndReceive("0100\r", Duration.ofSeconds(30)) // PIDs supported
//                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));
//        connection.sendAndReceive("0120\r", Duration.ofSeconds(30)) // PIDs supported
//                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));
//        connection.sendAndReceive("0140\r", Duration.ofSeconds(30)) // PIDs supported
//                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));
//        connection.sendAndReceive("0160\r", Duration.ofSeconds(30)) // PIDs supported
//                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));
//        connection.sendAndReceive("0180\r", Duration.ofSeconds(30)) // PIDs supported
//                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));
//        connection.sendAndReceive("01A0\r", Duration.ofSeconds(30)) // PIDs supported
//                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));
//        connection.sendAndReceive("01C0\r", Duration.ofSeconds(30)) // PIDs supported
//                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));
//
//
//        connection.sendAndReceive("AT RV\r", Duration.ofSeconds(5)) // Batteriespannung auslesen
//                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));
//
//        connection.sendAndReceive("012F\r", Duration.ofSeconds(30)) // Tankfüllung abfragen (PID 2F)
//                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));
//
//
//
//        connection.sendAndReceive("0146\r", Duration.ofSeconds(30)) // Ambient air temperature NOT WORKING
//                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));
//
//        connection.sendAndReceive("1A80\r", Duration.ofSeconds(30)) // Fiat specific NOT WORKING
//                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));
//
//
//        connection.sendAndReceive("AT Z\r", Duration.ofSeconds(5)) // Reset
//                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));


        connection.close();
    }
}