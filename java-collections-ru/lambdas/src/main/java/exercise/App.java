package exercise;

import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        return Arrays.stream(image)
                .flatMap(array -> Stream.of(duplicate(array), duplicate(array)))
                .toArray(String[][]::new);
    }

    private static String[] duplicate(String[] line) {
        return Arrays.stream(line)
                .flatMap(element -> Stream.of(element, element))
                .toArray(String[]::new);
    }
}
// END
