package ch.donkeycode.obd2.pids.models;

import lombok.Value;

import java.util.List;
import java.util.function.Function;

@Value
public class Percentage {

    int value;

    public static Function<List<Byte>, Percentage> deserializer() {
        return bytes -> new Percentage(bytes.get(0) * 100 / 255);
    }
}
