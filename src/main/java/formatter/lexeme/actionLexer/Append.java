package formatter.lexeme.actionLexer;


import formatter.lexeme.IActionLexer;
import formatter.lexeme.LexerBuilder;

/**
 * Append.
 */
public class Append implements IActionLexer {
    /**
     *  @param builder LexerBuilder.
     * @param c char.*/
    public final void execute(final LexerBuilder builder, final char c) {
        builder.append(c);
    }

    /**
     *
     * @return false.
     */
    public final boolean returnToken() {
        return false;
    }
}
