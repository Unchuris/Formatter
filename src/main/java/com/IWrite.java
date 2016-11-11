package com;

import com.exception.WriteException;

import java.io.IOException;

/**
 * Interface to write.
 */
public interface IWrite {
    /**
     * write char.
     * @param c writeChar.
     * @throws WriteException exception.
     */
    void writeChar(char c) throws WriteException;

    /**
     * close.
     * @throws IOException exception.
     */
    void close() throws IOException;
}
