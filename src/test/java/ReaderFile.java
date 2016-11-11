import com.ReadFile;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * .
 */
public class ReaderFile extends ReadFile implements Reader  {
    /**
     * @param sourceName filename.
     * @throws FileNotFoundException exception.
     */
    ReaderFile(String sourceName) throws FileNotFoundException {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
