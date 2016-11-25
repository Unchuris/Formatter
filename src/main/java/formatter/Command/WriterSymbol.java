package formatter.Command;

import formatter.Core.IReader;
import formatter.Core.IWrite;
import formatter.Core.WriterException;

/**
 * Whiter symbol.
 */
class WriterSymbol implements ICommand {
    /**
     * symbol.
     */
    private final char symbol;

    /**
     *  write.
     * @param criteria symbol.
     */
    WriterSymbol(final char criteria) {
        this.symbol = criteria;
    }

    /**
     *
     * @param source source file.
     * @param destination output file.
     * @param indent indent.
     * @param check check.
     */
    public final void execute(final IReader source,
                              final IWrite destination,
                              final int indent, final boolean check) {
        try {
            destination.writeChar(symbol);
        } catch (WriterException e) {
            throw new RuntimeException("Error. WriterIgnoreComment");
        }
    }
}
