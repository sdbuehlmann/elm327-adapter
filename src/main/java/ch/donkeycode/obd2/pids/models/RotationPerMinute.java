package ch.donkeycode.obd2.pids.models;

import lombok.Value;
import lombok.val;

import java.util.List;
import java.util.function.Function;

@Value
public class RotationPerMinute {

    int value;

    public static Function<List<Byte>, RotationPerMinute> deserializer() {
        return bytes -> {
            val a = bytes.get(0);
            val b = bytes.get(1);

            return new RotationPerMinute((256 * a + b) / 4);
        };
    }
}
