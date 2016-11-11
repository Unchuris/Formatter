package com;
import com.exception.ReadException;

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
     * @throws ReadException exception.
     */
    public final boolean hasChars() throws ReadException {
        try {
            return buffer.ready();
        } catch (IOException e) {
            throw new ReadException("Buffer isn't ready");
        }
    }
}
