package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {
    public static String getForwardedVariables(String file) {
        String[] array = file.split("\n");
        return Arrays.stream(array)
                .filter(line -> line.startsWith("environment"))
                .map(line -> line.substring(line.indexOf('\"') + 1, line.lastIndexOf('\"')))
                .map(line -> line.split(","))
                .flatMap(arr -> Arrays.stream(arr))
                .filter(element -> element.startsWith("X_FORWARDED_"))
                .map(element -> element.replaceAll("X_FORWARDED_", ""))
                .peek(System.out::println)
                .collect(Collectors.joining(","));
    }
}
//END
