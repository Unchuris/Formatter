package formatter.core;

import java.io.IOException;

/**
 * Interface to read.
 * @param <T> t.
 */
public interface IReader<T> {
    /**
     *
     * @return boolean.
     * @throws ReaderException exception.
     */
    boolean hasChars() throws ReaderException;

    /**
     * readChar.
     * @return char.
     * @throws ReaderException exception.
     */
    T readChar() throws ReaderException;
    /**
     * close.
     * @throws ReaderException exception.
     * @throws IOException exception.
     */
    void close() throws IOException, ReaderException;

}
