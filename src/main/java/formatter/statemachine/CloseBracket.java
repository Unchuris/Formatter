package formatter.statemachine;

import formatter.actions.ClosingBracket;
import formatter.actions.IAction;

/**
 * CloseBracket.
 */
public class CloseBracket implements IState {
    /**
     *
     * @param symbol symbol.
     * @param state state.
     * @return new.
     */
    public final IAction getAction(final String symbol, final IState state) {
        return new ClosingBracket();
    }
}
