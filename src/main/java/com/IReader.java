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
     * @throws IOException exception.
     * @throws ReadException exception.
     */
    boolean hasChars() throws IOException, ReadException;

    /**
     *
     * @return char.
     * @throws IOException exception.
     */
    char readChar() throws IOException;
    /**
     *
     * @throws IOException exception.
     */
    void close() throws IOException;
}
