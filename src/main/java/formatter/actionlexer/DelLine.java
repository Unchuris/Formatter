package formatter.actionlexer;

import formatter.core.IReader;
import formatter.core.ReaderException;
import formatter.lexem.StoreSymbol;

/**
 * Line.
 */
public class DelLine implements IAct {
    /**
     *
     * @param string char.
     * @param in in.
     * @param store StoreSymbol.
     * @return String.
     * @throws ReaderException Exception.
     */
    public final String getLexeme(final char string,
                            final IReader<Character> in,
                            final StoreSymbol store) throws ReaderException {
        char symbol;
        do {
            symbol = in.readChar();
        } while (symbol == '\n' && in.hasChars());
        store.string(symbol);
        return String.valueOf(string);
    }
}
