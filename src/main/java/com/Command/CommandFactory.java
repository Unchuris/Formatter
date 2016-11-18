package com.Command;

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
     *
     * @param criteria symbol.
     * @param symbol next symbol.
     * @return new.
     */
    public static ICommand getCommand(final char criteria, final char symbol) {
        switch (symbol) {
            case '{':
                    return new OpeningBracket();
            case ';':
                    return new Semicolon();
            case '}':
                    return new ClosingBracket();
            case '/':
                    if (criteria == '/' && !check) {
                        check = true;
                        return new IgnoreComment(symbol);
                    } else {
                        check = false;
                        return new WriterSymbol(symbol);
                    }
            case '*':
                        if (criteria == '/') {
                            return new IgnoreMultiComment(symbol);
                        } else {
                            return new WriterSymbol(symbol);
                        }
            case '\'':
                    return new IgnoreLiteral(symbol);
            case '"':
                    return new IgnoreLiteral(symbol);
            default:
                    return new WriterSymbol(symbol);
        }
    }
}
