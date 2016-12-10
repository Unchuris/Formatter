package formatter.actions;

import formatter.core.IWrite;

/**
 * symbol processing '}'.
 */
public class ClosingBracket implements IAction {

    /**
     * Action.
     * @param destination output file.
     * @param symbol symbol.
     * @param indent indent.
     */
    public final void action(final IWrite<String> destination,
                             final String symbol, final Indent indent) {
        indent.decIndent();
        IAction write = new WriterIndentSpaces();
        write.action(destination, symbol, indent);
    }
}
