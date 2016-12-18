package formatter.lexem;

import formatter.actionlexer.IAct;
import formatter.core.IReader;
import formatter.core.ReaderException;

import java.io.IOException;
import java.util.HashMap;

/**
 * Lexer.
 */
public class Lexer implements IReader<IToken> {
    /**
     * IReader Character.
     */
    private IReader<Character> source;

    /**
     * boolean.
     */
    private boolean check = true;
    /**
     * start state.
     */
    private boolean start = true;
    /**
     * symbol.
     */
    private char symbol;

    /**
     * defaultState.
     */
    private IToken defaultState;

    /**
     * HashMap.
     */
    private HashMap<StateKeyToken, IToken> hashMap;
    /**
     * Store.
     */
    private StoreSymbol store = new StoreSymbol();

    /**
     * Token.
     */
    private IToken token;
    /**
     * @param in source.
     *
     */
    public Lexer(final IReader<Character> in) {
        this.source = in;
        store.string((char) 0);

        hashMap = new HashMap<StateKeyToken, IToken>();

        defaultState = new DefaultToken();

        IToken word = new WordState();
        IToken maybeComment = new Comment();
        IToken del = new Line();

        hashMap.put(new StateKeyToken(defaultState), word);
        hashMap.put(new StateKeyToken(word), defaultState);
        hashMap.put(new StateKeyToken(word, "/"), maybeComment);
        hashMap.put(new StateKeyToken(word, "*"), maybeComment);
        hashMap.put(new StateKeyToken(word, "\n"), del);
        hashMap.put(new StateKeyToken(maybeComment), word);
        hashMap.put(new StateKeyToken(del), word);
    }

    /**
     *
     * @return boolean.
     * @throws ReaderException ex.
     */
    public final boolean hasChars() throws ReaderException {
        if (!source.hasChars() && check) {
            check = false;
            return true;
        }
        return source.hasChars();
    }

    /**
     *
     * @return String.
     * @throws ReaderException Exception.
     */
    public final IToken readChar() throws ReaderException {
        if (start) {
            token = defaultState;
            start = false;
        }
        symbol = read();
        IAct actionToken = token.getAct(symbol, token);
        return new Token(actionToken);
    }
    /**
     *
     * @return char.
     * @throws ReaderException Exception.
     */
    private char read() throws ReaderException {
        char c = store.getString();
        if (c != 0) {
            return c;
        } else {
            c = source.readChar();
            while (c == ' ') {
                c = source.readChar();
            }
        }
        return c;
    }
    /**
     *
     * @return lexeme.
     * @throws ReaderException Exception.
     */
    public final String getLexeme() throws ReaderException {
        IToken t;
        t = readChar();
        IAct action = t.getAct(symbol, t);
        String lexeme = action.getLexeme(symbol, source, store);
        token = getNextStateToken(lexeme, token, symbol);
        return lexeme;
    }
    /**
     *
     * @param sym String.
     * @param s IToken.
     * @param t char,
     * @return lexer.
     */
    private IToken getNextStateToken(final String sym,
                                     final IToken s, final char t) {
        String symb = sym;
        if (symb.equals("")) {
            symb = String.valueOf(t);
        }
        if (hashMap.containsKey(new StateKeyToken(s, symb))) {
            return hashMap.get(new StateKeyToken(s, symb));
        }
        if (hashMap.containsKey(new StateKeyToken(s))) {
            return hashMap.get(new StateKeyToken(s));
        }
        return s;
    }

    /**
     *
     * @throws IOException Exception.
     * @throws ReaderException Exception.
     */
    public final void close() throws IOException, ReaderException {
        source.close();
    }

}
