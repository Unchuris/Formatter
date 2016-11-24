package com.Command;

import com.Core.IReader;
import com.Core.IWrite;
import com.Core.ReaderException;
import com.Core.WriterException;

/**
 * Ignore comment.
 */
class IgnoreComment implements ICommand {
    /**
     * symbol.
     */
    private char symbol;
    /**
     * check.
     */
    private boolean check;

    /**
     * Ignore.
     * @param next symbol.
     * @param check boolean.
     */
    IgnoreComment(final char next, final boolean check) {
        this.symbol = next;
        this.check = check;
    }

    /**
     * execute.
     * @param source source file.
     * @param destination output file.
     */
    public void execute(final IReader source, final IWrite destination) {
        try {
            if (check) {
                destination.writeChar(symbol);
                while ((symbol != '\n') && (source.hasChars())) {
                    symbol = source.readChar();
                    destination.writeChar(symbol);
                }
            } else {
                destination.writeChar('/');
            }
            } catch (ReaderException e) {
                throw new RuntimeException("Error. ReaderIgnoreComment");
            } catch (WriterException e) {
                throw new RuntimeException("Error. WriterIgnoreComment");
            }
    }
}
