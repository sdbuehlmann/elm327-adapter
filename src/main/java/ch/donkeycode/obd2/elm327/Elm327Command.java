package ch.donkeycode.obd2.elm327;

import java.util.Optional;
import java.util.function.Function;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Elm327Command<I> {
    String description;
    Function<I, String> encoder;
    Optional<String> expectedAnswer;
}
