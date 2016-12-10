package formatter.lexem;

import formatter.core.IReader;
import formatter.core.ReaderException;

import java.io.IOException;
//import java.util.HashMap;


/**
 * Lexer.
 */
public class Lexer implements IReader<IToken> {
    /**
     * IReader<Character>.
     */
    private IReader<Character> source;
//    private boolean check = true;
//    private boolean flag = true;
    /**
     * StringBuilder.
     */
    private StringBuilder lexeme =
            new StringBuilder();

//    private HashMap<StateKeyToken, IToken> hashMap;
//    private IToken defaultState;
    /**
     * Lexer.
     */
    private IToken lexer;
//    private IToken next;
//    private StoreSymbol c;

    /**
     *
     * @param in source.
     */
    public Lexer(final IReader<Character> in) {
        this.source = in;
//        c = new StoreSymbol();
//
//        hashMap = new HashMap<StateKeyToken, IToken>();
//
//        defaultState = new Word(source, c);
//
//        next = new Next(c);
//
//        hashMap.put(new StateKeyToken(defaultState), next);
//        hashMap.put(new StateKeyToken(next, "/"), nextS);
//        hashMap.put(new StateKeyToken(next, "*"), nextD);
//        hashMap.put(new StateKeyToken(defaultState), next);
//        hashMap.put(new StateKeyToken(next), defaultState);
//        hashMap.put(new StateKeyToken(defaultState, "{"), open);
//        hashMap.put(new StateKeyToken(defaultState, "}"), close);
//        hashMap.put(new StateKeyToken(defaultState, ";"), semicolon);
//        hashMap.put(new StateKeyToken(defaultState, "/"), maybeComment);
//        hashMap.put(new StateKeyToken(maybeComment, "/"), defaultState);
//        hashMap.put(new StateKeyToken(defaultState, "*"), maybeWord);
//        hashMap.put(new StateKeyToken(maybeWord, "/"), defaultState);
//        //hashMap.put(new StateKeyToken(defaultState), word);
//        hashMap.put(new StateKeyToken(open), defaultState);
//        hashMap.put(new StateKeyToken(close), defaultState);
//        hashMap.put(new StateKeyToken(semicolon), defaultState);
//        hashMap.put(new StateKeyToken(maybeComment), defaultState);
//        hashMap.put(new StateKeyToken(maybeWord), defaultState);
    }



//    public final IToken start() {
//        return defaultState;
//    }
        //map = new HashMaps();

       // this.source = in;
//        hashMap = new HashMap<StateKeyToken, IToken>();
//        defaultState = new DefaultToken();
//        IToken open = new Open();
//        IToken close = new Close();
//        IToken semicolon = new Semicolons();
//        IToken maybeComment = new MaybeComment(source);
//        IToken maybeWord = new MaybeWord(source);
//        IToken word = new Word(source);
//        hashMap.put(new StateKeyToken(defaultState, "{"), open);
//        hashMap.put(new StateKeyToken(defaultState, "}"), close);
//        hashMap.put(new StateKeyToken(defaultState, ";"), semicolon);
//        hashMap.put(new StateKeyToken(defaultState, "/"), maybeComment);
//        hashMap.put(new StateKeyToken(defaultState, "*"), maybeWord);
//        hashMap.put(new StateKeyToken(defaultState), word);
//        hashMap.put(new StateKeyToken(close), word);
//        hashMap.put(new StateKeyToken(semicolon), word);
//        hashMap.put(new StateKeyToken(maybeComment), word);
//        hashMap.put(new StateKeyToken(maybeWord), word);
        //hashMap.put(new StateKeyToken(open), defaultState);
        //Lexer currentState = new Lexer(null);
        //IToken state = currentState.start();
        //state = defaultState;
        //hashMap.put("}", new Token(lexeme.toString()));
        //hashMap.put(";", new Token(lexeme.toString()));

