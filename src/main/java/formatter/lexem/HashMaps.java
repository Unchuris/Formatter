//package formatter.lexem;
//
//import formatter.core.IReader;
//
//import java.util.HashMap;
//
///**
// * Created by vlad on 10.12.16.
// */
//public class HashMaps {
//    //private Lexer currentState;
//    //private IToken state;
//    private IToken defaultState;
//    private HashMap<StateKeyToken, IToken> hashMap;
//
//    public final IToken start() {
//        return defaultState;
//    }
//    //final IReader<Character> in
//    public HashMaps() {
//        hashMap = new HashMap<StateKeyToken, IToken>();
//        defaultState = new DefaultToken();
//
//        IToken open = new Open();
//        IToken close = new Close();
//        IToken semicolon = new Semicolons();
//        IToken maybeComment = new MaybeComment();
//        IToken maybeWord = new MaybeWord();
//        IToken word = new Word();
//
//        hashMap.put(new StateKeyToken(defaultState, "{"), open);
//        hashMap.put(new StateKeyToken(defaultState, "}"), close);
//        hashMap.put(new StateKeyToken(defaultState, ";"), semicolon);
//        hashMap.put(new StateKeyToken(defaultState, "/"), maybeComment);
//        hashMap.put(new StateKeyToken(maybeComment, "/"), defaultState);
//        hashMap.put(new StateKeyToken(defaultState, "*"), maybeWord);
//        hashMap.put(new StateKeyToken(maybeWord, "/"), defaultState);
//        hashMap.put(new StateKeyToken(defaultState), word);
//        hashMap.put(new StateKeyToken(close), word);
//        hashMap.put(new StateKeyToken(semicolon), word);
//        hashMap.put(new StateKeyToken(maybeComment), word);
//        hashMap.put(new StateKeyToken(maybeWord), word);
//    }
//
//    IToken getMap(final IToken state, final String symbol) {
//        if (hashMap.containsKey(new StateKeyToken(state, symbol))) {
//            return hashMap.get(new StateKeyToken(state, symbol));
//        } else {
//            if (hashMap.containsKey(new StateKeyToken(state))) {
//                return hashMap.get(new StateKeyToken(state));
//            }
//        }
//        return null;
//    }
//
//    public final IToken getNextStateToken(final String symbol,
//                                           final IToken s) {
//        if (hashMap.containsKey(new StateKeyToken(s, symbol))) {
//            return hashMap.get(new StateKeyToken(s, symbol));
//        }
//        if (hashMap.containsKey(new StateKeyToken(s))) {
//            return hashMap.get(new StateKeyToken(s));
//        }
//        return s;
//    }
//
//}
//
