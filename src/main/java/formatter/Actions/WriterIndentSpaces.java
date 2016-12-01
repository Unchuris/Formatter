package formatter.Actions;

import formatter.Core.IWrite;
import formatter.Core.WriterException;

/**
 * Write.
 */
public class WriterIndentSpaces implements IAction {
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
            destination.writeChar('\n');
            for (int i = 0; i < indent.getIndent(); i++) {
                for (int j = 0; j < indent.getSpaces(); j++) {
                    destination.writeChar(' ');
                }
            }
        } catch (WriterException e) {
            throw new RuntimeException("Error. WriterIgnoreComment");
        }
    }
}
