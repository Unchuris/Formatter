package formatter.statemachine;

import formatter.actions.IAction;
import formatter.actions.OpeningBracket;
import formatter.actions.WriterSymbol;


/**
 * For.
 */
class IgnoreFor implements IState {

    /**
     * getAction.
     * @param symbol symbol.
     * @param state state.
     * @return IAction.
     */
    public IAction getAction(final String symbol, final IState state) {
        if (symbol.equals("{")) {
            return new OpeningBracket();
        } else {
            return new WriterSymbol();
        }
    }
}
