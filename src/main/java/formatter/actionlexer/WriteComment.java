package formatter.actionlexer;

import formatter.core.IReader;
import formatter.core.ReaderException;
import formatter.lexem.StoreSymbol;

/**
 * Comment.
 */
public class WriteComment implements IAct {

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
                                  final StoreSymbol store)
            throws ReaderException {
        store.string((char) 0);

            char symbol = in.readChar();
            String str =  String.valueOf(string) + String.valueOf(symbol);
            MapWriteComment map = new MapWriteComment();
            if (map.getMap(str) != null) {
                return map.getMap(str);
            } else {
                store.string(symbol);
                return String.valueOf(string);
            }

    }
}
