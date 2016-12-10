package formatter.fileio;
import formatter.core.IWrite;
import formatter.core.WriterException;
import formatter.core.WriterFileNotFoundException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Writer.
 */
public class WriterFile implements IWrite<String> {
    /**
     * buffer.
     */
    private final BufferedWriter buffer;

    /**
     *
     * @param destinationName filename.
     * @throws WriterFileNotFoundException exception.
     */
    public WriterFile(final String destinationName)
            throws WriterFileNotFoundException {
        try {
            buffer = new BufferedWriter(new FileWriter(destinationName));
        } catch (IOException e) {
            throw new WriterFileNotFoundException("Can't open file");
        }
    }

    /**
     *
     * @param c writeChar.
     * @throws WriterException exception.
     */
    public final void writeChar(final char c) throws WriterException {
        try {
            buffer.append(c);
        } catch (IOException e) {
            throw new WriterException("error");
        }
    }

    /**
     *
     * @param c symbol.
     * @throws WriterException exception.
     */
    public final void writeChar(final String c) throws WriterException {
        try {
            buffer.write(c);
            buffer.flush();
        } catch (IOException e) {
            throw new WriterException("error");
        }
    }


    /**
     *
     * @throws WriterException exception.
     */
    public final void close() throws WriterException {
        try {
            buffer.close();
        } catch (IOException e) {
            throw new WriterException("Can't close the file.");
        }
    }
}
