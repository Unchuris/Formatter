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
     * symbol.
     */
    private char symbol;

    /**
     *
     * @param criteria symbol.
     */
    IgnoreLiteral(final char criteria) {
        this.symbol = criteria;
    }

    /**
     * execute.
     * @param source source file.
     * @param destination output file.
     */
    public void execute(final IReader source, final IWrite destination) {
        char c = symbol;
        try {
            destination.writeChar(symbol);
            if (source.hasChars()) {
                symbol = source.readChar();
                while (c != symbol && source.hasChars()) {
                    destination.writeChar(symbol);
                    symbol = source.readChar();
                }
                destination.writeChar(symbol);
            }
        } catch (ReaderException e) {
            e.printStackTrace();
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
