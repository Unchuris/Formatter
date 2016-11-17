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
            destination.writeChar('/');
            destination.writeChar(symbol);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        symbol = 0;
        char previous = 0;
                try {
                    if (source.hasChars()) {
                        previous = source.readChar();
                        if (source.hasChars()) {
                            symbol = source.readChar();
                        }
                    }
                    while (symbol != '/' || previous != '*') {
                        destination.writeChar(previous);
                        previous = symbol;
                        symbol = source.readChar();
                    }
                    destination.writeChar(previous);
                    destination.writeChar(symbol);
                } catch (ReaderException e) {
                    e.printStackTrace();
                } catch (WriterException e) {
                    e.printStackTrace();
                }
    }
}
