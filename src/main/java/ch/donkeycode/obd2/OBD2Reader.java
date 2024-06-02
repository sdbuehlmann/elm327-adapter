package ch.donkeycode.obd2;

import ch.donkeycode.common.CastHelper;
import ch.donkeycode.obd2.elm327.Connection;
import ch.donkeycode.obd2.elm327.OBD2ErrorCode;
import ch.donkeycode.obd2.pids.ParameterID;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class OBD2Reader {

    private final Connection connection;

    @SneakyThrows
    public <T> ReadResult<T> tryRead(ParameterID<T> pid) {
        val command = String.format("%02X%02X\r", pid.getMode(), pid.getId());

        val responseString = connection.sendAndReceive(
                        command,
                        Duration.ofSeconds(2))
                .orElseThrow(TimeoutException::new);

        val data = hexStringToByteArray(responseString
                .replace("SEARCHING...", "")
                .replace("\r", "")
                .replace("\n", "")
                .replace(">", "")
                .replace(" ", ""));

        val responseCode = data[0];

        Response<T> response = null;
        if (responseCode >= 0x41 && responseCode <= 0x49) {
            // positive response
            val responseMode = responseCode - 40;
            val responsePid = data[1];
            val responseData = Arrays.stream(data)
                    .skip(2)
                    .collect(Collectors.toList());

            response = PositiveResponse.builder()
                    .responseMode(responseMode)
                    .responsePid(responsePid)
                    .responseData(responseData)
                    .decoded(pid.getDecoder().apply(responseData))
                    .build();
        }

        if (responseCode == 0x7F) {
            // negative response
            val responseMode = data[1];
            val error = OBD2ErrorCode.fromByte(data[2]);

            response = NegativeResponse.builder()
                    .responseMode(responseMode)
                    .errorCode(error)
                    .build();
        }

        val result = ReadResult.<T>builder()
                .pid(pid)
                .plainCommand(command)
                .plainResponse(responseString)
                .response(Optional.ofNullable(response))
                .build();

        log.debug("Reading finished: {}", result);

        return result;
    }

    @Value
    @Builder
    public static class ReadResult<T> {
        ParameterID<T> pid;

        String plainCommand;
        String plainResponse;

        Optional<Response<T>> response;
    }

    public interface Response<T> {
        default Optional<PositiveResponse<T>> positive() {
            return CastHelper.tryCast(this, PositiveResponse.class)
                    .map(positiveResponse -> (PositiveResponse<T>)positiveResponse);
        }

        default Optional<NegativeResponse> negative() {
            return CastHelper.tryCast(this, NegativeResponse.class);
        }
    }

    @Value
    @Builder
    public static class PositiveResponse<T> implements Response {
        int responseMode;
        int responsePid;
        List<Byte> responseData;
        T decoded;
    }

    @Value
    @Builder
    public static class NegativeResponse implements Response {
        int responseMode;
        OBD2ErrorCode errorCode;
    }

    @SneakyThrows
    public <T> T read(ParameterID<T> pid) {
        val command = String.format("%02X%02X\r", pid.getMode(), pid.getId());

        val response = connection.sendAndReceive(
                        command,
                        Duration.ofSeconds(2))
                .orElseThrow(TimeoutException::new);

        val data = hexStringToByteArray(response
                .replace("SEARCHING...", "")
                .replace("\r", "")
                .replace("\n", "")
                .replace(">", "")
                .replace(" ", ""));

        val responseCode = data[0];

        if (responseCode >= 0x41 && responseCode <= 0x49) {
            // positive response
            val responseMode = responseCode - 40;
            val responsePid = data[1];
            val responseData = Arrays.stream(data)
                    .skip(2)
                    .collect(Collectors.toList());

            return pid.getDecoder().apply(responseData);
        }

        if (responseCode == 0x7F) {
            // negative response
            throw new RuntimeException();
        }

        throw new RuntimeException();
    }

    public static Byte[] hexStringToByteArray(String hexString) {
        if (hexString.length() % 2 != 0) {
            throw new IllegalArgumentException("Ungültige Hexadezimalzeichenkette: ungerade Länge.");
        }

        int len = hexString.length();
        Byte[] data = new Byte[len / 2];

        for (int i = 0; i < len; i += 2) {
            int firstDigit = Character.digit(hexString.charAt(i), 16);
            int secondDigit = Character.digit(hexString.charAt(i + 1), 16);

            if (firstDigit == -1 || secondDigit == -1) {
                throw new IllegalArgumentException("Ungültige Hexadezimalzeichenkette: enthält ungültige Zeichen.");
            }

            data[i / 2] = (byte) ((firstDigit << 4) + secondDigit);
        }

        return data;
    }
}
