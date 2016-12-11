package formatter.lexem;


import formatter.actionlexer.IAct;

/**
 * DefaultToken.
 */
class DefaultToken implements IToken {
    /**
     *
     * @param token token.
     * @param lexer lexer.
     * @return IAct.
     */
    public IAct getAct(final char token, final IToken lexer) {
        HashMapDef map = new HashMapDef();
        return map.getMap(token);
    }
}
