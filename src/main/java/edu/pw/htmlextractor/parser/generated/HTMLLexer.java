// Generated from C:/Users/Admin/IdeaProjects/HTMLExtractor/src/main/resources\HTMLLexer.g4 by ANTLR 4.7

package edu.pw.htmlextractor.parser.generated;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HTMLLexer extends Lexer {
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
		TAG=1, TAG_ATTRIBUTES=2, VALUE=3, SCRIPT=4, STYLE=5, SVG=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "TAG", "TAG_ATTRIBUTES", "VALUE", "SCRIPT", "STYLE", "SVG"
	};

	public static final String[] ruleNames = {
		"ALPHA", "DIGIT", "DOUBLE_QUOTE_STRING", "SINGLE_QUOTE_STRING", "WHITESPACE", 
		"DOCTYPE", "COMMENT", "SCRIPT_START", "STYLE_START", "SVG_START", "TAG_OPEN", 
		"END_TAG_OPEN", "TEXT", "TAG_NAME", "TAG_CLOSE", "TAG_SELF_CLOSE", "ATTRIBUTE_NAME", 
		"ATTRIBUTE_EQUALS", "ATTRIBUTE_WHITESPACE", "VALUE_WHITESPACE", "ATTRIBUTE_VALUE", 
		"SCRIPT_BODY", "STYLE_BODY", "SVG_BODY"
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


	public HTMLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "HTMLLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u0158\b\1\b\1"+
		"\b\1\b\1\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4"+
		"\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4"+
		"\20\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4"+
		"\27\t\27\4\30\t\30\4\31\t\31\3\2\3\2\3\3\3\3\3\4\3\4\7\4@\n\4\f\4\16\4"+
		"C\13\4\3\4\3\4\3\5\3\5\7\5I\n\5\f\5\16\5L\13\5\3\5\3\5\3\6\6\6Q\n\6\r"+
		"\6\16\6R\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7b\n\7"+
		"\f\7\16\7e\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7s\n"+
		"\7\f\7\16\7v\13\7\3\7\5\7y\n\7\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u0081\n\b\f"+
		"\b\16\b\u0084\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u009d\n\t\f\t\16\t\u00a0"+
		"\13\t\3\t\5\t\u00a3\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\7\n\u00b6\n\n\f\n\16\n\u00b9\13\n\3\n\5\n\u00bc"+
		"\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7"+
		"\13\u00cb\n\13\f\13\16\13\u00ce\13\13\3\13\5\13\u00d1\n\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\6\16\u00df\n\16\r\16\16\16\u00e0"+
		"\3\17\3\17\3\17\3\17\7\17\u00e7\n\17\f\17\16\17\u00ea\13\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\5\22\u00ff\n\22\3\22\3\22\3\22\5\22\u0104\n\22\3\22\3"+
		"\22\3\22\5\22\u0109\n\22\7\22\u010b\n\22\f\22\16\22\u010e\13\22\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\6"+
		"\26\u011f\n\26\r\26\16\26\u0120\5\26\u0123\n\26\3\26\3\26\3\27\7\27\u0128"+
		"\n\27\f\27\16\27\u012b\13\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\30\7\30\u013a\n\30\f\30\16\30\u013d\13\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\7\31\u014b\n\31"+
		"\f\31\16\31\u014e\13\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\r"+
		"AJct\u0082\u009e\u00b7\u00cc\u0129\u013b\u014c\2\32\t\2\13\2\r\2\17\2"+
		"\21\3\23\4\25\5\27\6\31\7\33\b\35\t\37\n!\13#\f%\r\'\16)\17+\20-\21/\22"+
		"\61\23\63\24\65\25\67\26\t\2\3\4\5\6\7\b\7\4\2C\\c|\3\2\62;\5\2\13\f\17"+
		"\17\"\"\3\2>>\7\2\"\"$$))>@bb\2\u016c\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\3#\3\2\2\2\4%\3\2\2\2\4\'\3\2\2\2\4)\3\2\2\2\4+\3\2\2\2"+
		"\4-\3\2\2\2\5/\3\2\2\2\5\61\3\2\2\2\6\63\3\2\2\2\7\65\3\2\2\2\b\67\3\2"+
		"\2\2\t9\3\2\2\2\13;\3\2\2\2\r=\3\2\2\2\17F\3\2\2\2\21P\3\2\2\2\23x\3\2"+
		"\2\2\25z\3\2\2\2\27\u00a2\3\2\2\2\31\u00bb\3\2\2\2\33\u00d0\3\2\2\2\35"+
		"\u00d4\3\2\2\2\37\u00d8\3\2\2\2!\u00de\3\2\2\2#\u00e2\3\2\2\2%\u00ed\3"+
		"\2\2\2\'\u00f2\3\2\2\2)\u00f8\3\2\2\2+\u010f\3\2\2\2-\u0113\3\2\2\2/\u0117"+
		"\3\2\2\2\61\u0122\3\2\2\2\63\u0129\3\2\2\2\65\u013b\3\2\2\2\67\u014c\3"+
		"\2\2\29:\t\2\2\2:\n\3\2\2\2;<\t\3\2\2<\f\3\2\2\2=A\7$\2\2>@\13\2\2\2?"+
		">\3\2\2\2@C\3\2\2\2AB\3\2\2\2A?\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\7$\2\2E"+
		"\16\3\2\2\2FJ\7)\2\2GI\13\2\2\2HG\3\2\2\2IL\3\2\2\2JK\3\2\2\2JH\3\2\2"+
		"\2KM\3\2\2\2LJ\3\2\2\2MN\7)\2\2N\20\3\2\2\2OQ\t\4\2\2PO\3\2\2\2QR\3\2"+
		"\2\2RP\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\b\6\2\2U\22\3\2\2\2VW\7>\2\2WX\7"+
		"#\2\2XY\7F\2\2YZ\7Q\2\2Z[\7E\2\2[\\\7V\2\2\\]\7[\2\2]^\7R\2\2^_\7G\2\2"+
		"_c\3\2\2\2`b\13\2\2\2a`\3\2\2\2be\3\2\2\2cd\3\2\2\2ca\3\2\2\2df\3\2\2"+
		"\2ec\3\2\2\2fy\7@\2\2gh\7>\2\2hi\7#\2\2ij\7f\2\2jk\7q\2\2kl\7e\2\2lm\7"+
		"v\2\2mn\7{\2\2no\7r\2\2op\7g\2\2pt\3\2\2\2qs\13\2\2\2rq\3\2\2\2sv\3\2"+
		"\2\2tu\3\2\2\2tr\3\2\2\2uw\3\2\2\2vt\3\2\2\2wy\7@\2\2xV\3\2\2\2xg\3\2"+
		"\2\2y\24\3\2\2\2z{\7>\2\2{|\7#\2\2|}\7/\2\2}~\7/\2\2~\u0082\3\2\2\2\177"+
		"\u0081\13\2\2\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0083\3\2"+
		"\2\2\u0082\u0080\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085"+
		"\u0086\7/\2\2\u0086\u0087\7/\2\2\u0087\u0088\7@\2\2\u0088\u0089\3\2\2"+
		"\2\u0089\u008a\b\b\2\2\u008a\26\3\2\2\2\u008b\u008c\7>\2\2\u008c\u008d"+
		"\7u\2\2\u008d\u008e\7e\2\2\u008e\u008f\7t\2\2\u008f\u0090\7k\2\2\u0090"+
		"\u0091\7r\2\2\u0091\u0092\7v\2\2\u0092\u00a3\7@\2\2\u0093\u0094\7>\2\2"+
		"\u0094\u0095\7u\2\2\u0095\u0096\7e\2\2\u0096\u0097\7t\2\2\u0097\u0098"+
		"\7k\2\2\u0098\u0099\7r\2\2\u0099\u009a\7v\2\2\u009a\u009e\3\2\2\2\u009b"+
		"\u009d\13\2\2\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009f\3"+
		"\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1"+
		"\u00a3\7@\2\2\u00a2\u008b\3\2\2\2\u00a2\u0093\3\2\2\2\u00a3\u00a4\3\2"+
		"\2\2\u00a4\u00a5\b\t\3\2\u00a5\30\3\2\2\2\u00a6\u00a7\7>\2\2\u00a7\u00a8"+
		"\7u\2\2\u00a8\u00a9\7v\2\2\u00a9\u00aa\7{\2\2\u00aa\u00ab\7n\2\2\u00ab"+
		"\u00ac\7g\2\2\u00ac\u00bc\7@\2\2\u00ad\u00ae\7>\2\2\u00ae\u00af\7u\2\2"+
		"\u00af\u00b0\7v\2\2\u00b0\u00b1\7{\2\2\u00b1\u00b2\7n\2\2\u00b2\u00b3"+
		"\7g\2\2\u00b3\u00b7\3\2\2\2\u00b4\u00b6\13\2\2\2\u00b5\u00b4\3\2\2\2\u00b6"+
		"\u00b9\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00ba\3\2"+
		"\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bc\7@\2\2\u00bb\u00a6\3\2\2\2\u00bb"+
		"\u00ad\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\b\n\4\2\u00be\32\3\2\2"+
		"\2\u00bf\u00c0\7>\2\2\u00c0\u00c1\7u\2\2\u00c1\u00c2\7x\2\2\u00c2\u00c3"+
		"\7i\2\2\u00c3\u00d1\7@\2\2\u00c4\u00c5\7>\2\2\u00c5\u00c6\7u\2\2\u00c6"+
		"\u00c7\7x\2\2\u00c7\u00c8\7i\2\2\u00c8\u00cc\3\2\2\2\u00c9\u00cb\13\2"+
		"\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cc"+
		"\u00ca\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d1\7@"+
		"\2\2\u00d0\u00bf\3\2\2\2\u00d0\u00c4\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\u00d3\b\13\5\2\u00d3\34\3\2\2\2\u00d4\u00d5\7>\2\2\u00d5\u00d6\3\2\2"+
		"\2\u00d6\u00d7\b\f\6\2\u00d7\36\3\2\2\2\u00d8\u00d9\7>\2\2\u00d9\u00da"+
		"\7\61\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\b\r\6\2\u00dc \3\2\2\2\u00dd"+
		"\u00df\n\5\2\2\u00de\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00de\3\2"+
		"\2\2\u00e0\u00e1\3\2\2\2\u00e1\"\3\2\2\2\u00e2\u00e8\5\t\2\2\u00e3\u00e7"+
		"\5\t\2\2\u00e4\u00e7\5\13\3\2\u00e5\u00e7\7/\2\2\u00e6\u00e3\3\2\2\2\u00e6"+
		"\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2"+
		"\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb"+
		"\u00ec\b\17\7\2\u00ec$\3\2\2\2\u00ed\u00ee\7@\2\2\u00ee\u00ef\3\2\2\2"+
		"\u00ef\u00f0\b\20\b\2\u00f0\u00f1\b\20\b\2\u00f1&\3\2\2\2\u00f2\u00f3"+
		"\7\61\2\2\u00f3\u00f4\7@\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\b\21\b\2"+
		"\u00f6\u00f7\b\21\b\2\u00f7(\3\2\2\2\u00f8\u010c\5\t\2\2\u00f9\u010b\5"+
		"\t\2\2\u00fa\u010b\5\13\3\2\u00fb\u00fe\7/\2\2\u00fc\u00ff\5\t\2\2\u00fd"+
		"\u00ff\5\13\3\2\u00fe\u00fc\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff\u010b\3"+
		"\2\2\2\u0100\u0103\7<\2\2\u0101\u0104\5\t\2\2\u0102\u0104\5\13\3\2\u0103"+
		"\u0101\3\2\2\2\u0103\u0102\3\2\2\2\u0104\u010b\3\2\2\2\u0105\u0108\7a"+
		"\2\2\u0106\u0109\5\t\2\2\u0107\u0109\5\13\3\2\u0108\u0106\3\2\2\2\u0108"+
		"\u0107\3\2\2\2\u0109\u010b\3\2\2\2\u010a\u00f9\3\2\2\2\u010a\u00fa\3\2"+
		"\2\2\u010a\u00fb\3\2\2\2\u010a\u0100\3\2\2\2\u010a\u0105\3\2\2\2\u010b"+
		"\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d*\3\2\2\2"+
		"\u010e\u010c\3\2\2\2\u010f\u0110\7?\2\2\u0110\u0111\3\2\2\2\u0111\u0112"+
		"\b\23\t\2\u0112,\3\2\2\2\u0113\u0114\5\21\6\2\u0114\u0115\3\2\2\2\u0115"+
		"\u0116\b\24\2\2\u0116.\3\2\2\2\u0117\u0118\5\21\6\2\u0118\u0119\3\2\2"+
		"\2\u0119\u011a\b\25\2\2\u011a\60\3\2\2\2\u011b\u0123\5\r\4\2\u011c\u0123"+
		"\5\17\5\2\u011d\u011f\n\6\2\2\u011e\u011d\3\2\2\2\u011f\u0120\3\2\2\2"+
		"\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0123\3\2\2\2\u0122\u011b"+
		"\3\2\2\2\u0122\u011c\3\2\2\2\u0122\u011e\3\2\2\2\u0123\u0124\3\2\2\2\u0124"+
		"\u0125\b\26\b\2\u0125\62\3\2\2\2\u0126\u0128\13\2\2\2\u0127\u0126\3\2"+
		"\2\2\u0128\u012b\3\2\2\2\u0129\u012a\3\2\2\2\u0129\u0127\3\2\2\2\u012a"+
		"\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012d\7>\2\2\u012d\u012e\7\61"+
		"\2\2\u012e\u012f\7u\2\2\u012f\u0130\7e\2\2\u0130\u0131\7t\2\2\u0131\u0132"+
		"\7k\2\2\u0132\u0133\7r\2\2\u0133\u0134\7v\2\2\u0134\u0135\7@\2\2\u0135"+
		"\u0136\3\2\2\2\u0136\u0137\b\27\b\2\u0137\64\3\2\2\2\u0138\u013a\13\2"+
		"\2\2\u0139\u0138\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u013c\3\2\2\2\u013b"+
		"\u0139\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u013f\7>"+
		"\2\2\u013f\u0140\7\61\2\2\u0140\u0141\7u\2\2\u0141\u0142\7v\2\2\u0142"+
		"\u0143\7{\2\2\u0143\u0144\7n\2\2\u0144\u0145\7g\2\2\u0145\u0146\7@\2\2"+
		"\u0146\u0147\3\2\2\2\u0147\u0148\b\30\b\2\u0148\66\3\2\2\2\u0149\u014b"+
		"\13\2\2\2\u014a\u0149\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014d\3\2\2\2"+
		"\u014c\u014a\3\2\2\2\u014d\u014f\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0150"+
		"\7>\2\2\u0150\u0151\7\61\2\2\u0151\u0152\7u\2\2\u0152\u0153\7x\2\2\u0153"+
		"\u0154\7i\2\2\u0154\u0155\7@\2\2\u0155\u0156\3\2\2\2\u0156\u0157\b\31"+
		"\b\2\u01578\3\2\2\2#\2\3\4\5\6\7\bAJRctx\u0082\u009e\u00a2\u00b7\u00bb"+
		"\u00cc\u00d0\u00e0\u00e6\u00e8\u00fe\u0103\u0108\u010a\u010c\u0120\u0122"+
		"\u0129\u013b\u014c\n\b\2\2\7\6\2\7\7\2\7\b\2\7\3\2\7\4\2\6\2\2\7\5\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}