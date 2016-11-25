package formatter.StringIO;

import formatter.Core.IWrite;
import formatter.Core.WriterException;

/**
 * String writer.
 */
public class StringWriter implements IWrite {
    /**
     * c.
     */
    private StringBuilder c;

    /**
     *
     * @return string.
     */
    public final String toString() {
        return c.toString();
    }

    /**
     * c.
     */
    public StringWriter() {
        c = new StringBuilder();
    }

    /**
     *
     * @param string string.
     */
    public final void writeChar(final String string) {
        c.append(string);
    }

    /**
     * s.
     * @param s char.
     * @throws WriterException exception.
     */
    public final void writeChar(final char s) throws WriterException {
        c.append(s);
    }

    /**
     *
     * @throws WriterException exception.
     */
    public void close() throws WriterException {

    }
}
