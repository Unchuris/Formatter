package formatter.Command;

import formatter.Core.IReader;
import formatter.Core.IWrite;
import formatter.Core.ReaderException;
import formatter.Core.WriterException;

/**
 * Ignore comment.
 */
class IgnoreComment implements ICommand {
    /**
     * symbol.
     */
    private char symbol;
    /**
     * Ignore.
     * @param next symbol.
     */
    IgnoreComment(final char next) {
        this.symbol = next;
    }

    /**
     *
     * @param source file.
     * @param destination file.
     * @param indent indent.
     * @param check check.
     */
    public void execute(final IReader source,
                        final IWrite destination,
                        final int indent,
                        final boolean check) {
        try {
            if (check) {
                destination.writeChar(symbol);
                while ((symbol != '\n') && (source.hasChars())) {
                    symbol = source.readChar();
                    destination.writeChar(symbol);
                }
            } else {
                destination.writeChar('/');
            }
            } catch (ReaderException e) {
                throw new RuntimeException("Error. ReaderIgnoreComment");
            } catch (WriterException e) {
                throw new RuntimeException("Error. WriterIgnoreComment");
            }
    }
}
