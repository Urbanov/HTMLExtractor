package edu.pw.htmlextractor.dom.tag;

import java.util.ArrayList;
import java.util.List;

public class NormalTag extends Tag {
    private List<Tag> children;

    public NormalTag() {
        super(Type.NORMAL);
        this.children = new ArrayList<>();
    }

    public void addChild(Tag child) {
        children.add(child);
    }

    public List<Tag> getChildren() {
        return children;
    }
}
