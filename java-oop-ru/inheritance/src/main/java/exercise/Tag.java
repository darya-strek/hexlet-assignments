package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private String tag;
    private Map<String, String> attributes;

    public Tag(String tag, Map<String, String> attributes) {
        this.tag = tag;
        this.attributes = attributes;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String toString() {
        String mapString = "";
        if (!attributes.isEmpty()) {
            mapString = " " + this.attributes.keySet().stream()
                    .map(key -> key + "=\"" + this.attributes.get(key) + "\"")
                    .collect(Collectors.joining(" "));
        }
        return "<" + this.tag + mapString + ">";
    }
}
// END
