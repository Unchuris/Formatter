package formatter.lexem;


import formatter.actionlexer.IAct;

/**
 * Token.
 */
class Token implements IToken {
    /**
     * IAct.
     */
    private IAct action;

    /**
     *
     * @param actionToken action.
     */
    Token(final IAct actionToken) {
        this.action = actionToken;
    }

    /**
     *
     * @param token token.
     * @param lexer lexer.
     * @return IAct.
     */
    public IAct getAct(final char token, final IToken lexer) {
        return action;
    }
}
