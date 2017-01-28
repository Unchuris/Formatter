package formatter.lexeme;

/**
 * LexerBuilder.
 */
public class LexerBuilder {
    /**
     * StringBuilder.
     */
    private StringBuilder builder;
    /**
     * String.
     */
    private String string;

    /**
     *
     * @param lexeme lexeme.
     */
    LexerBuilder(final StringBuilder lexeme) {
        this.builder = lexeme;
    }

    /**
     *
     * @param c char.
     */
    public final void append(final Character c) {
        builder.append(c);
    }

    /**
     *
     * @return string.
     */
    public final String toString() {
        return builder.toString();
    }

    /**
     * returnToken.
     */
    public final void returnToken() {
        string = builder.toString();
        builder = new StringBuilder("");
    }

    /**
     *
     * @return string.
     */
    public final String getString() {
        return string;
    }
}
