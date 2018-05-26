parser grammar HTMLParser;

options { tokenVocab=HTMLLexer; }

@header {
package edu.pw.htmlextractor.parser.generated;
import java.util.Arrays;
import java.util.List;
}

htmlAttribute
    : ATTRIBUTE_NAME ATTRIBUTE_EQUALS ATTRIBUTE_VALUE
    | ATTRIBUTE_NAME
    ;

htmlElement
    : TAG_OPEN start=TAG_NAME (
        {
            Arrays.asList(
            "a", "author", "abbr", "address", "article", "aside", "audio", "b", "bdi", "bdo", "blockquote", "body", "button",
            "canvas", "caption", "center", "cite", "code", "colgroup", "data", "datalist", "dd", "del", "details", "dfn",
            "dialog", "dir", "div", "dl", "dt", "em", "fieldset", "figcaption", "figure", "font", "footer", "form", "frameset",
            "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "html", "i", "iframe", "ins", "kbd", "label", "legend", "li",
            "main", "map", "mark", "menu", "menuitem", "meter", "nav", "nobr", "noframes", "noscript", "object", "ol", "optgroup",
            "option", "output", "p", "picture", "pre", "progress", "q", "rp", "rt", "ruby", "s", "samp", "section", "select",
            "small", "span", "strike", "strong", "sub", "summary", "sup", "svg", "table", "tbody", "td","template", "textarea",
            "tfoot", "th", "thead", "time", "title", "tr", "tt", "u", "ul", "var", "video"
        ).contains($ctx.start.getText())
        }? htmlAttributes TAG_CLOSE htmlContent END_TAG_OPEN end=TAG_NAME TAG_CLOSE
        {
            $ctx.start.getText().equals($ctx.end.getText())
        }?

        | {
            Arrays.asList(
                "area", "base", "br", "col", "embed", "frame", "hr", "img", "input", "link", "meta", "param", "source", "track", "wbr"
            ).contains($ctx.start.getText())
        }? (htmlAttributes TAG_CLOSE | htmlAttributes TAG_SELF_CLOSE)
    )
    | script
    | style
    | svg
    ;

script
    : SCRIPT_START SCRIPT_BODY
    ;

style
    : STYLE_START STYLE_BODY
    ;

svg
    : SVG_START SVG_BODY
    ;

htmlAttributes
    : htmlAttribute*
    ;

htmlContent
    : TEXT? (htmlElement TEXT?)*
    ;

htmlDocument
    : DOCTYPE? htmlElement*
    ;