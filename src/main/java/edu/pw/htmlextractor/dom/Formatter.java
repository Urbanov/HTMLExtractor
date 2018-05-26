package edu.pw.htmlextractor.dom;

import edu.pw.htmlextractor.app.Filter;
import edu.pw.htmlextractor.dom.tag.*;

import java.nio.CharBuffer;
import java.util.Optional;
import java.util.stream.Collectors;

public final class Formatter {
    private final static int SPACES = 4;

    private Formatter() { }

    // called from outside
    public static void print(Tag tag, StringBuilder buffer, Filter filter) {
        print(tag, buffer, filter, 0);
    }

    private static void indent(StringBuilder buffer, int level) {
        buffer.append(CharBuffer.allocate(SPACES * level).toString().replace('\0', ' '));
    }

    private static void printAttributes(Tag tag, StringBuilder buffer, Filter filter) {
        buffer.append(tag.getAttributes().stream()
            .filter(attribute -> filter.checkAttribute(attribute.getKey()))
            .map(attribute -> " " + attribute.getKey() + (Optional.ofNullable(attribute.getValue()).isPresent()
                ? "=" + attribute.getValue()
                    .trim()
                    .replaceAll("\\s+", " ")
                    .replaceAll("^\" | \"$", "\"")
                    .replaceAll("^' | '$", "'")
                : ""))
            .collect(Collectors.joining()));
    }

    private static void print(Tag tag, StringBuilder buffer, Filter filter, int level) {
        switch (tag.getType()) {
            case NORMAL:
                print((NormalTag) tag, buffer, filter, level);
                break;
            case VOID:
                print((VoidTag) tag, buffer, filter, level);
                break;
            case SELF_CLOSING:
                print((SelfClosingTag) tag, buffer, filter, level);
                break;
            case SCRIPT:
                print((ScriptTag) tag, buffer, filter, level);
                break;
            case STYLE:
                print((StyleTag) tag, buffer, filter, level);
                break;
            case SVG:
                print((SvgTag) tag, buffer, filter, level);
                break;
        }
    }

    private static void print(NormalTag tag, StringBuilder buffer, Filter filter, int level) {
        if (filter.checkTag(tag.getName())) {
            indent(buffer, level);
            buffer.append("<").append(tag.getName());
            printAttributes(tag, buffer, filter);
            buffer.append(">");

            if (!tag.getChildren().isEmpty()) {
                StringBuilder childBuffer = new StringBuilder();
                tag.getChildren().forEach(child -> print(child, childBuffer, filter, level + 1));

                if (childBuffer.length() > 0) {
                    buffer.append("\n");
                    buffer.append(childBuffer);
                    indent(buffer, level);
                }
            }

            buffer.append("</").append(tag.getName()).append(">").append("\n");
        }
        else if (!tag.getChildren().isEmpty()) {
            tag.getChildren().forEach(child -> print(child, buffer, filter, level));
        }
    }

    private static void print(VoidTag tag, StringBuilder buffer, Filter filter, int level) {
        if (filter.checkTag(tag.getName())) {
            indent(buffer, level);
            buffer.append("<").append(tag.getName());
            printAttributes(tag, buffer, filter);
            buffer.append(">").append("\n");
        }
    }

    private static void print(SelfClosingTag tag, StringBuilder buffer, Filter filter, int level) {
        if (filter.checkTag(tag.getName())) {
            indent(buffer, level);
            buffer.append("<").append(tag.getName());
            printAttributes(tag, buffer, filter);
            buffer.append("/>").append("\n");
        }
    }

    private static void print(ScriptTag tag, StringBuilder buffer, Filter filter, int level) {
        if (filter.checkTag("script")) {
            indent(buffer, level);
            buffer.append("<script></script>\n");
        }
    }

    private static void print(StyleTag tag, StringBuilder buffer, Filter filter, int level) {
        if (filter.checkTag("style")) {
            indent(buffer, level);
            buffer.append("<style></style>\n");
        }
    }

    private static void print(SvgTag tag, StringBuilder buffer, Filter filter, int level) {
        if (filter.checkTag("svg")) {
            indent(buffer, level);
            buffer.append("<svg></svg>\n");
        }
    }
}
