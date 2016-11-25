package formatter.Command;

import formatter.Core.IReader;
import formatter.Core.IWrite;
import formatter.Core.ReaderException;
import formatter.Core.WriterException;

/**
 * Ignore literal.
 */
class IgnoreLiteral implements ICommand {
    /**
     * symbol.
     */
    private char symbol;

    /**
     * Ignore.
     * @param criteria symbol.
     */
    IgnoreLiteral(final char criteria) {
        this.symbol = criteria;
    }

    /**
     * execute.
     * @param source file.
     * @param destination file.
     * @param indent indent.
     * @param check check.
     */
    public void execute(final IReader source,
                        final IWrite destination,
                        final int indent, final boolean check) {
        char c = symbol;
        char previous = 0;
        try {
            destination.writeChar(symbol);
            if (source.hasChars()) {
                symbol = source.readChar();
                while ((c != symbol || previous == '\\') && source.hasChars()) {
                    destination.writeChar(symbol);
                    previous = symbol;
                    symbol = source.readChar();
                }
                destination.writeChar(symbol);
            }
        } catch (ReaderException e) {
            throw new RuntimeException("Error. ReaderIgnoreComment");
        } catch (WriterException e) {
            throw new RuntimeException("Error. WriterIgnoreComment");
        }
    }
}
