package formatter.StateMachine;

import formatter.Actions.Indent;

import java.util.HashMap;

/**
 * StateMachine.
 */
public class State {
    /**
     * defaultState.
     */
    private ICommand defaultState;
    /**
     * HashMap.
     */
    private HashMap<BeforeState, ICommand> hashMap;

    /**
     * State.
     * @param indent indent,
     */
    public State(final Indent indent) {

        hashMap = new HashMap<BeforeState, ICommand>();
        defaultState = new Default(indent);
        ICommand perhapsComment = new PerhapsComment();
        ICommand ignoreComment = new IgnoreComment();
        ICommand ignoreMultiComment = new IgnoreMultiComment();
        ICommand perhapsClose = new PerhapsClose();
        ICommand ignoreLiteral = new IgnoreLiteral();
        ICommand ignore = new IgnoreLiteralDouble();
        ICommand check = new CheckSymbol();
        ICommand checkLiteral = new CheckLiteral();

        hashMap.put(new BeforeState(defaultState, '/'), perhapsComment);
        hashMap.put(new BeforeState(perhapsComment, '/'), ignoreComment);
        hashMap.put(new BeforeState(ignoreComment, '\n'), defaultState);
        hashMap.put(new BeforeState(perhapsComment, '*'), ignoreMultiComment);
        hashMap.put(new BeforeState(ignoreMultiComment, '*'), perhapsClose);
        hashMap.put(new BeforeState(perhapsClose, '/'), defaultState);
        hashMap.put(new BeforeState(perhapsComment), defaultState);
        hashMap.put(new BeforeState(defaultState, '\''), ignoreLiteral);
        hashMap.put(new BeforeState(ignoreLiteral, '\\'), check);
        hashMap.put(new BeforeState(check), ignoreLiteral);
        hashMap.put(new BeforeState(ignoreLiteral, '\''), defaultState);
        hashMap.put(new BeforeState(defaultState, '"'), ignore);
        hashMap.put(new BeforeState(ignore, '\\'), checkLiteral);
        hashMap.put(new BeforeState(checkLiteral), ignore);
        hashMap.put(new BeforeState(ignore, '"'), defaultState);

    }
    /**
     * Initial state.
     * @return defaultState.
     */
    public final ICommand start() {
        return defaultState;
    }

    /**
     * getNextState.
     * @param symbol symbol.
     * @param state state.
     * @return BeforeState.
     */
    public final ICommand getNextState(final char symbol,
                                       final ICommand state) {
        if (hashMap.containsKey(new BeforeState(state, symbol))) {
            return hashMap.get(new BeforeState(state, symbol));
        }
        if (hashMap.containsKey(new BeforeState(state))) {
            return hashMap.get(new BeforeState(state));
        }
        return state;
    }
}
