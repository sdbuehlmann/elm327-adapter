package ch.donkeycode.obd2.pids.models;

import lombok.Value;

import java.util.List;
import java.util.function.Function;

@Value
public class Presure {
    int valueInKiloPa;

    public static Function<List<Byte>, Presure> deserializer() {
        return bytes -> new Presure(bytes.get(0));
    }
}
