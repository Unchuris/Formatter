package com.Command;

import com.Core.IReader;
import com.Core.IWrite;
import com.Core.WriterException;

/**
 * symbol processing ';'.
 */
class Semicolon implements ICommand {
    /**
     *
     * @param source source file.
     * @param destination output file.
     */
    public void execute(final IReader source, final IWrite destination) {
        try {
            destination.writeChar(';');
            destination.writeChar('\n');
            for (int i = 0; i < Indent.indent; i++) {
                destination.writeChar(' ');
                destination.writeChar(' ');
                destination.writeChar(' ');
                destination.writeChar(' ');
            }
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}