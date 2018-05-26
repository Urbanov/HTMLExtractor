package edu.pw.htmlextractor.parser;

import edu.pw.htmlextractor.dom.HtmlDom;
import edu.pw.htmlextractor.dom.tag.*;
import edu.pw.htmlextractor.parser.generated.HTMLParser;
import edu.pw.htmlextractor.parser.generated.HTMLParserBaseListener;

import java.util.Optional;
import java.util.Stack;

public class Builder extends HTMLParserBaseListener {

    private Stack<Tag> scopeStack;
    private HtmlDom dom;

    public Builder() {
        scopeStack = new Stack<>();
    }

    public HtmlDom getHtmlDom() {
        return dom;
    }

    @Override
    public void enterHtmlElement(HTMLParser.HtmlElementContext ctx) {
        Tag tag;

        if (ctx.END_TAG_OPEN() != null) {
            tag = new NormalTag();
        }
        else if (ctx.TAG_SELF_CLOSE() != null) {
            tag = new SelfClosingTag();
        }
        else if (ctx.TAG_OPEN() != null) {
            tag = new VoidTag();
        }
        else if (ctx.script() != null) {
            tag = new ScriptTag();
        }
        else if (ctx.style() != null) {
            tag = new StyleTag();
        }
        else {
            tag = new SvgTag();
        }

        tag.setName(Optional.ofNullable(ctx.TAG_NAME(0)).isPresent()
            ? ctx.TAG_NAME(0).getText()
            : null);

        if (scopeStack.empty()) {
            dom = new HtmlDom(tag);
        }
        else {
            // always safe
            ((NormalTag) scopeStack.peek()).addChild(tag);
        }

        scopeStack.push(tag);
    }

    @Override
    public void exitHtmlElement(HTMLParser.HtmlElementContext ctx) {
        scopeStack.pop();
    }

    @Override
    public void enterHtmlAttributes(HTMLParser.HtmlAttributesContext ctx) {
        ctx.htmlAttribute().forEach(attribute -> scopeStack.peek().addAttribute(
            attribute.ATTRIBUTE_NAME().getText(),
            Optional.ofNullable(attribute.ATTRIBUTE_VALUE()).isPresent() ? attribute.ATTRIBUTE_VALUE().getText() : null));
    }
}
