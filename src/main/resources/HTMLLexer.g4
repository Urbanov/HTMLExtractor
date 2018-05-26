lexer grammar HTMLLexer;

@header {
package edu.pw.htmlextractor.parser.generated;
}

fragment ALPHA
    : [a-zA-Z]
    ;

fragment DIGIT
    : [0-9]
    ;

fragment DOUBLE_QUOTE_STRING
    : '"' .*? '"'
    ;

fragment SINGLE_QUOTE_STRING
    : '\'' .*? '\''
    ;

WHITESPACE
    :  [ \t\r\n]+ -> skip
    ;

DOCTYPE
    : '<!DOCTYPE' .*? '>'
    | '<!doctype' .*? '>'
    ;

COMMENT
    : '<!--' .*? '-->' -> skip
    ;

SCRIPT_START
    : ('<script>'
    | '<script' .*? '>') -> pushMode(SCRIPT)
    ;

STYLE_START
    : ('<style>'
    | '<style' .*? '>') -> pushMode(STYLE)
    ;

SVG_START
    : ('<svg>'
    | '<svg' .*? '>') -> pushMode(SVG)
    ;

TAG_OPEN
    : '<' -> pushMode(TAG)
    ;

END_TAG_OPEN
    : '</' -> pushMode(TAG)
    ;

TEXT
    : ~'<'+
    ;

mode TAG;
TAG_NAME
    : ALPHA (ALPHA | DIGIT | '-')* -> pushMode(TAG_ATTRIBUTES)
    ;

mode TAG_ATTRIBUTES;
TAG_CLOSE
    : '>' -> popMode, popMode
    ;

TAG_SELF_CLOSE
    : '/>' -> popMode, popMode
    ;

ATTRIBUTE_NAME
    : ALPHA (ALPHA | DIGIT | '-' (ALPHA | DIGIT) | ':' (ALPHA | DIGIT) | '_' (ALPHA | DIGIT))*
    ;

ATTRIBUTE_EQUALS
    : '=' -> pushMode(VALUE)
    ;

ATTRIBUTE_WHITESPACE
    : WHITESPACE -> skip
    ;

mode VALUE;
VALUE_WHITESPACE
    :  WHITESPACE -> skip
    ;

ATTRIBUTE_VALUE
    : (DOUBLE_QUOTE_STRING
    | SINGLE_QUOTE_STRING
    | ~["'`=<> ]+ ) -> popMode
    ;

mode SCRIPT;
SCRIPT_BODY
    : .*? '</script>' -> popMode
    ;

mode STYLE;
STYLE_BODY
    : .*? '</style>' -> popMode
    ;

mode SVG;
SVG_BODY
    : .*? '</svg>' -> popMode
    ;