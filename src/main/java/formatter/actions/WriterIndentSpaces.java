package formatter.actions;

import formatter.core.IWrite;
import formatter.core.WriterException;

/**
 * Write.
 */
public class WriterIndentSpaces implements IAction {
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
            destination.writeChar("\n");
            for (int i = 0; i < indent.getIndent(); i++) {
                for (int j = 0; j < indent.getSpaces(); j++) {
                    destination.writeChar(" ");
                }
            }
        } catch (WriterException e) {
            throw new RuntimeException("Error. WriterIgnoreComment");
        }
    }
}
