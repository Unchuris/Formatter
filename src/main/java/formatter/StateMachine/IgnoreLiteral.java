package formatter.StateMachine;

import formatter.Actions.IAction;
import formatter.Actions.WriterSymbol;
import formatter.Core.IWrite;

/**
 * IgnoreLiterals.
 */
class IgnoreLiteral implements ICommand {
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
