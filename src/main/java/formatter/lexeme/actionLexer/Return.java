package formatter.lexeme.actionLexer;

import formatter.lexeme.IActionLexer;
import formatter.lexeme.LexerBuilder;

/**
 * Return.
 */
public class Return implements IActionLexer {
    /**
     * @param builder LexerBuilder.
     * @param c char.*/
    public final void execute(final LexerBuilder builder, final char c) {
        builder.returnToken();
        builder.append(c);
    }

    /**
     * boolean.
     * @return true.
     */
    public final boolean returnToken() {
        return true;
    }
}
