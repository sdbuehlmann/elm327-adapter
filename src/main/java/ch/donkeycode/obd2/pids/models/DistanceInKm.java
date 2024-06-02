package ch.donkeycode.obd2.pids.models;

import lombok.Value;
import lombok.val;

import java.util.List;
import java.util.function.Function;

@Value
public class DistanceInKm {

    int value;

    public static Function<List<Byte>, DistanceInKm> deserializerSmall() {
        return bytes -> {
            val a = bytes.get(0);
            val b = bytes.get(1);

            return new DistanceInKm(256 * a + b);
        };
    }
}
