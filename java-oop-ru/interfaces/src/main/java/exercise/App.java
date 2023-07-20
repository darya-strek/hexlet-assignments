package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int number) {
        List<String> sortedApartments = apartments.stream()
                .sorted(Comparator.comparing(x -> x.getArea()))
                .limit(number)
                .map(x -> x.toString())
                .collect(Collectors.toList());
        return sortedApartments;
    }
}
// END
