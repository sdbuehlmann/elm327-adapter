package ch.donkeycode.obd2.pids.models;

import lombok.Value;

import java.util.List;
import java.util.function.Function;

@Value
public class DegreesCelsius {

    int value;

    public static Function<List<Byte>, DegreesCelsius> deserializer() {
        return bytes -> new DegreesCelsius(bytes.get(0) - 40);
    }
}
