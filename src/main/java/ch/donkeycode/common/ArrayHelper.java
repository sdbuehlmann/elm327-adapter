package ch.donkeycode.common;

import java.util.Optional;

public class ArrayHelper {

    public static <T> Optional<T> tryGet(T[] array, int index) {
        if (index >= array.length) {
            return Optional.empty();
        }

        return Optional.of(array[index]);
    }
}
