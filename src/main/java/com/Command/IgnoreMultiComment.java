package com.Command;

import com.Core.IReader;
import com.Core.IWrite;
import com.Core.ReaderException;
import com.Core.WriterException;

/**
 * Ignore multi comment.
 */
class IgnoreMultiComment implements ICommand {
    /**
     * symbol.
     */
    private char symbol;
    /**
     * /.
     */
    private boolean flag;

    /**
     *
     * @param next symbol.
     */
    IgnoreMultiComment(final char next) {
        this.symbol = next;
    }

    /**
     * execute.
     * @param source source file.
     * @param destination output file.
     */
    public void execute(final IReader source, final IWrite destination) {
        try {
            flag = true;
            destination.writeChar(symbol);
                    while (source.hasChars() && flag) {
                        symbol = source.readChar();
                        switch (symbol) {
                            case '*':
                                destination.writeChar(symbol);
                                if (source.hasChars()) {
                                    symbol = source.readChar();
                                    if (symbol == '/') {
                                        flag = false;
                                    }
                                    destination.writeChar(symbol);
                                }
                                break;
                            default:
                                destination.writeChar(symbol);
                        }

                    }
                } catch (ReaderException e) {
                    throw new RuntimeException("Error. ReaderMultiComment");
                } catch (WriterException e) {
                    throw new RuntimeException("Error. WriterMultiComment");
                }
    }
}
