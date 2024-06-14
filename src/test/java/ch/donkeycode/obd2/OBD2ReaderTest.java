package ch.donkeycode.obd2;

import ch.donkeycode.obd2.elm327.Connection;
import ch.donkeycode.obd2.pids.DefaultPIDs;
import ch.donkeycode.obd2.pids.OBD2Reader;
import ch.donkeycode.obd2.pids.ParameterID;
import jssc.SerialPortException;
import lombok.val;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

class OBD2ReaderTest {
    private final static ParameterID<List<Byte>> PARAMETER_ID = ParameterID.<List<Byte>>builder()
            .mode(1)
            .id(0x10)
            .description("A dummy PID for unit test")
            .returnedBytes(4)
            .decoder(bytes -> bytes)
            .build();

    private final Connection connectionMock = Mockito.mock(Connection.class);
    private final OBD2Reader obd2Reader = new OBD2Reader(connectionMock);

    @Test
    public void test() throws SerialPortException {
        // given
        Mockito.when(connectionMock.sendAndReceive(Mockito.eq("0110\r"), Mockito.any()))
                .thenReturn(Optional.of("SEARCHING...\r41 10 98 3B 00 11 \r\r>"));

        // when
        val response = obd2Reader.read(PARAMETER_ID);

        // then
        Assertions
                .assertThat(response)
                .containsExactly(
                        (byte) 0x98,
                        (byte) 0x3B,
                        (byte) 0x00,
                        (byte) 0x11
                );
    }

    @Test
    public void test2() throws SerialPortException {
        // given
        Mockito.when(connectionMock.sendAndReceive(Mockito.eq("0100\r"), Mockito.any()))
                .thenReturn(Optional.of("SEARCHING...\r41 00 98 3B 00 11 \r\r>"));

        // when
        val response = obd2Reader.read(DefaultPIDs.PIDS_SUPPORTED_OX01_TO_0X20);

        // then
        Assertions
                .assertThat(response)
                .isNotNull();
    }
}