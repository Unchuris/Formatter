//package formatter.lexem;
//
//import java.util.HashMap;
//
///**
// * Created by vlad on 09.12.16.
// */
//public class DefaultToken implements IToken {
//
////    private HashMap<String, IToken> hashMap;
////
////    DefaultToken() {
////        hashMap = new HashMap<String, IToken>();
////        hashMap.put("{", new Bracket());
////        hashMap.put("}", new Bracket());
////        hashMap.put(";", new Bracket());
////    }
////    public IToken getLexeme(final String symbol) {
////        if (hashMap.containsKey(symbol)) {
////            return hashMap.get(symbol);
////        } else {
////            return new Word();
////        }
////    }
//
//    public String getLexeme(IToken lexer) {
////        if (hashMap.containsKey(symbol)) {
////            return hashMap.get(symbol);
////        } else {
////            return new WriterSymbol();
////        }
//        return "KO";
//    }
//}
