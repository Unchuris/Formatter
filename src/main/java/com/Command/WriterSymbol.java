package com.Command;

import com.Core.IReader;
import com.Core.IWrite;
import com.Core.WriterException;

/**
 * Whiter symbol.
 */
class WriterSymbol implements ICommand {
    /**
     * symbol.
     */
    private final char symbol;

    /**
     *  write.
     * @param criteria symbol.
     */
    WriterSymbol(final char criteria) {
        this.symbol = criteria;
    }

    /**
     * execute.
     * @param source source file.
     * @param destination output file.
     */
    public final void execute(final IReader source, final IWrite destination) {
        try {
            destination.writeChar(symbol);
        } catch (WriterException e) {
            throw new RuntimeException("Error. WriterIgnoreComment");
        }
    }
}
