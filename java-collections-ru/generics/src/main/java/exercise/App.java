package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {

    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> pairsCheck) {

        List<Map<String, String>> result = new ArrayList<>();

        for (Map<String, String> book : books) {
            boolean isContain = true;

            for (Map.Entry<String, String> pair : pairsCheck.entrySet()) {
                if (!book.containsValue(pair.getValue())) {
                    isContain = false;
                }
            }

            if (isContain) {
                result.add(book);
            }

        }
        return result;
    }
}
//END
