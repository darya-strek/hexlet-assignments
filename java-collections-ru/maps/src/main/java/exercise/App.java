package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class App {

    public static Map<String, Integer> getWordCount(String sentence) {

        if (sentence.equals("")) {
            return new HashMap<>();
        }

        String[] wordsArray = sentence.split(" ");
        Map<String, Integer> dictionary = new HashMap<>();

        for (String word : wordsArray) {
            if (!dictionary.containsKey(word)) {
                dictionary.put(word, 1);
            } else {
                dictionary.replace(word, dictionary.get(word) + 1);
            }
        }

        return dictionary;
    }

    public static String toString(Map<String, Integer> dictionary) {

        if (dictionary.isEmpty()) {
            return "{}";
        }

        String result = "";

        for (String key : dictionary.keySet()) {

            result = result + "  " + key + ": " + dictionary.get(key) + "\n";
        }

        return "{\n" + result + "}";
    }
}
//END
