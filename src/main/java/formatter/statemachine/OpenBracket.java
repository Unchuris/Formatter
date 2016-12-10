package formatter.statemachine;

import formatter.actions.IAction;
import formatter.actions.Semicolon;

/**
 * OpenBracket.
 */
public class OpenBracket implements IState {
    /**
     *
     * @param symbol symbol.
     * @param state state.
     * @return new.
     */
    public final IAction getAction(final String symbol, final IState state) {
        return new Semicolon();
    }
}
