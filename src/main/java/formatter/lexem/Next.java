//package formatter.lexem;
//
///**
// * Created by vlad on 11.12.16.
// */
//public class Next implements IToken {
//
//    private StoreSymbol symbol;
//
//    public Next(final StoreSymbol c) {
//        this.symbol = c;
//    }
//
//    public String getLexeme(final IToken lexer) {
//        String c = symbol.getStr();
//        if (c == null) {
//            return " ";
//        } else {
//            if (c.equals("{") || c.equals("}") || c.equals(";") || c.equals("\n")) {
//                return c;
//            }
//        }
//        return " ";
//    }
//}
