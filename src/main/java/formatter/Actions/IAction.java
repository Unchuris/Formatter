package formatter.Actions;

import formatter.Core.IWrite;

/**
 * Interface for action.
 */
public interface IAction {
    /**
     * Action.
     * @param destination output file.
     * @param symbol symbol.
     * @param indent indent.
     */
    void action(IWrite destination, char symbol, Indent indent);
}
