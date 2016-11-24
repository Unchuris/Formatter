package com.Command;

import com.Core.IReader;
import com.Core.IWrite;
import com.Core.WriterException;

/**
 * symbol processing ';'.
 */
class Semicolon implements ICommand {
    /**
     * indent.
     */
    private final int indent;

    /**
     *
     * @param indent indent.
     */
    Semicolon(final int indent) {
        this.indent = indent;
    }
    /**
     *
     * @param source source file.
     * @param destination output file.
     */
    public void execute(final IReader source, final IWrite destination) {
        try {
            destination.writeChar(';');
            destination.writeChar('\n');
            for (int i = 0; i < indent; i++) {
                destination.writeChar(' ');
                destination.writeChar(' ');
                destination.writeChar(' ');
                destination.writeChar(' ');
            }
        } catch (WriterException e) {
            throw new RuntimeException("Error. WriterIgnoreComment");
        }
    }
}
