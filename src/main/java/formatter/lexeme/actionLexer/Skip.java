package formatter.lexeme.actionLexer;

import formatter.lexeme.IActionLexer;
import formatter.lexeme.LexerBuilder;

/**
 * Skip.
 */
public class Skip implements IActionLexer {
    /**
     *  @param string string.
     * @param c char.*/
    public void execute(final LexerBuilder string, final char c) {

    }

    /**
     *
     * @return false.
     */
    public final boolean returnToken() {
        return false;
    }
}
