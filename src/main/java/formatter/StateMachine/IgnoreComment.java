package formatter.StateMachine;

import formatter.Actions.IAction;
import formatter.Actions.WriterSymbol;
import formatter.Core.IWrite;

/**
 *IgnoreComment.
 */
class IgnoreComment implements ICommand {
    /**
     * execute.
     * @param destination output file.
     * @param symbol symbol.
     */
    public void execute(final IWrite destination, final char symbol) {
        IAction write = new WriterSymbol();
        write.action(destination, symbol, null);
    }
}
