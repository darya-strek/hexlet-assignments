package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String symbols, String word) {
        String[] arrayOfSymbols = symbols.toLowerCase().split("");
        List<String> symbolsList = new ArrayList<>(Arrays.asList(arrayOfSymbols));

        String[] arrayOfLetters = word.toLowerCase().split("");
        List<String> lettersList = new ArrayList<>(Arrays.asList(arrayOfLetters));

        if (symbolsList.isEmpty()) {
            return false;
        }

        if (lettersList.isEmpty()) {
            return false;
        }

        for (String letter : lettersList) {
            if (!symbolsList.contains(letter)) {
                return false;
            }
            symbolsList.remove(letter);
        }
        return true;
    }
}
//END
