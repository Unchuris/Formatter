package formatter.lexem;

import formatter.actionlexer.IAct;

/**
 * IToken.
 */
public interface IToken {
    /**
     *
     *
     * @param token token.
     * @param lexer lexer.
     * @return String.
     */
    IAct getAct(char token, IToken lexer);
}
