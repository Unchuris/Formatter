package toString;

import com.Core.ReaderException;
import com.Core.ReaderFileNotFoundException;
import com.FileIO.ReaderFile;

import java.io.FileNotFoundException;

/**
 * toString.
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
