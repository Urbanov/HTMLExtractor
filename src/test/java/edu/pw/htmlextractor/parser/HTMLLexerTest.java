package edu.pw.htmlextractor.parser;

import edu.pw.htmlextractor.parser.generated.HTMLLexer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;


public class HTMLLexerTest {
    private HTMLLexer lexerFromData(String data) {
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        HTMLLexer lexer = null;
        try {
            lexer = new HTMLLexer(CharStreams.fromStream(stream, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lexer;
    }

    @Test
    public void givenDoctypeShouldGetDoctype() {
        HTMLLexer lexer = lexerFromData("<!DOCTYPE html>");
        assertEquals(HTMLLexer.DOCTYPE, lexer.nextToken().getType());
    }

    @Test
    public void givenCommentShouldOmitComment() {
        HTMLLexer lexer = lexerFromData("<!-- comment <div>AAA</div> -->");
        assertEquals(HTMLLexer.EOF, lexer.nextToken().getType());
    }

    @Test
    public void givenTextAfterCommentShouldGetText() {
        HTMLLexer lexer = lexerFromData("<!-- xD -->TEXT");
        assertEquals("TEXT", lexer.nextToken().getText());
    }

    @Test
    public void givenScriptShouldGetScript() {
        HTMLLexer lexer = lexerFromData("<script> <!--fake comment --> <a></a> </script>");
        assertEquals(HTMLLexer.SCRIPT_START, lexer.nextToken().getType());
        assertEquals(HTMLLexer.SCRIPT_BODY, lexer.nextToken().getType());
    }

    @Test
    public void givenTagShouldGetTag() {
        HTMLLexer lexer = lexerFromData("<div></div>");
        assertEquals(HTMLLexer.TAG_OPEN, lexer.nextToken().getType());
        assertEquals("div", lexer.nextToken().getText());
        assertEquals(HTMLLexer.TAG_CLOSE, lexer.nextToken().getType());
        assertEquals(HTMLLexer.END_TAG_OPEN, lexer.nextToken().getType());
        assertEquals(HTMLLexer.TAG_NAME, lexer.nextToken().getType());
        assertEquals(HTMLLexer.TAG_CLOSE, lexer.nextToken().getType());
    }

    @Test
    public void givenSelfClosingTagShouldGetSelfClosingTag() {
        HTMLLexer lexer = lexerFromData("<input/>");
        assertEquals(HTMLLexer.TAG_OPEN, lexer.nextToken().getType());
        assertEquals("input", lexer.nextToken().getText());
        assertEquals(HTMLLexer.TAG_SELF_CLOSE, lexer.nextToken().getType());
    }

    @Test
    public void givenTagWithAttributeShouldGetAttribute() {
        HTMLLexer lexer = lexerFromData("<button disabled></button>");
        assertEquals(HTMLLexer.TAG_OPEN, lexer.nextToken().getType());
        assertEquals(HTMLLexer.TAG_NAME, lexer.nextToken().getType());
        Token token = lexer.nextToken();
        assertEquals("disabled", token.getText());
        assertEquals(HTMLLexer.ATTRIBUTE_NAME, token.getType());
        assertEquals(HTMLLexer.TAG_CLOSE, lexer.nextToken().getType());
        assertEquals(HTMLLexer.END_TAG_OPEN, lexer.nextToken().getType());
        assertEquals(HTMLLexer.TAG_NAME, lexer.nextToken().getType());
        assertEquals(HTMLLexer.TAG_CLOSE, lexer.nextToken().getType());
    }

    @Test
    public void givenTagWithAttributeAndValueShouldGetAttributeAndValue() {
        HTMLLexer lexer = lexerFromData("<span id='test'></span>");
        assertEquals(HTMLLexer.TAG_OPEN, lexer.nextToken().getType());
        assertEquals(HTMLLexer.TAG_NAME, lexer.nextToken().getType());
        Token token = lexer.nextToken();
        assertEquals("id", token.getText());
        assertEquals(HTMLLexer.ATTRIBUTE_NAME, token.getType());
        assertEquals(HTMLLexer.ATTRIBUTE_EQUALS, lexer.nextToken().getType());
        token = lexer.nextToken();
        assertEquals("'test'", token.getText());
        assertEquals(HTMLLexer.ATTRIBUTE_VALUE, token.getType());
        assertEquals(HTMLLexer.TAG_CLOSE, lexer.nextToken().getType());
        assertEquals(HTMLLexer.END_TAG_OPEN, lexer.nextToken().getType());
        assertEquals(HTMLLexer.TAG_NAME, lexer.nextToken().getType());
        assertEquals(HTMLLexer.TAG_CLOSE, lexer.nextToken().getType());
    }

    @Test
    public void givenTagWithMultipleAttributesShouldGetAllAttributes() {
        HTMLLexer lexer = lexerFromData("<div id='test' class='myClass'></div>");
        assertEquals(HTMLLexer.TAG_OPEN, lexer.nextToken().getType());
        assertEquals(HTMLLexer.TAG_NAME, lexer.nextToken().getType());
        assertEquals("id", lexer.nextToken().getText());
        assertEquals(HTMLLexer.ATTRIBUTE_EQUALS, lexer.nextToken().getType());
        assertEquals("'test'", lexer.nextToken().getText());
        assertEquals("class", lexer.nextToken().getText());
        assertEquals(HTMLLexer.ATTRIBUTE_EQUALS, lexer.nextToken().getType());
        assertEquals("'myClass'", lexer.nextToken().getText());
        assertEquals(HTMLLexer.TAG_CLOSE, lexer.nextToken().getType());
        assertEquals(HTMLLexer.END_TAG_OPEN, lexer.nextToken().getType());
        assertEquals(HTMLLexer.TAG_NAME, lexer.nextToken().getType());
        assertEquals(HTMLLexer.TAG_CLOSE, lexer.nextToken().getType());
    }

    @Test
    public void givenTextWithWhitespacesShouldOmitWhitespaces() {
        HTMLLexer lexer = lexerFromData("<div>\n\t       TEXT\n    \t</div>");
        assertEquals(HTMLLexer.TAG_OPEN, lexer.nextToken().getType());
        assertEquals(HTMLLexer.TAG_NAME, lexer.nextToken().getType());
        assertEquals(HTMLLexer.TAG_CLOSE, lexer.nextToken().getType());
        assertEquals(HTMLLexer.TEXT, lexer.nextToken().getType());
        assertEquals(HTMLLexer.END_TAG_OPEN, lexer.nextToken().getType());
        assertEquals(HTMLLexer.TAG_NAME, lexer.nextToken().getType());
        assertEquals(HTMLLexer.TAG_CLOSE, lexer.nextToken().getType());
    }

    @Test(expected = ParsingException.class)
    public void givenIncorrectInputLexerShouldThrow() {
        HTMLLexer lexer = lexerFromData("<0>");
        lexer.removeErrorListeners();
        lexer.addErrorListener(new ErrorListener());
        lexer.nextToken();
        lexer.nextToken();
    }
}