package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {

    List<Integer> list;

    @BeforeEach
    void getList() {
        list = new ArrayList<>(Arrays.asList(3, 5, 6, 9, 12, 6, 7, 53));
    }

    @Test
    void testTake() {
        assertThat(App.take(list, 3))
                .isEqualTo(List.of(3, 5, 6));

        assertThat(App.take(list, 15))
                .isEqualTo(List.of(3, 5, 6, 9, 12, 6, 7, 53));

        assertThat(App.take(list, 0))
                .isEqualTo(List.of());
    }

    @Test
    void testTake2() {
        List<Integer> actual = App.take(list, 10);
        List<Integer> expected = List.of(3, 5, 6, 9, 12, 6, 7, 53);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void testTake3() {
        List<Integer> list2 = new ArrayList<>();
        assertThat(App.take(list2, 3)).isEqualTo(List.of());
    }
}
