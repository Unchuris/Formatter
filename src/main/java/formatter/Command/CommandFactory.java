package formatter.Command;

import java.util.HashMap;

/**
 * Factory.
 */
public final class CommandFactory {
    /**
     * Factory.
     */
    private CommandFactory() {

    }
    /**
     * getCommand.
     * @param criteria char.
     * @param symbol char.
     * @return new.
     */
    public static ICommand getCommand(final char criteria,
                                      final char symbol) {

        HashMap<String, ICommand> hashMap = new HashMap<String, ICommand>();

        String value = "" + criteria + symbol;
        hashMap.put("{", new OpeningBracket());
        hashMap.put("/*", new IgnoreMultiComment(symbol));
        hashMap.put("}", new ClosingBracket());
        hashMap.put(";", new Semicolon());
        hashMap.put("//", new IgnoreComment(symbol));
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
