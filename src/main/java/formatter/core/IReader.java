package formatter.core;

import java.io.IOException;

/**
 *
 * @param <T> String/Character.
 */
public interface IReader<T> {
    /**
     *
     * @return boolean.
     * @throws ReaderException exception.
     */
    boolean hasChars() throws ReaderException;

    /**
     * readLexeme.
     * @return char.
     * @throws ReaderException exception.
     */
    T readLexeme() throws ReaderException;
    /**
     * close.
     * @throws ReaderException exception.
     * @throws IOException exception.
     */
    void close() throws IOException, ReaderException;

}
