package com;
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
     * @throws IOException exception.
     */
    public final void writeChar(final char c) throws IOException {
        buffer.append(c);
    }

    /**
     *
     * @throws IOException exception.
     */
    public final void close() throws IOException {
        buffer.close();
    }
}
