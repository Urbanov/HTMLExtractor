// Generated from C:/Users/Admin/IdeaProjects/HTMLExtractor/src/main/resources\HTMLParser.g4 by ANTLR 4.7

package edu.pw.htmlextractor.parser.generated;
import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HTMLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHITESPACE=1, DOCTYPE=2, COMMENT=3, SCRIPT_START=4, STYLE_START=5, SVG_START=6, 
		TAG_OPEN=7, END_TAG_OPEN=8, TEXT=9, TAG_NAME=10, TAG_CLOSE=11, TAG_SELF_CLOSE=12, 
		ATTRIBUTE_NAME=13, ATTRIBUTE_EQUALS=14, ATTRIBUTE_WHITESPACE=15, VALUE_WHITESPACE=16, 
		ATTRIBUTE_VALUE=17, SCRIPT_BODY=18, STYLE_BODY=19, SVG_BODY=20;
	public static final int
		RULE_htmlAttribute = 0, RULE_htmlElement = 1, RULE_script = 2, RULE_style = 3, 
		RULE_svg = 4, RULE_htmlAttributes = 5, RULE_htmlContent = 6, RULE_htmlDocument = 7;
	public static final String[] ruleNames = {
		"htmlAttribute", "htmlElement", "script", "style", "svg", "htmlAttributes", 
		"htmlContent", "htmlDocument"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "'<'", "'</'", null, null, "'>'", 
		"'/>'", null, "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WHITESPACE", "DOCTYPE", "COMMENT", "SCRIPT_START", "STYLE_START", 
		"SVG_START", "TAG_OPEN", "END_TAG_OPEN", "TEXT", "TAG_NAME", "TAG_CLOSE", 
		"TAG_SELF_CLOSE", "ATTRIBUTE_NAME", "ATTRIBUTE_EQUALS", "ATTRIBUTE_WHITESPACE", 
		"VALUE_WHITESPACE", "ATTRIBUTE_VALUE", "SCRIPT_BODY", "STYLE_BODY", "SVG_BODY"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "HTMLParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HTMLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class HtmlAttributeContext extends ParserRuleContext {
		public TerminalNode ATTRIBUTE_NAME() { return getToken(HTMLParser.ATTRIBUTE_NAME, 0); }
		public TerminalNode ATTRIBUTE_EQUALS() { return getToken(HTMLParser.ATTRIBUTE_EQUALS, 0); }
		public TerminalNode ATTRIBUTE_VALUE() { return getToken(HTMLParser.ATTRIBUTE_VALUE, 0); }
		public HtmlAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterHtmlAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitHtmlAttribute(this);
		}
	}

	public final HtmlAttributeContext htmlAttribute() throws RecognitionException {
		HtmlAttributeContext _localctx = new HtmlAttributeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_htmlAttribute);
		try {
			setState(20);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				match(ATTRIBUTE_NAME);
				setState(17);
				match(ATTRIBUTE_EQUALS);
				setState(18);
				match(ATTRIBUTE_VALUE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
				match(ATTRIBUTE_NAME);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HtmlElementContext extends ParserRuleContext {
		public Token start;
		public Token end;
		public TerminalNode TAG_OPEN() { return getToken(HTMLParser.TAG_OPEN, 0); }
		public List<TerminalNode> TAG_NAME() { return getTokens(HTMLParser.TAG_NAME); }
		public TerminalNode TAG_NAME(int i) {
			return getToken(HTMLParser.TAG_NAME, i);
		}
		public HtmlAttributesContext htmlAttributes() {
			return getRuleContext(HtmlAttributesContext.class,0);
		}
		public List<TerminalNode> TAG_CLOSE() { return getTokens(HTMLParser.TAG_CLOSE); }
		public TerminalNode TAG_CLOSE(int i) {
			return getToken(HTMLParser.TAG_CLOSE, i);
		}
		public HtmlContentContext htmlContent() {
			return getRuleContext(HtmlContentContext.class,0);
		}
		public TerminalNode END_TAG_OPEN() { return getToken(HTMLParser.END_TAG_OPEN, 0); }
		public TerminalNode TAG_SELF_CLOSE() { return getToken(HTMLParser.TAG_SELF_CLOSE, 0); }
		public ScriptContext script() {
			return getRuleContext(ScriptContext.class,0);
		}
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public SvgContext svg() {
			return getRuleContext(SvgContext.class,0);
		}
		public HtmlElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterHtmlElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitHtmlElement(this);
		}
	}

	public final HtmlElementContext htmlElement() throws RecognitionException {
		HtmlElementContext _localctx = new HtmlElementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_htmlElement);
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAG_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				match(TAG_OPEN);
				setState(23);
				((HtmlElementContext)_localctx).start = match(TAG_NAME);
				setState(42);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(24);
					if (!(
					            Arrays.asList(
					            "a", "author", "abbr", "address", "article", "aside", "audio", "b", "bdi", "bdo", "blockquote", "body", "button",
					            "canvas", "caption", "center", "cite", "code", "colgroup", "data", "datalist", "dd", "del", "details", "dfn",
					            "dialog", "dir", "div", "dl", "dt", "em", "fieldset", "figcaption", "figure", "font", "footer", "form", "frameset",
					            "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "html", "i", "iframe", "ins", "kbd", "label", "legend", "li",
					            "main", "map", "mark", "menu", "menuitem", "meter", "nav", "nobr", "noframes", "noscript", "object", "ol", "optgroup",
					            "option", "output", "p", "picture", "pre", "progress", "q", "rp", "rt", "ruby", "s", "samp", "section", "select",
					            "small", "span", "strike", "strong", "sub", "summary", "sup", "svg", "table", "tbody", "td","template", "textarea",
					            "tfoot", "th", "thead", "time", "title", "tr", "tt", "u", "ul", "var", "video"
					        ).contains(_localctx.start.getText())
					        )) throw new FailedPredicateException(this, "\r\n            Arrays.asList(\r\n            \"a\", \"author\", \"abbr\", \"address\", \"article\", \"aside\", \"audio\", \"b\", \"bdi\", \"bdo\", \"blockquote\", \"body\", \"button\",\r\n            \"canvas\", \"caption\", \"center\", \"cite\", \"code\", \"colgroup\", \"data\", \"datalist\", \"dd\", \"del\", \"details\", \"dfn\",\r\n            \"dialog\", \"dir\", \"div\", \"dl\", \"dt\", \"em\", \"fieldset\", \"figcaption\", \"figure\", \"font\", \"footer\", \"form\", \"frameset\",\r\n            \"h1\", \"h2\", \"h3\", \"h4\", \"h5\", \"h6\", \"head\", \"header\", \"html\", \"i\", \"iframe\", \"ins\", \"kbd\", \"label\", \"legend\", \"li\",\r\n            \"main\", \"map\", \"mark\", \"menu\", \"menuitem\", \"meter\", \"nav\", \"nobr\", \"noframes\", \"noscript\", \"object\", \"ol\", \"optgroup\",\r\n            \"option\", \"output\", \"p\", \"picture\", \"pre\", \"progress\", \"q\", \"rp\", \"rt\", \"ruby\", \"s\", \"samp\", \"section\", \"select\",\r\n            \"small\", \"span\", \"strike\", \"strong\", \"sub\", \"summary\", \"sup\", \"svg\", \"table\", \"tbody\", \"td\",\"template\", \"textarea\",\r\n            \"tfoot\", \"th\", \"thead\", \"time\", \"title\", \"tr\", \"tt\", \"u\", \"ul\", \"var\", \"video\"\r\n        ).contains($ctx.start.getText())\r\n        ");
					setState(25);
					htmlAttributes();
					setState(26);
					match(TAG_CLOSE);
					setState(27);
					htmlContent();
					setState(28);
					match(END_TAG_OPEN);
					setState(29);
					((HtmlElementContext)_localctx).end = match(TAG_NAME);
					setState(30);
					match(TAG_CLOSE);
					setState(31);
					if (!(
					            _localctx.start.getText().equals(_localctx.end.getText())
					        )) throw new FailedPredicateException(this, "\r\n            $ctx.start.getText().equals($ctx.end.getText())\r\n        ");
					}
					break;
				case 2:
					{
					setState(33);
					if (!(
					            Arrays.asList(
					                "area", "base", "br", "col", "embed", "frame", "hr", "img", "input", "link", "meta", "param", "source", "track", "wbr"
					            ).contains(_localctx.start.getText())
					        )) throw new FailedPredicateException(this, "\r\n            Arrays.asList(\r\n                \"area\", \"base\", \"br\", \"col\", \"embed\", \"frame\", \"hr\", \"img\", \"input\", \"link\", \"meta\", \"param\", \"source\", \"track\", \"wbr\"\r\n            ).contains($ctx.start.getText())\r\n        ");
					setState(40);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						setState(34);
						htmlAttributes();
						setState(35);
						match(TAG_CLOSE);
						}
						break;
					case 2:
						{
						setState(37);
						htmlAttributes();
						setState(38);
						match(TAG_SELF_CLOSE);
						}
						break;
					}
					}
					break;
				}
				}
				break;
			case SCRIPT_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				script();
				}
				break;
			case STYLE_START:
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				style();
				}
				break;
			case SVG_START:
				enterOuterAlt(_localctx, 4);
				{
				setState(46);
				svg();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScriptContext extends ParserRuleContext {
		public TerminalNode SCRIPT_START() { return getToken(HTMLParser.SCRIPT_START, 0); }
		public TerminalNode SCRIPT_BODY() { return getToken(HTMLParser.SCRIPT_BODY, 0); }
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterScript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitScript(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_script);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(SCRIPT_START);
			setState(50);
			match(SCRIPT_BODY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StyleContext extends ParserRuleContext {
		public TerminalNode STYLE_START() { return getToken(HTMLParser.STYLE_START, 0); }
		public TerminalNode STYLE_BODY() { return getToken(HTMLParser.STYLE_BODY, 0); }
		public StyleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_style; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterStyle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitStyle(this);
		}
	}

	public final StyleContext style() throws RecognitionException {
		StyleContext _localctx = new StyleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_style);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(STYLE_START);
			setState(53);
			match(STYLE_BODY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SvgContext extends ParserRuleContext {
		public TerminalNode SVG_START() { return getToken(HTMLParser.SVG_START, 0); }
		public TerminalNode SVG_BODY() { return getToken(HTMLParser.SVG_BODY, 0); }
		public SvgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_svg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterSvg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitSvg(this);
		}
	}

	public final SvgContext svg() throws RecognitionException {
		SvgContext _localctx = new SvgContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_svg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(SVG_START);
			setState(56);
			match(SVG_BODY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HtmlAttributesContext extends ParserRuleContext {
		public List<HtmlAttributeContext> htmlAttribute() {
			return getRuleContexts(HtmlAttributeContext.class);
		}
		public HtmlAttributeContext htmlAttribute(int i) {
			return getRuleContext(HtmlAttributeContext.class,i);
		}
		public HtmlAttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlAttributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterHtmlAttributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitHtmlAttributes(this);
		}
	}

	public final HtmlAttributesContext htmlAttributes() throws RecognitionException {
		HtmlAttributesContext _localctx = new HtmlAttributesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_htmlAttributes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ATTRIBUTE_NAME) {
				{
				{
				setState(58);
				htmlAttribute();
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HtmlContentContext extends ParserRuleContext {
		public List<TerminalNode> TEXT() { return getTokens(HTMLParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(HTMLParser.TEXT, i);
		}
		public List<HtmlElementContext> htmlElement() {
			return getRuleContexts(HtmlElementContext.class);
		}
		public HtmlElementContext htmlElement(int i) {
			return getRuleContext(HtmlElementContext.class,i);
		}
		public HtmlContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterHtmlContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitHtmlContent(this);
		}
	}

	public final HtmlContentContext htmlContent() throws RecognitionException {
		HtmlContentContext _localctx = new HtmlContentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_htmlContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEXT) {
				{
				setState(64);
				match(TEXT);
				}
			}

			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SCRIPT_START) | (1L << STYLE_START) | (1L << SVG_START) | (1L << TAG_OPEN))) != 0)) {
				{
				{
				setState(67);
				htmlElement();
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TEXT) {
					{
					setState(68);
					match(TEXT);
					}
				}

				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HtmlDocumentContext extends ParserRuleContext {
		public TerminalNode DOCTYPE() { return getToken(HTMLParser.DOCTYPE, 0); }
		public List<HtmlElementContext> htmlElement() {
			return getRuleContexts(HtmlElementContext.class);
		}
		public HtmlElementContext htmlElement(int i) {
			return getRuleContext(HtmlElementContext.class,i);
		}
		public HtmlDocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlDocument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterHtmlDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitHtmlDocument(this);
		}
	}

	public final HtmlDocumentContext htmlDocument() throws RecognitionException {
		HtmlDocumentContext _localctx = new HtmlDocumentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_htmlDocument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOCTYPE) {
				{
				setState(76);
				match(DOCTYPE);
				}
			}

			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SCRIPT_START) | (1L << STYLE_START) | (1L << SVG_START) | (1L << TAG_OPEN))) != 0)) {
				{
				{
				setState(79);
				htmlElement();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return htmlElement_sempred((HtmlElementContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean htmlElement_sempred(HtmlElementContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return 
		            Arrays.asList(
		            "a", "author", "abbr", "address", "article", "aside", "audio", "b", "bdi", "bdo", "blockquote", "body", "button",
		            "canvas", "caption", "center", "cite", "code", "colgroup", "data", "datalist", "dd", "del", "details", "dfn",
		            "dialog", "dir", "div", "dl", "dt", "em", "fieldset", "figcaption", "figure", "font", "footer", "form", "frameset",
		            "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "html", "i", "iframe", "ins", "kbd", "label", "legend", "li",
		            "main", "map", "mark", "menu", "menuitem", "meter", "nav", "nobr", "noframes", "noscript", "object", "ol", "optgroup",
		            "option", "output", "p", "picture", "pre", "progress", "q", "rp", "rt", "ruby", "s", "samp", "section", "select",
		            "small", "span", "strike", "strong", "sub", "summary", "sup", "svg", "table", "tbody", "td","template", "textarea",
		            "tfoot", "th", "thead", "time", "title", "tr", "tt", "u", "ul", "var", "video"
		        ).contains(_localctx.start.getText())
		        ;
		case 1:
			return 
		            _localctx.start.getText().equals(_localctx.end.getText())
		        ;
		case 2:
			return 
		            Arrays.asList(
		                "area", "base", "br", "col", "embed", "frame", "hr", "img", "input", "link", "meta", "param", "source", "track", "wbr"
		            ).contains(_localctx.start.getText())
		        ;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26X\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\5\2"+
		"\27\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\5\3+\n\3\5\3-\n\3\3\3\3\3\3\3\5\3\62\n\3\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\7\7\7>\n\7\f\7\16\7A\13\7\3\b\5\bD\n\b\3\b\3\b\5"+
		"\bH\n\b\7\bJ\n\b\f\b\16\bM\13\b\3\t\5\tP\n\t\3\t\7\tS\n\t\f\t\16\tV\13"+
		"\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\2\2[\2\26\3\2\2\2\4\61\3\2\2\2\6\63\3"+
		"\2\2\2\b\66\3\2\2\2\n9\3\2\2\2\f?\3\2\2\2\16C\3\2\2\2\20O\3\2\2\2\22\23"+
		"\7\17\2\2\23\24\7\20\2\2\24\27\7\23\2\2\25\27\7\17\2\2\26\22\3\2\2\2\26"+
		"\25\3\2\2\2\27\3\3\2\2\2\30\31\7\t\2\2\31,\7\f\2\2\32\33\6\3\2\3\33\34"+
		"\5\f\7\2\34\35\7\r\2\2\35\36\5\16\b\2\36\37\7\n\2\2\37 \7\f\2\2 !\7\r"+
		"\2\2!\"\6\3\3\3\"-\3\2\2\2#*\6\3\4\3$%\5\f\7\2%&\7\r\2\2&+\3\2\2\2\'("+
		"\5\f\7\2()\7\16\2\2)+\3\2\2\2*$\3\2\2\2*\'\3\2\2\2+-\3\2\2\2,\32\3\2\2"+
		"\2,#\3\2\2\2-\62\3\2\2\2.\62\5\6\4\2/\62\5\b\5\2\60\62\5\n\6\2\61\30\3"+
		"\2\2\2\61.\3\2\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\5\3\2\2\2\63\64\7\6\2"+
		"\2\64\65\7\24\2\2\65\7\3\2\2\2\66\67\7\7\2\2\678\7\25\2\28\t\3\2\2\29"+
		":\7\b\2\2:;\7\26\2\2;\13\3\2\2\2<>\5\2\2\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2"+
		"\2?@\3\2\2\2@\r\3\2\2\2A?\3\2\2\2BD\7\13\2\2CB\3\2\2\2CD\3\2\2\2DK\3\2"+
		"\2\2EG\5\4\3\2FH\7\13\2\2GF\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IE\3\2\2\2JM\3"+
		"\2\2\2KI\3\2\2\2KL\3\2\2\2L\17\3\2\2\2MK\3\2\2\2NP\7\4\2\2ON\3\2\2\2O"+
		"P\3\2\2\2PT\3\2\2\2QS\5\4\3\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2"+
		"U\21\3\2\2\2VT\3\2\2\2\f\26*,\61?CGKOT";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}