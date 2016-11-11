package com;
import com.exception.WriteException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Writer.
 */
public class WriterFile implements IWrite {
    /**
     * buffer.
     */
    private final BufferedWriter buffer;

    /**
     *
     * @param destinationName filename.
     * @throws IOException exception.
     */
    public WriterFile(final String destinationName) throws IOException {
        buffer = new BufferedWriter(new FileWriter(destinationName));
    }

    /**
     *
     * @param c writeChar.
     * @throws WriteException exception.
     */
    public final void writeChar(final char c) throws WriteException {
        try {
            buffer.append(c);
        } catch (IOException e) {
            throw new WriteException("error");
        }
    }

    /**
     *
     * @throws IOException exception.
     */
    public final void close() throws IOException {
        buffer.close();
    }
}
