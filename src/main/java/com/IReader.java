package com;

import java.io.IOException;

/**
 * Interface to read.
 */
public interface IReader {

    /**
     *
     * @return boolean.
     * @throws IOException exception.
     */
    boolean hasChars() throws IOException;

    /**
     *
     * @return char.
     * @throws IOException exception.
     */
    char readChar() throws IOException;

    /**
     *
     * @return String.
     */
    String toString();

    /**
     *
     * @throws IOException exception.
     */
    void close() throws IOException;
}
