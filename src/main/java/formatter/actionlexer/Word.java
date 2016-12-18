package formatter.actionlexer;

import formatter.core.IReader;
import formatter.core.ReaderException;
import formatter.lexem.StoreSymbol;

/**
 * Word.
 */
public class Word implements IAct {
    /**
     * check.
     */
    private boolean check = true;
    /**
     * StringBuilder.
     */
    private StringBuilder lexeme =
            new StringBuilder();

    /**
     *
     * @param read read.
     * @param in in.
     * @param store StoreSymbol.
     * @return String.
     * @throws ReaderException Exception.
     */
    public final String getLexeme(final char read,
                                  final IReader<Character> in,
                                  final StoreSymbol store)
            throws ReaderException {
        char string = read;
        lexeme.delete(0, lexeme.length());
        while (check && string != '{' && string != '}' && string != ';'
                && string != '"' && string != '\n' && string != '/'
                && string != '*'
                && string != '\'' && string != ' ') {
            lexeme.append(string);
            if (in.hasChars()) {
                string = in.readChar();
            } else {
                check = false;
            }
        }
        store.string(string);
        return lexeme.toString();
    }
}
