package edu.pw.htmlextractor.parser;

import edu.pw.htmlextractor.dom.HtmlDom;
import edu.pw.htmlextractor.parser.generated.HTMLLexer;
import edu.pw.htmlextractor.parser.generated.HTMLParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.io.IOException;
import java.io.InputStream;

public final class Parser {
    private Parser() { }

    public static HtmlDom parse(InputStream inputStream) throws ParsingException, IOException {
        ErrorListener errorListener = new ErrorListener();

        HTMLLexer lexer = new HTMLLexer(CharStreams.fromStream(inputStream));
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HTMLParser parser = new HTMLParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);

        Builder builder = new Builder();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(builder, parser.htmlDocument());

        return builder.getHtmlDom();
    }
}
