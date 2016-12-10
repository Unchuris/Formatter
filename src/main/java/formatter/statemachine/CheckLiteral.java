package formatter.statemachine;

import formatter.actions.IAction;
import formatter.actions.WriterSymbol;

/**
 * CheckLiteral.
 */
class CheckLiteral implements IState {
    /**
     *
     * @param symbol symbol.
     * @param state state.
     * @return new.
     */
    public IAction getAction(final String symbol, final IState state) {
        return new WriterSymbol();
    }
}
