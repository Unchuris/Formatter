package com;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reader.
 */
public class ReadFile implements IReader {
    /**
     * buffer.
     */
    private final BufferedReader buffer;

    /**
     *
     * @param sourceName filename.
     * @throws FileNotFoundException exception.
     */
    public ReadFile(final String sourceName) throws FileNotFoundException {
        buffer = new BufferedReader(new FileReader(sourceName));
    }

    /**
     *
     * @return char.
     * @throws IOException exception.
     */
    public final char readChar() throws IOException {
        int c = this.buffer.read();
        return (char) c;
    }

    /**
     *
     * @throws IOException exception.
     */
    public final void close() throws IOException {
        this.buffer.close();
    }

    /**
     *
     * @return boolean.
     * @throws IOException exception.
     */
    public final boolean hasChars() throws IOException {
        return buffer.ready();
    }
}
