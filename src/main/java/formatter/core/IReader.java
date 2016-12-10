package formatter.core;

import formatter.lexem.IToken;

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
     * @param lexer lexer.
     */
    //char readChar() throws ReaderException;
    T readChar(IToken lexer) throws ReaderException;
    /**
     * close.
     * @throws ReaderException exception.
     * @throws IOException exception.
     */
    void close() throws IOException, ReaderException;
}
