package ch.donkeycode.obd2.pids;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import java.util.List;
import java.util.function.Function;

@Builder
@Value
public class ParameterID<T> {
    int mode;
    int id;
    int returnedBytes;
    String description;

    @ToString.Exclude
    Function<List<Byte>, T> decoder;
}
