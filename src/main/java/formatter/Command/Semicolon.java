package formatter.Command;

import formatter.Core.IReader;
import formatter.Core.IWrite;
import formatter.Core.WriterException;

/**
 * symbol processing ';'.
 */
class Semicolon implements ICommand {
    /**
     * execute.
     * @param source source file.
     * @param destination output file.
     * @param indent indent.
     * @param check check.
     */
    public void execute(final IReader source,
                         final IWrite destination,
                         final int indent, final boolean check) {
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
