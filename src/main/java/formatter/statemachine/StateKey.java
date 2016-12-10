package formatter.statemachine;

/**
 * StateKey.
 */
class StateKey {
    /**
     * state.
     */
    private IState key;
    /**
     * symbol.
     */
    private String value;

    /**
     * beforeState.
     * @param state state.
     * @param symbol symbol.
     */
    StateKey(final IState state, final String symbol) {
        key = state;
        this.value = symbol;
    }

    /**
     * StateKey.
     * @param state state.
     */
    StateKey(final IState state) {
        key = state;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StateKey entry = (StateKey) o;
        return key != null ? key.equals(entry.key) : entry.key == null
                && (value != null ? value.equals(entry.value)
                        : entry.value == null);
    }
    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
