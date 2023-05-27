package exercise;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {

    @Test
    void testEnlargeArrayImage1() {
        String[][] image = {
                {"+", "-"},
                {"-", "+"},
        };

        String[][] actual = App.enlargeArrayImage(image);
        String[][] expected = {{"+", "+", "-", "-"}, {"+", "+", "-", "-"}, {"-", "-", "+", "+"}, {"-", "-", "+", "+"}};
        assertThat(Arrays.deepToString(actual)).isEqualTo(Arrays.deepToString(expected));
    }

    @Test
    void testEnlargeArrayImage2() {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };

        String[][] actual = App.enlargeArrayImage(image);
        String[][] expected = {
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
        };

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testEnlargeArrayImage3() {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };

        String[][] actual = App.enlargeArrayImage(image);
        int lengthActual = actual[0].length * actual.length;
        assertThat(lengthActual).isEqualTo(64);
    }

    @Test
    void testEnlargeArrayImage4() {
        String[][] image = {};
        String[][] actual = App.enlargeArrayImage(image);
        String[][] expected = {};
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testEnlargeArrayImage5() {
        String[][] image = {
                {"@", "@"},
                {"@", "|"},
                {"—", "|"},
                {"@", "|"},
                {"@", "@"},
        };

        String[][] enlargedImage = {
                {"@", "@", "@", "@"},
                {"@", "@", "@", "@"},
                {"@", "@", "|", "|"},
                {"@", "@", "|", "|"},
                {"—", "—", "|", "|"},
                {"—", "—", "|", "|"},
                {"@", "@", "|", "|"},
                {"@", "@", "|", "|"},
                {"@", "@", "@", "@"},
                {"@", "@", "@", "@"},
        };

        String[][] actual = App.enlargeArrayImage(image);
        assertThat(actual).isEqualTo(enlargedImage);
    }

}
// END
