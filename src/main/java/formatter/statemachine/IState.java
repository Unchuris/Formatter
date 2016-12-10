package formatter.statemachine;

import formatter.actions.IAction;

/**
 * IState.
 */
public interface IState {
    /**
     *
     * @param symbol symbol.
     * @param state state.
     * @return new.
     */
    IAction getAction(String symbol, IState state);
}
