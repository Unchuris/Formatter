package formatter.statemachine;

import formatter.actions.Indent;

import java.util.HashMap;

/**
 * TransitionTable.
 */
public class TransitionTable {
    /**
     * defaultState.
     */
    private IState defaultState;
    /**
     * HashMaps.
     */
    private HashMap<StateKey, IState> hashMap;

    /**
     * TransitionTable.
     * @param indent indent,
     */
    public TransitionTable(final Indent indent) {

        hashMap = new HashMap<StateKey, IState>();
        defaultState = new Default();

        IState ignoreComment = new IgnoreComment();
        IState ignoreMultiComment = new IgnoreMultiComment();

        IState ignoreLiteral = new IgnoreLiteral();
        IState ignore = new IgnoreLiteralDouble();
        IState check = new CheckSymbol();
        IState checkLiteral = new CheckLiteral();
        IState ignoreFor = new IgnoreFor();

        hashMap.put(new StateKey(defaultState, "//"), ignoreComment);
        hashMap.put(new StateKey(ignoreComment, "\n"), defaultState);
        hashMap.put(new StateKey(defaultState, "/*"), ignoreMultiComment);
        hashMap.put(new StateKey(ignoreMultiComment, "*/"), defaultState);

        hashMap.put(new StateKey(defaultState, "for"), ignoreFor);
        hashMap.put(new StateKey(ignoreFor, "{"), defaultState);
        hashMap.put(new StateKey(ignoreFor, "\n"), defaultState);

        hashMap.put(new StateKey(defaultState, "\'"), ignoreLiteral);
        hashMap.put(new StateKey(ignoreLiteral, "\\"), check);
        hashMap.put(new StateKey(check), ignoreLiteral);
        hashMap.put(new StateKey(ignoreLiteral, "\'"), defaultState);
        hashMap.put(new StateKey(defaultState, "\""), ignore);
        hashMap.put(new StateKey(ignore, "\\"), checkLiteral);
        hashMap.put(new StateKey(checkLiteral), ignore);
        hashMap.put(new StateKey(ignore, "\""), defaultState);

    }
    /**
     * Initial state.
     * @return defaultState.
     */
    public final IState start() {
        return defaultState;
    }

    /**
     * getNextState.
     * @param symbol symbol.
     * @param state state.
     * @return StateKey.
     */
    public final IState getNextState(final String symbol,
                                     final IState state) {
        if (hashMap.containsKey(new StateKey(state, symbol))) {
            return hashMap.get(new StateKey(state, symbol));
        }
        if (hashMap.containsKey(new StateKey(state))) {
            return hashMap.get(new StateKey(state));
        }
        return state;
    }
}
