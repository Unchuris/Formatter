package formatter.Command;


import formatter.Core.IReader;
import formatter.Core.IWrite;

/**
 * ICommand.
 */
public interface ICommand {
    /**
     *
     * @param source file.
     * @param destination file.
     * @param indent indent.
     * @param check check.
     */
     void execute(IReader source, IWrite destination,
                  int indent, boolean check);
}
