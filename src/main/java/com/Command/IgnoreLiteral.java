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
     * Ignore.
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
        char previous = 0;
        try {
            destination.writeChar(symbol);
            if (source.hasChars()) {
                symbol = source.readChar();
                while ((c != symbol || previous == '\\') && source.hasChars()) {
                    destination.writeChar(symbol);
                    previous = symbol;
                    symbol = source.readChar();
                }
                destination.writeChar(symbol);
            }
        } catch (ReaderException e) {
            throw new RuntimeException("Error. ReaderIgnoreComment");
        } catch (WriterException e) {
            throw new RuntimeException("Error. WriterIgnoreComment");
        }
    }
}
