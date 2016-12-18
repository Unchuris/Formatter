package formatter.lexem;

import formatter.actionlexer.DelLine;
import formatter.actionlexer.IAct;

/**
 * New line.
 */
class Line implements IToken {
    /**
     *
     * @param token token.
     * @param lexer lexer.
     * @return IAct.
     */
    public IAct getAct(final char token, final IToken lexer) {
        return new DelLine();
    }
}
