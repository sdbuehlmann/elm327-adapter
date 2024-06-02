package ch.donkeycode.common;

import java.util.function.Consumer;
import java.util.function.Function;

public class OptionalHelper {

    public static <T> Function<? super T, ? extends T> peek(Consumer<T> consumer) {
        return t -> {
            consumer.accept(t);
            return t;
        };
    }
}
