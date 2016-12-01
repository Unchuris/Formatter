package StateMachine;

import formatter.Core.ReaderException;
import formatter.Core.ReaderFileNotFoundException;
import formatter.FileIO.ReaderFile;

import java.io.FileNotFoundException;

/**
 * StateMachine.
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
                next = this.readChar();
                builder.append(next);
            }
        } catch (ReaderException e) {
            throw new RuntimeException("Error. ReaderIgnoreComment");
        }
        return builder.toString();
    }
}
