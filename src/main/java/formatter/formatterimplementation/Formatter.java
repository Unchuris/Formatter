package formatter.formatterimplementation;

import formatter.actions.IAction;
import formatter.statemachine.IState;
import formatter.statemachine.TransitionTable;
import formatter.core.IFormatter;
import formatter.core.FormatterException;
import formatter.core.IReader;
import formatter.core.IWriter;

/**
 * Edited the text style.
 */
public final class Formatter implements IFormatter {
    /**
     * transitionTable.
     */
    private TransitionTable transitionTable;

    /**
     *
     * @param transition transition.
     */
    public Formatter(final TransitionTable transition) {
        this.transitionTable = transition;
    }

    /**
     * Formatter.
     * @param source source file.
     * @param destination output file.
     * @throws FormatterException exception.
     */
        public void format(final IReader<String> source,
                           final IWriter<String> destination)
                throws FormatterException {
        try {
            IState currentState = transitionTable.getInitializationState();
            while (source.hasChars()) {
                String lexeme = source.readLexeme();
                IAction action = currentState.getAction(lexeme,
                        currentState);
                String string = action.execute(lexeme);
                destination.writeChar(string);
                currentState = transitionTable.getNextState(lexeme,
                        currentState);
            }
        } catch (Exception e) {
            throw new FormatterException(e);
        }
    }
}