    /**
     *
     * @return boolean.
     * @throws ReaderException ex.
     */
    public final boolean hasChars() throws ReaderException {
        return source.hasChars();
    }

    /**
     *
     * @param l lexer.
     * @return IToken
     * @throws ReaderException ex.
     */
    public final IToken readChar(final IToken l) throws ReaderException {
        this.lexer = l;
        String cc = "" + source.readChar(lexer);
        return new Token(lexeme, cc);
    }

    /**
     *
     * @param symb String.
     * @param s IToken.
     * @return lexer
     */
    public final IToken getNextStateToken(final String symb,
                                          final IToken s) {
//
//        if (hashMap.containsKey(new StateKeyToken(lexer, symb))) {
//            return hashMap.get(new StateKeyToken(lexer, symb));
//        }
//        if (hashMap.containsKey(new StateKeyToken(lexer))) {
//            return hashMap.get(new StateKeyToken(lexer));
//        }
        return lexer;
    }

    /**
     *
     * @throws IOException ex.
     * @throws ReaderException ex.
     */
    public final void close() throws IOException, ReaderException {
        source.close();
    }
}
//        if (lexer == null) {
//            lexer = next;
//            flag = true;
//        }
//        while (source.hasChars()) {
//            String symbol = "" + source.readChar(lexer);
//            if (!symbol.equals(" ")) {
//                if (flag) {
//                    c.string(symbol);
//                    flag = false;
//                } else {
//                    flag = true;
//                }
//                return getMap(lexer, symbol);
//            }
//        }
////        //IToken a;
////        //currentState = new Lexer(null);
////        //state = defaultState;
////        OneSymbol one = new OneSymbol();
////        String c = one.getSymbol();
////        if (c != null) {
////            one.symbol(null);
////            hashMaps = new HashMaps<String, IToken>();
////            hashMaps.put("{", new Symbol(c));
////            hashMaps.put("}", new Symbol(c));
////            hashMaps.put(";", new Symbol(c));
////            hashMaps.put("/", new MaybeComments(c, source));
////            //hashMaps.put("*", new MaybeWord(c));
////            if (!c.equals(" ")) {
////                if (hashMaps.containsKey(c)) {
////                    return hashMaps.get(c);
////                } else {
////                    return null;
////                }
////            }
////        }
////        while (source.hasChars()) {
////
////            // if d.getSymbol != null {
////            //      return new Symbol(d.getSymbol);
////            //}
////            // else
////            String symbol = "" + source.readChar();
////            //String currentSymbol = null;
////            hashMaps = new HashMaps<String, IToken>();
////            hashMaps.put("{", new Symbol(symbol));
////            hashMaps.put("}", new Symbol(symbol));
////            hashMaps.put(";", new Symbol(symbol));
////            hashMaps.put("/", new MaybeComments(c, source));
////            //hashMaps.put("*", new MaybeWord(symbol));
////            if (!symbol.equals(" ")) {
////                if (hashMaps.containsKey(symbol)) {
////                    return hashMaps.get(symbol);
////                }
////                return new Word(symbol, source);
////            }
////            lexeme.delete(0, lexeme.length());
////            while (c != '}' &&
// c != '{' && c != ';' && c != ' ' && c != '\n') {
////                value = "" + c;
////                lexeme.append(value);
////                c = source.readChar();
////            }
////            value = "" + c;
////            if (lexeme.length() != 0) {
////                // = new (c);
////                //return new Token(lexeme);
////                execute();
////            } else {
////               if (hashMap.containsKey(new StateKeyToken(state, value))) {
////                    state = currentState.getNextStateToken(value, state);
////                    return hashMap.get(new StateKeyToken(state, value));
////                }
////            }
////        }
////       return new Token(lexeme);
//        return new Token(lexeme, c);
    //}

//    private IToken getMap(final IToken s, final String symb) {
//        if (hashMap.containsKey(new StateKeyToken(s))) {
//            return hashMap.get(new StateKeyToken(s));
//        }
//        return defaultState;
//    }

