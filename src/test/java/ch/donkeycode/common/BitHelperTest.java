package ch.donkeycode.common;

import lombok.val;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

class BitHelperTest {

    @Test
    public void test() {
        // given

        // when
        val result = BitHelper.streamBits(
                (byte) 0b1010_1100,
                (byte) 0b0011_1111
        ).collect(Collectors.toList());

        // then
        Assertions.assertThat(result)
                .containsExactly(
                        new BitHelper.BitStreamEntry((byte) 1, 0),
                        new BitHelper.BitStreamEntry((byte) 0, 1),
                        new BitHelper.BitStreamEntry((byte) 1, 2),
                        new BitHelper.BitStreamEntry((byte) 0, 3),

                        new BitHelper.BitStreamEntry((byte) 1, 4),
                        new BitHelper.BitStreamEntry((byte) 1, 5),
                        new BitHelper.BitStreamEntry((byte) 0, 6),
                        new BitHelper.BitStreamEntry((byte) 0, 7),

                        new BitHelper.BitStreamEntry((byte) 0, 8),
                        new BitHelper.BitStreamEntry((byte) 0, 9),
                        new BitHelper.BitStreamEntry((byte) 1, 10),
                        new BitHelper.BitStreamEntry((byte) 1, 11),

                        new BitHelper.BitStreamEntry((byte) 1, 12),
                        new BitHelper.BitStreamEntry((byte) 1, 13),
                        new BitHelper.BitStreamEntry((byte) 1, 14),
                        new BitHelper.BitStreamEntry((byte) 1, 15)
                );
    }

}