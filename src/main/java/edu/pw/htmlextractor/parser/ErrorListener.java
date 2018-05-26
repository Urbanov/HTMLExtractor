package edu.pw.htmlextractor.parser;

import edu.pw.htmlextractor.parser.generated.HTMLParser;
import org.antlr.v4.runtime.*;

public class ErrorListener extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        StringBuilder header = new StringBuilder()
            .append("[line ")
            .append(line)
            .append(":")
            .append(charPositionInLine)
            .append("] ");

        if (e instanceof FailedPredicateException) {
            HTMLParser.HtmlElementContext ctx = ((HTMLParser.HtmlElementContext) e.getCtx());
            throw new ParsingException(header.append("tag names mismatch: '")
                .append(ctx.start.getText())
                .append("' and '")
                .append(ctx.end.getText())
                .append("'")
                .toString()
            );
        }

        else if (e instanceof InputMismatchException) {
            throw new ParsingException(header.append(msg).toString());
        }

        else if (e instanceof LexerNoViableAltException) {
            throw new ParsingException(header.append(msg).toString());
        }

        else if (e instanceof NoViableAltException) {
            throw new ParsingException(header.append("incorrect HTML tag: '")
                .append(((HTMLParser.HtmlElementContext) e.getCtx()).start.getText())
                .append("'")
                .toString()
            );
        }

        // basic parser exceptions
        else {
            throw new ParsingException(header.append(msg).toString());
        }
    }
}
