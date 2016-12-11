package formatter.actionlexer;

import formatter.core.IReader;
import formatter.core.ReaderException;
import formatter.lexem.IToken;
import formatter.lexem.StoreSymbol;

/**
 * Store.
 */
public class Store implements IAct {
    /**
     *
     * @param string char.
     * @param lexer lexer.
     * @param in in.
     * @param store StoreSymbol.
     * @return String.
     * @throws ReaderException Exception.
     */
    public final String getLexeme(final char string,
                                  final IToken lexer,
                            final IReader<Character> in,
                            final StoreSymbol store) throws ReaderException {
        store.string(string);
        return "";
    }
}
