//package formatter.formatterimplementation;
//
//import formatter.core.IReader;
//import formatter.core.ReaderException;
//import formatter.lexem.IToken;
//
///**
// * "/".
// */
//public class MaybeComments implements IToken {
//
//    private IReader<Character> source;
//    private String s;
//
//    public MaybeComments(final String c, final IReader<Character> in) {
//        this.source = in;
//        this.s = c;
//    }
//
//    public String getLexeme(IToken lexer) {
//        String symbol;
//        try {
//            if (source.hasChars()) {
//                symbol = "" + source.readChar(lexer);
//                if (symbol.equals("/") || symbol.equals("*")) {
//                    return s + symbol;
//                }
//            }
//        } catch (ReaderException e) {
//            throw new RuntimeException("Error. ReaderMaybeComment");
//        }
//        return null;
//    }
//}
