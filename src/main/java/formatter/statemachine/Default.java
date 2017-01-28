package formatter.statemachine;


import formatter.actions.IAction;
import formatter.actions.Indent;

/**
 * DefaultState.
 */
class Default implements IState {
    /**
     * indent.
     */
    private Indent indent;

    /**
     *
     * @param ind indent.
     */
    Default(final Indent ind) {
        this.indent = ind;
    }

    /**
     *
     * @param symbol symbol.
     * @param state state.
     * @return new.
     */
    public IAction getAction(final String symbol, final IState state) {
        HashMapDefault map = new HashMapDefault(indent);
        return map.getMap(symbol);
    }

}
