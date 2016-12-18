package formatter.lexem;

import formatter.actionlexer.IAct;
import formatter.actionlexer.Store;
import formatter.actionlexer.WriteSymbol;

import java.util.HashMap;

/**
 * HashMapDef.
 */
class HashMapDef {
    /**
     * HashMap.
     */
    private HashMap<Character, IAct> hashMap;

    /**
     * HashMap.
     */
    HashMapDef() {
        hashMap = new HashMap<Character, IAct>();
        hashMap.put('{', new WriteSymbol());
        hashMap.put('}', new WriteSymbol());
        hashMap.put(';', new WriteSymbol());
        hashMap.put('\n', new WriteSymbol());
        hashMap.put('"', new WriteSymbol());
        hashMap.put('\'', new WriteSymbol());
        hashMap.put(' ', new WriteSymbol());
    }

    /**
     *
     * @param symbol symbol.
     * @return new.
     */
    IAct getMap(final Character symbol) {
        if (hashMap.containsKey(symbol)) {
            return hashMap.get(symbol);
        } else {
            return new Store();
        }
    }
}
