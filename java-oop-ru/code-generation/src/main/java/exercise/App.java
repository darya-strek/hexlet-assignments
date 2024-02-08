package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
class App {
    public static void save(Path filePath, Car car) throws IOException {
        String data = Car.serialize(car);
        Files.writeString(filePath, data, StandardOpenOption.APPEND);
    }

    public static Car extract(Path filePath) throws IOException {
        String data = Files.readString(filePath);
        return Car.unserialize(data);
    }
}
// END
