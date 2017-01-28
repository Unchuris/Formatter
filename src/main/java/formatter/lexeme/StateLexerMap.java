package formatter.lexeme;


import java.util.HashMap;

/**
 * StateLexerMap.
 */
class StateLexerMap {
    /**
     * State.
     */
    private State defaultState;
    /**
     * HashMap.
     */
    private HashMap<StateKey, State> hashMap;

    /**
     * StateLexerMap.
     */
    StateLexerMap() {
        defaultState = new State("word");
        hashMap = new HashMap<StateKey, State>();
        State skip = new State("skip");
        State stop = new State("return");
        State oneMore = new State("maybeWord");
        State oneMoreStar = new State("perhapsWord");
        hashMap.put(new StateKey(defaultState, '{'), stop);
        hashMap.put(new StateKey(defaultState, ';'), stop);
        hashMap.put(new StateKey(defaultState, '}'), stop);
        hashMap.put(new StateKey(defaultState, '('), stop);
        hashMap.put(new StateKey(defaultState, ')'), stop);
        hashMap.put(new StateKey(defaultState, '\"'), stop);
        hashMap.put(new StateKey(defaultState, '\''), stop);
        hashMap.put(new StateKey(stop, '{'), stop);
        hashMap.put(new StateKey(stop, '}'), stop);
        hashMap.put(new StateKey(stop, ';'), stop);
        hashMap.put(new StateKey(stop, '\"'), stop);
        hashMap.put(new StateKey(stop, '\''), stop);
        hashMap.put(new StateKey(stop), defaultState);
        hashMap.put(new StateKey(defaultState, ' '), skip);
        hashMap.put(new StateKey(defaultState, '\n'), skip);
        hashMap.put(new StateKey(defaultState, '/'), oneMore);
        hashMap.put(new StateKey(defaultState, '*'), oneMoreStar);
        hashMap.put(new StateKey(skip, ' '), skip);
        hashMap.put(new StateKey(skip, '\n'), skip);
        hashMap.put(new StateKey(skip), defaultState);
        hashMap.put(new StateKey(oneMore, '/'), stop);
        hashMap.put(new StateKey(oneMore, '*'), stop);
        hashMap.put(new StateKey(oneMore, '{'), stop);
        hashMap.put(new StateKey(oneMore, '}'), stop);
        hashMap.put(new StateKey(oneMore, ';'), stop);
        hashMap.put(new StateKey(oneMore, '\"'), stop);
        hashMap.put(new StateKey(oneMore, '\''), stop);
        hashMap.put(new StateKey(oneMoreStar, '/'), stop);
        hashMap.put(new StateKey(oneMoreStar, '{'), stop);
        hashMap.put(new StateKey(oneMoreStar, '}'), stop);
        hashMap.put(new StateKey(oneMoreStar, ';'), stop);
        hashMap.put(new StateKey(oneMoreStar, '\''), stop);
        hashMap.put(new StateKey(oneMoreStar, '\"'), stop);
        hashMap.put(new StateKey(oneMore), defaultState);
        hashMap.put(new StateKey(oneMoreStar), defaultState);
    }

    /**
     * getInitializationState.
     * @return defaultState.
     */
    State getInitializationState() {
        return defaultState;
    }

    /**
     *
     * @param c char,
     * @param state state,
     * @return state.
     */
    State getNextState(final char c, final State state) {
        if (hashMap.containsKey(new StateKey(state, c))) {
            return hashMap.get(new StateKey(state, c));
        }
        if (hashMap.containsKey(new StateKey(state))) {
            return hashMap.get(new StateKey(state));
        }
        return state;
    }
}
