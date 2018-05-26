package edu.pw.htmlextractor.dom;

import edu.pw.htmlextractor.app.Filter;
import edu.pw.htmlextractor.dom.tag.Tag;

public class HtmlDom {
    private Tag root;

    public HtmlDom(Tag root) {
        this.root = root;
    }

    public String toString(Filter filter) {
        StringBuilder buffer = new StringBuilder();
        Formatter.print(root, buffer, filter);
        return buffer.toString();
    }
}
