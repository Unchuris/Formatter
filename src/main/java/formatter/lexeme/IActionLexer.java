package formatter.lexeme;

/**
 * IActionLexer.
 */
public interface IActionLexer {
    /**
     * @param string string.
     * @param c char.*/
    void execute(LexerBuilder string, char c);

    /**
     *
     * @return boolean.
     */
    boolean returnToken();
}
