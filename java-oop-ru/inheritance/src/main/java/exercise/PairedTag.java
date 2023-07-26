package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    String tag;
    Map<String, String> attributes;
    String body;
    List<Tag> children;


    public PairedTag(String tag, Map<String, String> attributes, String body, List<Tag> children) {
        super(tag, attributes);
        this.body = body;
        this.children = children;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<Tag> getChildren() {
        return children;
    }

    public void setChildren(List<Tag> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return super.toString() +
                children.stream()
                        .map(child -> child.toString())
                        .collect(Collectors.joining())
                + this.body + "</" + super.getTag() + ">";
    }
}
// END
