package ch.donkeycode.obd2.pids.models;

import lombok.Value;

import java.util.List;
import java.util.function.Function;

@Value
public class SpeedInKmPerHour {

    int value;

    public static Function<List<Byte>, SpeedInKmPerHour> deserializer() {
        return bytes -> new SpeedInKmPerHour(bytes.get(0));
    }
}
