package formatter.FormatterImplementation;

import formatter.Command.CommandFactory;
import formatter.Command.ICommand;
import formatter.Core.IFormatter;
import formatter.Core.FormatterException;
import formatter.Core.IReader;
import formatter.Core.IWrite;

/**
 * Edited the text style.
 */
public final class Formatter implements IFormatter {

    /**
     *
     * @param source source file.
     * @param destination output file.
     * @throws FormatterException exception.
     */
        public void format(final IReader source,
                           final IWrite destination)
                throws FormatterException {
            FormatterState currentState = new FormatterState();
            boolean check = true;
            int indent = 0;
            char previous = 0;
            char symbol;
            try {
                if (source.hasChars()) {
                    symbol = source.readChar();
                    indent = currentState.getNextState(indent, symbol);
                    ICommand command =
                            CommandFactory.getCommand(previous,
                                    symbol);
                    assert command != null;
                    command.execute(source, destination, indent, true);
                    previous = symbol;
                    while (source.hasChars()) {
                        symbol = source.readChar();
                        indent = currentState.getNextState(indent, symbol);
                        command = CommandFactory.getCommand(previous,
                                symbol);
                        assert command != null;
                        command.execute(source, destination, indent, check);
                        check = currentState.getCheck(previous, symbol, check);
                        previous = symbol;
                    }
                }
                destination.close();
            } catch (Exception e) {
               throw new FormatterException(e);
            }
            }
}
