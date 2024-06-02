package ch.donkeycode.common;

import lombok.Value;
import lombok.val;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BitHelper {

    public static byte getBit(byte data, int bitIndex) {
        if (bitIndex < 0 || bitIndex > 7) {
            throw new IllegalArgumentException("Invalid bit index: " + bitIndex);
        }

        return getBits(data, bitIndex, bitIndex);
    }

    public static byte getBits(byte data, int startIndex, int endIndex) {
        val nrBits = endIndex - startIndex + 1;

        val shifted = data >> startIndex;

        int mask = 0;
        for (int index = 0; index < nrBits; index++) {
            mask = mask << 1;
            mask = mask + 1;
        }

        return (byte) (shifted & mask);
    }

    public static Stream<BitStreamEntry> streamBits(List<Byte> bytes) {
        val index = new AtomicInteger(0);
        return bytes.stream()
                .flatMap(singleByte -> IntStream.range(0, 8)
                        .mapToObj(bitIndex ->
                                new BitStreamEntry(
                                        getBit(singleByte, 7 - bitIndex),
                                        index.getAndIncrement()
                                )));
    }

    public static Stream<BitStreamEntry> streamBits(Byte... bytes) {
        return streamBits(List.of(bytes));
    }

    @Value
    public static class BitStreamEntry {
        byte bit;
        int bitIndex;
    }
}
