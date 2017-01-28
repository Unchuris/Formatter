package formatter.lexeme;

import formatter.lexeme.actionLexer.Append;
import formatter.lexeme.actionLexer.Return;
import formatter.lexeme.actionLexer.Skip;

import java.util.HashMap;

/**
 * LexerMap.
 */
class LexerMap {
    /**
     * HashMap.
     */
    private HashMap<StateKey, IActionLexer> hashMap;

    /**
     * LexerMap.
     */
    LexerMap() {
        hashMap = new HashMap<StateKey, IActionLexer>();
        hashMap.put(new StateKey(new State("word"), '{'), new Return());
        hashMap.put(new StateKey(new State("word"), '}'), new Return());
        hashMap.put(new StateKey(new State("word"), ';'), new Return());
        hashMap.put(new StateKey(new State("word"), '\"'), new Return());
        hashMap.put(new StateKey(new State("word"), '\''), new Return());
        hashMap.put(new StateKey(new State("word")), new Append());
        hashMap.put(new StateKey(new State("word"), ' '), new Return());
        hashMap.put(new StateKey(new State("word"), '\n'), new Return());
        hashMap.put(new StateKey(new State("skip"), ' '), new Skip());
        hashMap.put(new StateKey(new State("skip"), '\n'), new Skip());
        hashMap.put(new StateKey(new State("maybeWord"), '/'), new Append());
        hashMap.put(new StateKey(new State("maybeWord"), '*'), new Append());
        hashMap.put(new StateKey(new State("perhapsWord"), '/'), new Append());
    }

    /**
     *
     * @param state state.
     * @param c String.
     * @return IActionLexer.
     */
    IActionLexer getMap(final State state, final char c) {
        if (hashMap.containsKey(new StateKey(state, c))) {
            return hashMap.get(new StateKey(state, c));
        }
        if (hashMap.containsKey(new StateKey(state))) {
            return hashMap.get(new StateKey(state));
        }
        return new Return();
    }
}
