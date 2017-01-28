package formatter.stringio;

import formatter.core.IReader;
import formatter.core.ReaderException;

import java.io.IOException;

/**
 * String reader.
 */
public class StringReader implements IReader<Character> {
    /**
     * pos.
     */
    private char pos = 0;
    /**
     * string.
     */
    private String source;

    /**
     *  start.
     * @param s symbol.
     */
    public StringReader(final String s) {
        this.source = s;
    }

    /**
     *
     * @return boolean.
     * @throws ReaderException exception.
     */
    public final boolean hasChars() throws ReaderException {
        return source.length() > pos;
    }

    /**
     *  c.
     * @return char,
     * @throws ReaderException exception.
     */
    public final Character readLexeme() throws ReaderException {
        char c;
        c = source.charAt(pos);
        pos++;
        return c;
    }

    /**
     *  .
     * @throws IOException exception.
     */
    public void close() throws IOException {

    }

}
