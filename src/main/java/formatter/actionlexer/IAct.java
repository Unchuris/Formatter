package formatter.actionlexer;

import formatter.core.IReader;
import formatter.core.ReaderException;
import formatter.lexem.StoreSymbol;

/**
 * Interface for action lexer.
 */
public interface IAct {
    /**
     *
     * @param string char.
     * @param in in.
     * @param store StoreSymbol.
     * @return String.
     * @throws ReaderException Exception.
     */
    String getLexeme(char string, IReader<Character> in,
                     StoreSymbol store) throws ReaderException;
}

