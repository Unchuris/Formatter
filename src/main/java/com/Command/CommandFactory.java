package com.Command;

import java.util.HashMap;

/**
 * Factory.
 */
public final class CommandFactory {
    /**
     * check.
     */
    private static boolean check = false;

    /**
     * factory.
     */
    private CommandFactory() {

    }

    /**
     * getCommand.
     * @param criteria char.
     * @param symbol char.
     * @param indent indent.
     * @param check boolean.
     * @return new.
     */
    public static ICommand getCommand(final char criteria,
                                      final char symbol,
                                      final int indent, final boolean check) {

        HashMap<String, ICommand> hashMap = new HashMap<String, ICommand>();

        String value = "" + criteria + symbol;
        hashMap.put("{", new OpeningBracket(indent));
        hashMap.put("/*", new IgnoreMultiComment(symbol));
        hashMap.put("}", new ClosingBracket(indent));
        hashMap.put(";", new Semicolon(indent));
        hashMap.put("//", new IgnoreComment(symbol, check));
        hashMap.put("'", new IgnoreLiteral(symbol));
        hashMap.put("\"", new IgnoreLiteral(symbol));

        if (hashMap.containsKey(value)) {
            return hashMap.get(value);
        }
        String valueOne = "" + value.charAt(1);
        if (hashMap.containsKey(valueOne)) {
            return hashMap.get(valueOne);
        }
        return new WriterSymbol(symbol);
    }
}
