package com.Command;

import com.Core.IReader;
import com.Core.IWrite;
import com.Core.ReaderException;
import com.Core.WriterException;

/**
 * Ignore literal.
 */
class IgnoreLiteral implements ICommand {
    /**
     * c.
     */
    private char c;
    /**
     * symbol.
     */
    private char symbol;

    /**
     *
     * @param criteria symbol.
     * @param next next symbol.
     */
    IgnoreLiteral(final char criteria, final char next) {
        this.symbol = criteria;
        this.c = next;
    }

    /**
     * execute.
     * @param source source file.
     * @param destination output file.
     */
    public void execute(final IReader source, final IWrite destination) {
        try {
            destination.writeChar(symbol);
            destination.writeChar(c);
            while (c != symbol && source.hasChars()) {
                c = source.readChar();
                destination.writeChar(c);
            }
        } catch (ReaderException e) {
            e.printStackTrace();
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
