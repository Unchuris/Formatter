package com;

import java.io.IOException;

    /**
     *edited the text style.
     */
    public final class Formatter implements IFormatter {
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
                        default:
                            destination.writeChar(symbol);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
