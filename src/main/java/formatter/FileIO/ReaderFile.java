package formatter.FileIO;
import formatter.Core.IReader;
import formatter.Core.ReaderException;
import formatter.Core.ReaderFileNotFoundException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reader.
 */
public class ReaderFile implements IReader {
    /**
     * buffer.
     */
    private final BufferedReader buffer;

    /**
     *
     * @param sourceName filename.
     * @throws ReaderFileNotFoundException exception.
     */
    public ReaderFile(final String sourceName)
            throws ReaderFileNotFoundException {
        try {
            buffer = new BufferedReader(new FileReader(sourceName));
        } catch (FileNotFoundException e) {
            throw new ReaderFileNotFoundException("Can't open file", e);
        }
    }

    /**
     *
     * @return char.
     * @throws ReaderException exception.
     */
    public final char readChar() throws ReaderException {
        int c;
        try {
            c = this.buffer.read();
        } catch (IOException e) {
            throw new ReaderException("error.");
        }
        return (char) c;
    }

    /**
     *
     * @throws ReaderException exception.
     */
    public final void close() throws ReaderException {
        try {
            this.buffer.close();
        } catch (IOException e) {
            throw new ReaderException("Can't close the file.");
        }
    }
    /**
     *
     * @return boolean.
     * @throws ReaderException exception.
     */
    public final boolean hasChars() throws ReaderException {
        try {
            return buffer.ready();
        } catch (IOException e) {
            throw new ReaderException("Buffer isn't ready.");
        }
    }
}
