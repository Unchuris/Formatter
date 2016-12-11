package formatter.lexem;


import formatter.actionlexer.IAct;
import formatter.actionlexer.WriteComment;

/**
 * Comment.
 */
class Comment implements IToken {
    /**
     *
     * @param token token.
     * @param lexer lexer.
     * @return IAct.
     */
    public IAct getAct(final char token, final IToken lexer) {
        return new WriteComment();
    }
}
