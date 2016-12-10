package formatter.statemachine;

import formatter.actions.ClosingBracket;
import formatter.actions.IAction;
import formatter.actions.OpeningBracket;
import formatter.actions.Semicolon;
import formatter.actions.WriterSymbol;

import java.util.HashMap;

/**
 * HashMap.
 */
class HashMapDefault {
    /**
     * HashMap.
     */
    private HashMap<String, IAction> hashMap;

    /**
     * HashMap.
     */
    HashMapDefault() {
        hashMap = new HashMap<String, IAction>();
        hashMap.put("{", new OpeningBracket());
        hashMap.put("}", new ClosingBracket());
        hashMap.put(";", new Semicolon());
    }

    /**
     *
     * @param symbol symbol.
     * @return new.
     */
    IAction getMap(final String symbol) {
        if (hashMap.containsKey(symbol)) {
            return hashMap.get(symbol);
        } else {
            return new WriterSymbol();
        }
    }
}
