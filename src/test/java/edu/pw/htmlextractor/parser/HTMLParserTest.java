package edu.pw.htmlextractor.parser;

import edu.pw.htmlextractor.parser.generated.HTMLLexer;
import edu.pw.htmlextractor.parser.generated.HTMLParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.junit.Assert.*;

public class HTMLParserTest {
    private HTMLParser parserFromData(String data) {
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        HTMLLexer lexer = null;
        try {
            lexer = new HTMLLexer(CharStreams.fromStream(stream, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CommonTokenStream tokens = new CommonTokenStream(Objects.requireNonNull(lexer));
        HTMLParser parser = new HTMLParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());
        return parser;
    }

    @Test
    public void givenHtmlDocumentShouldGetRoot() {
        HTMLParser parser = parserFromData("<!doctype html><html></html>");
        assertNotEquals(null, parser.htmlDocument().htmlElement());
    }

    @Test
    public void givenNormalTagShouldGetNormalTag() {
        HTMLParser parser = parserFromData("<div></div>");
        HTMLParser.HtmlElementContext ctx = parser.htmlElement();
        assertNotEquals(null, ctx.TAG_OPEN());
        assertEquals("div", ctx.TAG_NAME(0).getText());
        assertNotEquals(null, ctx.TAG_CLOSE(0));
        assertNotEquals(null, ctx.END_TAG_OPEN());
        assertEquals("div", ctx.TAG_NAME(1).getText());
        assertNotEquals(null, ctx.TAG_CLOSE(1));
    }

    @Test
    public void givenVoidTagShouldGetVoidTag() {
        HTMLParser parser = parserFromData("<input>");
        HTMLParser.HtmlElementContext ctx = parser.htmlElement();
        assertNotEquals(null, ctx.TAG_OPEN());
        assertEquals("input", ctx.TAG_NAME(0).getText());
        assertNotEquals(null, ctx.TAG_CLOSE(0));
        assertEquals(null, ctx.END_TAG_OPEN());
    }

    @Test(expected = ParsingException.class)
    public void givenIncorrectTagShouldThrow() {
        HTMLParser parser = parserFromData("<test></test>");
        HTMLParser.HtmlElementContext ctx = parser.htmlElement();
    }

    @Test(expected = ParsingException.class)
    public void givenMismatchingTagsShouldThrow() {
        HTMLParser parser = parserFromData("<div></span>");
        HTMLParser.HtmlElementContext ctx = parser.htmlElement();
    }

    @Test
    public void givenScriptTagShouldGetScript() {
        HTMLParser parser = parserFromData("<script type='text/javascript'>console.log('test')</script>");
        HTMLParser.HtmlElementContext ctx = parser.htmlElement();
        assertNotEquals(null, ctx.script());
    }

    @Test
    public void givenTagWithAttributesShouldEnterAttributes() {
        HTMLParser parser = parserFromData("<div class='test1' id='d21'></div>");
        HTMLParser.HtmlElementContext ctx = parser.htmlElement();
        assertNotEquals(null, ctx.htmlAttributes());
    }

    @Test
    public void givenTagWithAttributesShouldGetAttributes() {
        HTMLParser parser = parserFromData("<div class='test1' id='d21'></div>");
        HTMLParser.HtmlAttributesContext ctx = parser.htmlElement().htmlAttributes();
        assertEquals("class", ctx.htmlAttribute(0).ATTRIBUTE_NAME().getText());
        assertEquals("'test1'", ctx.htmlAttribute(0).ATTRIBUTE_VALUE().getText());
        assertEquals("id", ctx.htmlAttribute(1).ATTRIBUTE_NAME().getText());
        assertEquals("'d21'", ctx.htmlAttribute(1).ATTRIBUTE_VALUE().getText());
    }

    @Test(expected = ParsingException.class)
    public void givenUnexpectedTokenShouldThrow() {
        HTMLParser parser = parserFromData("<div></div a>");
        HTMLParser.HtmlElementContext ctx = parser.htmlElement();
    }

    @Test
    public void givenNestedTagsShouldGetInnerTag() {
        HTMLParser parser = parserFromData("<div><span></span></div>");
        HTMLParser.HtmlElementContext ctx = parser.htmlElement();
        assertEquals("span", ctx.htmlContent().htmlElement(0).TAG_NAME(0).getText());
    }
}