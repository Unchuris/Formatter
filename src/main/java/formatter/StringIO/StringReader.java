package formatter.StringIO;

import formatter.Core.IReader;
import formatter.Core.ReaderException;

import java.io.IOException;

/**
 * String reader.
 */
public class StringReader implements IReader {
    /**
     * pos.
     */
    private char pos = 0;
    /**
     * string.
     */
    private String source;

    /**
     *  s.
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
    public final char readChar() throws ReaderException {
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
