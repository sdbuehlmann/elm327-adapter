package ch.donkeycode;

import ch.donkeycode.common.StringHelper;
import ch.donkeycode.obd2.OBD2Reader;
import ch.donkeycode.obd2.elm327.Connection;
import ch.donkeycode.obd2.pids.DefaultPIDs;
import ch.donkeycode.obd2.pids.ParameterID;
import jssc.SerialPortException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        val supported = getAllSupported(reader);

        log.info("Supported PIDs are:\n -{}", supported.stream()
                .map(ParameterID::toString)
                .collect(Collectors.joining("\n -")));

        final List<OBD2Reader.ReadResult<Object>> infos = supported.stream()
                .map(parameterID -> (OBD2Reader.ReadResult<Object>) reader.tryRead(parameterID))
                .toList();

        log.info("Successfully read and parsed:\n -{}", infos.stream()
                .filter(readResult -> readResult.getResponse().isPresent())
                .map(objectReadResult -> String.format("%s %s", objectReadResult.getPid(), objectReadResult.getResponse().get()))
                .collect(Collectors.joining("\n -")));

        log.info("Failed to read or parse:\n -{}", infos.stream()
                .filter(readResult -> readResult.getResponse()
                        .map(response -> response.negative().isPresent())
                        .orElse(true))
                .map(OBD2Reader.ReadResult::toString)
                .collect(Collectors.joining("\n -")));

        connection.sendAndReceive("AT Z\r", Duration.ofSeconds(5)) // Reset
                .ifPresent(s -> log.info("Response: {}", StringHelper.makeControlCharsVisible(s)));
        connection.close();
    }

    public static List<ParameterID> getAllSupported(OBD2Reader reader) {
        return Stream.of(
                        DefaultPIDs.PIDS_SUPPORTED_OX01_TO_0X20,
                        DefaultPIDs.PIDS_SUPPORTED_OX21_TO_0X40,
                        DefaultPIDs.PIDS_SUPPORTED_OX41_TO_0X60,
                        DefaultPIDs.PIDS_SUPPORTED_OX61_TO_0X80,
                        DefaultPIDs.PIDS_SUPPORTED_OX81_TO_0XA0,
                        DefaultPIDs.PIDS_SUPPORTED_OXA1_TO_0XC0,
                        DefaultPIDs.PIDS_SUPPORTED_OXC1_TO_0XE0)
                .map(reader::tryRead)
                .flatMap(result -> result.getResponse().stream()
                        .flatMap(response -> response.positive().stream()))
                .flatMap(positiveResponse -> positiveResponse.getDecoded().getSupportedPids().stream())
                .collect(Collectors.toList());
    }
}