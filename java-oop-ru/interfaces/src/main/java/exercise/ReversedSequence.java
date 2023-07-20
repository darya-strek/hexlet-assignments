package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    String text;

    public ReversedSequence(String text) {
        this.text = text;
    }

    public ReversedSequence() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public char charAt(int index) {
        if (text.length() == 0) {
            return '-';
        }
        return text.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if (text.length() == 0) {
            return null;
        }
        return text.subSequence(start, end);
    }

    public String toString() {
        String result = "";
        for (var i = text.length() - 1; i >= 0; i--) {
            result += text.charAt(i);
        }
        return result;
    }
}
// END
