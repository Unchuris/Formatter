package formatter.Actions;

import formatter.Core.IWrite;

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
    public final void action(final IWrite destination,
                       final char symbol, final Indent indent) {
        IAction write = new WriterIndentSpaces();
        write.action(destination, symbol, indent);
    }
}
