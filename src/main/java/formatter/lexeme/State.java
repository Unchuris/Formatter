package formatter.lexeme;

/**
 * State.
 */
class State implements IState  {
    /**
     * string.
     */
    private String string;

    /**
     * String.
     * @param c string.
     *
     */
    State(final String c) {
        this.string = c;
    }
    /**
     *
     * @param o Object.
     * @return boolean.
     */
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        State state1 = (State) o;
        return string.equals(state1.string);
    }
    /**
     * hashCode.
     * @return int.
     */
    @Override
    public final int hashCode() {
        return string.hashCode();
    }

    /**
     *
     *
     *
     * @param c char,
     * @param state state.
     * @return map.
     */
    public IActionLexer getAction(final char c, final State state) {
        LexerMap map = new LexerMap();
        return map.getMap(state, c);
    }
}
