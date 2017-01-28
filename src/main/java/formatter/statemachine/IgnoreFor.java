package formatter.statemachine;

import formatter.actions.IAction;
import formatter.actions.Indent;
import formatter.actions.OpeningBracket;
import formatter.actions.WriterSymbol;


/**
 * For.
 */
class IgnoreFor implements IState {
    /**
     * indent.
     */
    private Indent indent;

    /**
     *
     * @param ind indent.
     */
    IgnoreFor(final Indent ind) {
        this.indent = ind;
    }

    /**
     * getAction.
     * @param symbol symbol.
     * @param state state.
     * @return IAction.
     */
    public IAction getAction(final String symbol, final IState state) {
        if (symbol.equals("{")) {
            return new OpeningBracket(indent);
        } else {
            return new WriterSymbol();
        }
    }
}
