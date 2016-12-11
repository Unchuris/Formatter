package formatter.lexem;

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
     * defaultState.
     */
    private IToken defaultState;

    /**
     * HashMap.
     */
    private HashMap<StateKeyToken, IToken> hashMap;

    /**
     * Lexer.
     */
    private IToken lexer;

    /**
     *
     * @param in source.
     */
    public Lexer(final IReader<Character> in) {
        this.source = in;

        hashMap = new HashMap<StateKeyToken, IToken>();

        defaultState = new DefaultToken();

        IToken word = new WordState();
        IToken maybeComment = new Comment();

        hashMap.put(new StateKeyToken(defaultState), word);
        hashMap.put(new StateKeyToken(word), defaultState);
        hashMap.put(new StateKeyToken(word, "/"), maybeComment);
        hashMap.put(new StateKeyToken(word, "*"), maybeComment);
        hashMap.put(new StateKeyToken(maybeComment), word);
    }

    /**
     *
     * @return state.
     */
    public final IToken start() {
        return defaultState;
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
     * @param l lexer.
     * @param store store.
     * @return IToken
     * @throws ReaderException ex.
     */
    public final char readChar(final IToken l,
                               final StoreSymbol store) throws ReaderException {
        char str = store.getString();
        if (str != 0) {
            return str;
        }
        char c = source.readChar(lexer, store);
        while (c == ' ') {
            c = source.readChar(lexer, store);
        }
        return c;
    }

    /**
     *
     * @param sym String.
     * @param s IToken.
     * @param token char,
     * @return lexer.
     */
    public final IToken getNextStateToken(final String sym,
                                          final IToken s, final char token) {
        String symb = sym;
        if (symb.equals("")) {
            symb = String.valueOf(token);
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
