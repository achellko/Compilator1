// Generated from Demo.g4 by ANTLR 4.9.2
package output;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DemoLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, REPEAT=3, ENDREPEAT=4, IF=5, THEN=6, ENDIF=7, ADD=8, MINUS=9, 
		WRITE=10, READ=11, FUNCTION=12, ENDFUNCTION=13, ID=14, INT=15, NEWLINE=16, 
		WS=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "REPEAT", "ENDREPEAT", "IF", "THEN", "ENDIF", "ADD", 
			"MINUS", "WRITE", "READ", "FUNCTION", "ENDFUNCTION", "ID", "INT", "NEWLINE", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'=='", "'repeat'", "'endrepeat'", "'if'", "'then'", "'endif'", 
			"'+'", "'-'", "'write'", "'read'", "'function'", "'endfunction'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "REPEAT", "ENDREPEAT", "IF", "THEN", "ENDIF", "ADD", 
			"MINUS", "WRITE", "READ", "FUNCTION", "ENDFUNCTION", "ID", "INT", "NEWLINE", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public DemoLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Demo.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 16:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 skip(); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23\u0083\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\6\17o\n\17\r\17\16\17p\3\20\6\20"+
		"t\n\20\r\20\16\20u\3\21\5\21y\n\21\3\21\3\21\3\22\6\22~\n\22\r\22\16\22"+
		"\177\3\22\3\22\2\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23\3\2\4\4\2C\\c|\4\2\13\13\"\"\2\u0086"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\3%\3\2\2\2\5\'\3\2\2\2\7*\3\2\2\2\t\61\3\2\2\2\13;\3\2\2\2\r>\3\2"+
		"\2\2\17C\3\2\2\2\21I\3\2\2\2\23K\3\2\2\2\25M\3\2\2\2\27S\3\2\2\2\31X\3"+
		"\2\2\2\33a\3\2\2\2\35n\3\2\2\2\37s\3\2\2\2!x\3\2\2\2#}\3\2\2\2%&\7?\2"+
		"\2&\4\3\2\2\2\'(\7?\2\2()\7?\2\2)\6\3\2\2\2*+\7t\2\2+,\7g\2\2,-\7r\2\2"+
		"-.\7g\2\2./\7c\2\2/\60\7v\2\2\60\b\3\2\2\2\61\62\7g\2\2\62\63\7p\2\2\63"+
		"\64\7f\2\2\64\65\7t\2\2\65\66\7g\2\2\66\67\7r\2\2\678\7g\2\289\7c\2\2"+
		"9:\7v\2\2:\n\3\2\2\2;<\7k\2\2<=\7h\2\2=\f\3\2\2\2>?\7v\2\2?@\7j\2\2@A"+
		"\7g\2\2AB\7p\2\2B\16\3\2\2\2CD\7g\2\2DE\7p\2\2EF\7f\2\2FG\7k\2\2GH\7h"+
		"\2\2H\20\3\2\2\2IJ\7-\2\2J\22\3\2\2\2KL\7/\2\2L\24\3\2\2\2MN\7y\2\2NO"+
		"\7t\2\2OP\7k\2\2PQ\7v\2\2QR\7g\2\2R\26\3\2\2\2ST\7t\2\2TU\7g\2\2UV\7c"+
		"\2\2VW\7f\2\2W\30\3\2\2\2XY\7h\2\2YZ\7w\2\2Z[\7p\2\2[\\\7e\2\2\\]\7v\2"+
		"\2]^\7k\2\2^_\7q\2\2_`\7p\2\2`\32\3\2\2\2ab\7g\2\2bc\7p\2\2cd\7f\2\2d"+
		"e\7h\2\2ef\7w\2\2fg\7p\2\2gh\7e\2\2hi\7v\2\2ij\7k\2\2jk\7q\2\2kl\7p\2"+
		"\2l\34\3\2\2\2mo\t\2\2\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\36\3"+
		"\2\2\2rt\4\62;\2sr\3\2\2\2tu\3\2\2\2us\3\2\2\2uv\3\2\2\2v \3\2\2\2wy\7"+
		"\17\2\2xw\3\2\2\2xy\3\2\2\2yz\3\2\2\2z{\7\f\2\2{\"\3\2\2\2|~\t\3\2\2}"+
		"|\3\2\2\2~\177\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3\2"+
		"\2\2\u0081\u0082\b\22\2\2\u0082$\3\2\2\2\7\2pux\177\3\3\22\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}