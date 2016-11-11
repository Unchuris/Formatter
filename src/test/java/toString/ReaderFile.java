package toString;

import com.exception.ReadException;
import com.ReadFile;
import toString.Reader;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * toString.
 */
public class ReaderFile extends ReadFile implements Reader {
    /**
     * @param sourceName filename.
     * @throws FileNotFoundException exception.
     */
    public ReaderFile(String sourceName) throws FileNotFoundException {
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
        } catch (ReadException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
