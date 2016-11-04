package com;

import java.io.IOException;

/**
 * Interface to write.
 */
public interface IWrite {
    /**
     * write char.
     * @param c writeChar.
     * @throws IOException exception.
     */
    void writeChar(char c) throws IOException;

    /**
     * close.
     * @throws IOException exception.
     */
    void close() throws IOException;
}
