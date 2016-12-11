package formatter.statemachine;

import formatter.actions.IAction;
import formatter.actions.OpeningBracket;
import formatter.actions.WriterSymbol;


/**
 * For.
 */
class IgnoreFor implements IState {
    /**
     *
     * @param symbol symbol.
     * @param state state.
     * @return IAction.
     */
    public IAction getAction(final String symbol, final IState state) {
        if (symbol.equals("{")) {
            return new OpeningBracket();
        }
        return new WriterSymbol();
    }
}
