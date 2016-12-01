package formatter.StateMachine;

/**
 * BeforeState.
 */
class BeforeState {
    /**
     * state.
     */
    private ICommand key;
    /**
     * symbol.
     */
    private Character value;

    /**
     * beforeState.
     * @param state state.
     * @param symbol symbol.
     */
    BeforeState(final ICommand state, final char symbol) {
        key = state;
        this.value = symbol;
    }

    /**
     * BeforeState.
     * @param state state.
     */
    BeforeState(final ICommand state) {
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
        BeforeState entry = (BeforeState) o;
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
