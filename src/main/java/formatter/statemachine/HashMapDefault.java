package formatter.statemachine;



import formatter.actions.IAction;
import formatter.actions.Indent;
import formatter.actions.OpeningBracket;
import formatter.actions.Semicolon;
import formatter.actions.WriterSymbol;
import formatter.actions.ClosingBracket;

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
     *
     * @param indent indent.
     */
    HashMapDefault(final Indent indent) {
        hashMap = new HashMap<String, IAction>();
        hashMap.put("{", new OpeningBracket(indent));
        hashMap.put("}", new ClosingBracket(indent));
        hashMap.put(";", new Semicolon(indent));
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
