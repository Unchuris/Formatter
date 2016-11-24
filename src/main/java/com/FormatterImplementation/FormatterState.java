package com.FormatterImplementation;

import java.util.HashMap;

/**
 * State.
 */
class FormatterState {
    /**
     * NextState.
     * @param currentState indent.
     * @param symbol symbol.
     * @return indent.
     */
     int getNextState(final int currentState, final char symbol) {
         int inc = currentState + 1;
         int dec = currentState - 1;
         if (dec < 0) {
             dec = 0;
         }
         HashMap<Character, Integer> hashMap =
                 new HashMap<Character, Integer>();
         hashMap.put('{', inc);
         hashMap.put('}', dec);
         if (hashMap.containsKey(symbol)) {
             return hashMap.get(symbol);
         } else {
             return currentState;
        }

    }

    /**
     * Check.
     * @param previous previous.
     * @param symbol symbol.
     * @param check check.
     * @return boolean.
     */
    boolean getCheck(final char previous,
                     final char symbol, final boolean check) {
        return !(previous == '/' && symbol == '/');
    }
}
