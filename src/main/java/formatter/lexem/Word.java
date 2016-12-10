//package formatter.lexem;
//
//import formatter.core.IReader;
//import formatter.core.ReaderException;
//
///**
// * Created by vlad on 10.12.16.
// */
//class Word implements IToken {
//    private StringBuilder lexeme =
//            new StringBuilder();
//    private IReader<Character> source;
//    private StoreSymbol symbol;
//
//    Word(final IReader<Character> s, final StoreSymbol str) {
//        this.symbol = str;
//        this.source = s;
//    }
//
//
////    Word() {
////        this.source = c;
////
////    }
//
//    public String getLexeme(final IToken lexer) {
//        String c = symbol.getString();
//        String copy = null;
//        String first = c;
//        lexeme.delete(0, lexeme.length());
//        try {
//            if (first.equals("/")) {
//                lexeme.append(c);
//                c = "" + source.readChar(lexer);
//                if (c.equals("/") && c.equals("*")) {
//                    c = "/" + c;
//                    return c;
//                } else {
//                    while (!c.equals("}")
// && !c.equals("{") && !c.equals(";") && !c.equals(" ")
//                            && !c.equals("\n")) {
//                        lexeme.append(c);
//                        if (source.hasChars()) {
//                            c = "" + source.readChar(lexer);
//                            copy = c;
//                        } else {
//                            break;
//                        }
//                    }
//                }
//            } else {
//                while (!c.equals("}")
// && !c.equals("{") && !c.equals(";") && !c.equals(" ")
//                        && !c.equals("\n")) {
//                    lexeme.append(c);
//                    if (source.hasChars()) {
//                        c = "" + source.readChar(lexer);
//                        copy = c;
//                    } else {
//                        break;
//                    }
//                }
//            }
//            symbol.str(copy);
//            if (lexeme.length() == 0) {
//                return c;
//            }
//            return lexeme.toString();
//        } catch (ReaderException e) {
//            throw new RuntimeException("Error. Word");
//        }
//    }
//}
