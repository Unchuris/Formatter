package com.Core;

import java.io.IOException;

/**
 * Interface to read.
 */
public interface IReader {
    /**
     *
     * @return boolean.
     * @throws ReaderException exception.
     */
    boolean hasChars() throws ReaderException;

    /**
     *
     * @return char.
     * @throws ReaderException exception.
     */
    char readChar() throws ReaderException;
    /**
     * close.
     * @throws ReaderException exception.
     * @throws IOException exception.
     */
    void close() throws IOException, ReaderException;
}
