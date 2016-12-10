package formatter.statemachine;


import formatter.actions.IAction;

/**
 * DefaultState.
 */
class Default implements IState {
    /**
     *
     * @param symbol symbol.
     * @param state state.
     * @return new.
     */
    public IAction getAction(final String symbol, final IState state) {
        HashMapDefault map = new HashMapDefault();
        return map.getMap(symbol);
    }

}
