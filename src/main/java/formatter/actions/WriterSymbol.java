package formatter.actions;

import formatter.core.IWrite;
import formatter.core.WriterException;

/**
 * Whiter symbol.
 */
public class WriterSymbol implements IAction {
    /**
     * actionlexer.
     * @param destination output file.
     * @param symbol symbol.
     * @param indent indent.
     */
    public final void action(final IWrite<String> destination,
                             final String symbol, final Indent indent) {
        try {
            destination.writeChar(symbol);
        } catch (WriterException e) {
            throw new RuntimeException("Error. WriterIgnoreComment");
        }
    }
}
