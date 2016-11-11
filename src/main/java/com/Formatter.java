package com;

import java.io.IOException;
    /**
     *edited the text style.
     */
    public final class Formatter implements IFormatter {

        private static void ignoreComment(final IReader source, final IWrite destination) throws IOException {
                char symbol;
                boolean commentMulti = false;
                boolean commentOne = false;
                if (source.hasChars()) {
                    symbol = source.readChar();
                    switch (symbol) {
                        case '*':
                            commentMulti = true;
                            destination.writeChar(symbol);
                            break;
                        case '/':
                            commentOne = true;
                            destination.writeChar(symbol);
                            break;
                        default:
                            destination.writeChar(symbol);
                    }
                }
                while (source.hasChars() && (commentMulti)) {
                    symbol = source.readChar();
                    switch (symbol) {
                        case '*':
                            destination.writeChar(symbol);
                            if (source.hasChars()) {
                                symbol = source.readChar();
                                if (symbol == '/') {
                                    commentMulti = false;
                                }
                                destination.writeChar(symbol);
                            }
                            break;
                        default:
                            destination.writeChar(symbol);
                    }
                }
                while (source.hasChars() && (commentOne)) {
                    symbol = source.readChar();
                    switch (symbol) {
                        case '\n':
                            destination.writeChar(symbol);
                            commentOne = false;
                            break;
                        default:
                            destination.writeChar(symbol);
                    }
                }
        }

        private static void ignoreLiterals(final IReader source, final IWrite destination, final char symbol) throws IOException {
            char copySymbol, newCopySymbol;
            copySymbol = symbol;
            if ((copySymbol == '\'') || (copySymbol == '"')) {
                newCopySymbol = copySymbol;
                copySymbol = 'ᴥ';
                while ((copySymbol != newCopySymbol) && (source.hasChars())) {
                    copySymbol = source.readChar();
                    destination.writeChar(copySymbol);
                }
            }
        }


        /**
         *
         * @param source source file.
         * @param destination output file.
         */
        public void format(final IReader source, final IWrite destination) {
            try {
                int indent = 0;
                char symbol;
                while (source.hasChars()) {
                    if (indent < 0) {
                        indent = 0;
                    }
                    symbol = source.readChar();
                    switch (symbol) {
                        case '{':
                            destination.writeChar(symbol);
                            destination.writeChar('\n');
                            indent++;
                            for (int i = 0; i < indent; i++) {
                                    destination.writeChar(' ');
                                    destination.writeChar(' ');
                                    destination.writeChar(' ');
                                    destination.writeChar(' ');
                            }
                            break;
                        case ';':
                            destination.writeChar(symbol);
                            destination.writeChar('\n');
                            for (int i = 0; i < indent; i++) {
                                destination.writeChar(' ');
                                destination.writeChar(' ');
                                destination.writeChar(' ');
                                destination.writeChar(' ');
                            }
                            break;
                        case '}':
                            destination.writeChar(symbol);
                            destination.writeChar('\n');
                            indent--;
                            for (int i = 0; i < indent; i++) {
                                destination.writeChar(' ');
                                destination.writeChar(' ');
                                destination.writeChar(' ');
                                destination.writeChar(' ');
                            }
                            break;
                        case '/':
                            destination.writeChar(symbol);
                            ignoreComment(source, destination);
                            break;
                        default:
                            destination.writeChar(symbol);
                            ignoreLiterals(source, destination, symbol);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
