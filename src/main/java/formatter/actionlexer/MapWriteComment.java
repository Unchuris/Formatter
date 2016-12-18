package formatter.actionlexer;

import java.util.HashMap;

/**
 * MapWriteComment.
 */
class MapWriteComment {
        /**
         * HashMap.
         */
        private HashMap<String, IAct> hashMap;

        /**
         * HashMap.
         */
        MapWriteComment() {
            hashMap = new HashMap<String, IAct>();
            hashMap.put("//", new WriteSymbol());
            hashMap.put("/*", new WriteSymbol());
            hashMap.put("*/", new WriteSymbol());
        }
        /**
         *
         * @param symbol symbol.
         * @return String.
         */
        String getMap(final String symbol) {
            if (hashMap.containsKey(symbol)) {
                return symbol;
            } else {
                return null;
            }
        }
}
