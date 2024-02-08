package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public static String serialize(Car car) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(car);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Car unserialize(String jsonRepresentation) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(jsonRepresentation, Car.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // END
}
