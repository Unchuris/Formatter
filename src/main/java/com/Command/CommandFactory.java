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
     * @param next next symbol.
     * @return new.
     */
    public static ICommand getCommand(final char criteria, final char next) {
        switch (criteria) {
            case '{':
                    if (!check) {
                        return new OpeningBracket();
                    } else {
                        check = false;
                        return new Skip();
                     }
            case ';':
                    if (!check) {
                    return new Semicolon();
                    } else {
                        check = false;
                        return new Skip();
                    }
            case '}':
                    if (!check) {
                    return new ClosingBracket();
                    } else {
                        check = false;
                        return new Skip();
                    }
            case '/':
                    if (!check) {
                    if (next == '/') {
                        check = true;
                        return new IgnoreComment(next);
                    }
                    if (next == '*') {
                        check = true;
                        return new IgnoreMultiComment(next);
                    }
                        return new WriterSymbol(criteria);
                    } else {
                        check = false;
                        return new Skip();
                    }
            case '\'':
                    check = true;
                    return new IgnoreLiteral(criteria, next);
            case '"':
                    check = true;
                    return new IgnoreLiteral(criteria, next);
            default:
                if (!check) {
                    return new WriterSymbol(criteria);
                } else {
                    check = false;
                    return new Skip();
                }
        }
    }
}
