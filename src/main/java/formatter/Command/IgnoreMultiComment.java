package formatter.Command;

import formatter.Core.IReader;
import formatter.Core.IWrite;
import formatter.Core.ReaderException;
import formatter.Core.WriterException;

/**
 * Ignore multi comment.
 */
class IgnoreMultiComment implements ICommand {
    /**
     * symbol.
     */
    private char symbol;

    /**
     *
     * @param next symbol.
     */
    IgnoreMultiComment(final char next) {
        this.symbol = next;
    }

    /**
     * execute.
     * @param source source file.
     * @param destination output file.
     * @param indent indent.
     * @param check check.
     */
    public void execute(final IReader source,
                        final IWrite destination,
                        final int indent, final boolean check) {
        try {
            boolean flag = true;
            destination.writeChar(symbol);
            while (source.hasChars() && flag) {
                symbol = source.readChar();
                switch (symbol) {
                    case '*':
                        destination.writeChar(symbol);
                        if (source.hasChars()) {
                            symbol = source.readChar();
                            if (symbol == '/') {
                                flag = false;
                            }
                            destination.writeChar(symbol);
                        }
                        break;
                    default:
                        destination.writeChar(symbol);
                }
            }
        } catch (ReaderException e) {
            throw new RuntimeException("Error. ReaderMultiComment");
        } catch (WriterException e) {
            throw new RuntimeException("Error. WriterMultiComment");
        }
    }
}
