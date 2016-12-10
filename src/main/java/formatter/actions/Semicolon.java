package formatter.actions;

import formatter.core.IWrite;

/**
 * symbol processing ';'.
 */
public class Semicolon implements IAction {

    /**
     * action.
     * @param destination output file.
     * @param symbol symbol.
     * @param indent indent.
     */
    public final void action(final IWrite<String> destination,
                             final String symbol, final Indent indent) {
        IAction write = new WriterIndentSpaces();
        write.action(destination, symbol, indent);
    }
}
