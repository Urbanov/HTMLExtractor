package edu.pw.htmlextractor.dom.tag;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

public abstract class Tag {
    public enum Type {
        NORMAL, VOID, SELF_CLOSING, SCRIPT, STYLE, SVG
    }

    private Type type;
    private String name;
    private List<Pair<String, String>> attributes;

    public Tag(Type type) {
        this.type = type;
        this.attributes = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAttribute(String name, String value) {
        attributes.add(new Pair<>(name, value));
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public List<Pair<String, String>> getAttributes() {
        return attributes;
    }
}
