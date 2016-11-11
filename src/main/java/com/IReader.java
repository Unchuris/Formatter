package com;

import com.exception.ReadException;
import java.io.IOException;

/**
 * Interface to read.
 */
public interface IReader {
    /**
     *
     * @return boolean.
     * @throws ReadException exception.
     */
    boolean hasChars() throws ReadException;

    /**
     *
     * @return char.
     * @throws ReadException exception.
     */
    char readChar() throws ReadException;
    /**
     *
     * @throws IOException exception.
     */
    void close() throws IOException;
}
