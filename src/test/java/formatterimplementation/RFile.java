package formatterimplementation;

import formatter.core.ReaderException;
import formatter.core.ReaderFileNotFoundException;
import formatter.fileio.ReaderFile;

import java.io.FileNotFoundException;

/**
 * statemachine.
 */
class RFile extends ReaderFile implements Reader {
    /**
     * @param sourceName filename.
     * @throws FileNotFoundException exception.
     */
    RFile(String sourceName) throws FileNotFoundException, ReaderFileNotFoundException {
        super(sourceName);
    }
    public final String toString() {
        StringBuilder builder = new StringBuilder();
        char next;
        try {
            while (this.hasChars()) {
                next = this.readChar(null, null);
                builder.append(next);
            }
        } catch (ReaderException e) {
            throw new RuntimeException("Error. ReaderIgnoreComment");
        }
        return builder.toString();
    }
}
