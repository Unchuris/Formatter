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
     *
     * @param next symbol.
     */
    IgnoreComment(final char next) {
        this.symbol = next;
    }

    /**
     * execute.
     * @param source source file.
     * @param destination output file.
     */
    public void execute(final IReader source, final IWrite destination) {
        try {
            destination.writeChar(symbol);
            while ((symbol != '\n') && (source.hasChars())) {
                symbol = source.readChar();
                destination.writeChar(symbol);
            }
        } catch (ReaderException e) {
            throw new RuntimeException("Error. ReaderIgnoreComment");
        } catch (WriterException e) {
            throw new RuntimeException("Error. WriterIgnoreComment");
        }
    }
}
