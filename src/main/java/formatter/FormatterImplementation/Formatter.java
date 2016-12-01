package formatter.FormatterImplementation;

import formatter.Actions.Indent;
import formatter.StateMachine.ICommand;
import formatter.StateMachine.State;
import formatter.Core.IFormatter;
import formatter.Core.FormatterException;
import formatter.Core.IReader;
import formatter.Core.IWrite;

/**
 * Edited the text style.
 */
public final class Formatter implements IFormatter {

    /**
     * Formatter.
     * @param source source file.
     * @param destination output file.
     * @throws FormatterException exception.
     */
    public void format(final IReader source,
                       final IWrite destination) throws FormatterException {
        try {
            final int space = 4;
            char symbol;
            Indent indent = new Indent();
            indent.indent(0);
            indent.space(space);
            State currentState = new State(indent);
            ICommand command = currentState.start();
            while (source.hasChars()) {
                symbol = source.readChar();
                command = currentState.getNextState(symbol, command);
                command.execute(destination, symbol);
            }
            destination.close();
        } catch (Exception e) {
            throw new FormatterException(e);
        }
    }
}
