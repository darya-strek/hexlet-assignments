package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> result = new ArrayList<>();

        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true);
                    if (field.get(address) == null) {
                        result.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> result = new HashMap<>();

        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            List<String> errorsMessages = new ArrayList<>();

            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true);
                    if (field.get(address) == null) {
                        errorsMessages.add("can not be null");
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

            MinLength minLength = field.getAnnotation(MinLength.class);
            if (minLength != null) {
                try {
                    field.setAccessible(true);
                    String name = (String) field.get(address);
                    if ((name == null) || (name.length() < minLength.minLength())) {
                        errorsMessages.add(String.format("length less than %d", minLength.minLength()));
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

            if (!errorsMessages.isEmpty()) {
                result.put(field.getName(), errorsMessages);
            }

        }
        return result;
    }
}
// END
