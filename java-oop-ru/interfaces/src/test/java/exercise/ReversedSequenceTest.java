package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ReversedSequenceTest {

    @Test
    void reversedSequenceTest1() {
        CharSequence text = new ReversedSequence("window");

        assertThat(text.toString()).isEqualTo("wodniw");
        assertThat(text.length()).isEqualTo(6);
        assertThat(text.charAt(3)).isEqualTo('d');
        assertThat(text.subSequence(1, 4)).isEqualTo("ind");
    }
    @Test
    void reversedSequenceTest2() {
        CharSequence text = new ReversedSequence("Patrikov");

        assertThat(text.toString()).isEqualTo("vokirtaP");
        assertThat(text.length()).isEqualTo(8);
        assertThat(text.toString().charAt(4)).isEqualTo('r');
        assertThat(text.toString().subSequence(0, 4)).isEqualTo("voki");
    }

    @Test
    void reservedSequenceTestEmpty() {
        CharSequence text = new ReversedSequence("");

        assertThat(text.toString()).isEqualTo("");
        assertThat(text.length()).isEqualTo(0);
        assertThat(text.charAt(3)).isEqualTo('-');
        assertThat(text.subSequence(1, 4)).isEqualTo(null);
    }

}
