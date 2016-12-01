package formatter.Actions;

import formatter.Core.IWrite;
import formatter.Core.WriterException;

/**
 * Whiter symbol.
 */
public class WriterSymbol implements IAction {
    /**
     * action.
     * @param destination output file.
     * @param symbol symbol.
     * @param indent indent.
     */
    public final void action(final IWrite destination,
                       final char symbol, final Indent indent) {
        try {
            destination.writeChar(symbol);
        } catch (WriterException e) {
            throw new RuntimeException("Error. WriterIgnoreComment");
        }
    }
}
