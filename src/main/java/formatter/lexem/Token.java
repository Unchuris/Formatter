package formatter.lexem;
//
//import formatter.formatterimplementation.For;
//import formatter.formatterimplementation.Output;
//
//import java.util.HashMap;

/**
 * Token.
 */
class Token implements IToken {

    //private String s;

    //private HashMap<String, IToken> hashMap;

    //private String one;
    /**
     * String.
     */
    private String str;

    /**
     *
     * @param sb StringBuilder.
     * @param c String.
     */
    Token(final StringBuilder sb, final String c) {
//        this.s = sb.toString();
//        hashMap = new HashMap<String, IToken>();
//        hashMap.put("for", new For());
        str = c;
    }


//
//    public IToken execute() {
//        if (hashMap.containsKey(s)) {
//            return hashMap.get(s);
//        }
//        return new Output(s);
//    }

    /**
     *
     * @param lexer lexer.
     * @return string.
     */
    public String getLexeme(final IToken lexer) {
        return str;
    }
}
