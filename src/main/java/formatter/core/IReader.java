package formatter.core;

import formatter.lexem.IToken;
import formatter.lexem.StoreSymbol;

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
     * @param store store.
     */
    //char readChar() throws ReaderException;
    char readChar(IToken lexer, StoreSymbol store) throws ReaderException;
    /**
     * close.
     * @throws ReaderException exception.
     * @throws IOException exception.
     */
    void close() throws IOException, ReaderException;
}
