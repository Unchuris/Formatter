package formatter.actions;

import formatter.core.IWrite;

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
    void action(IWrite<String> destination, String symbol, Indent indent);
}
