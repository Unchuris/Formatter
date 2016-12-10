package formatter.formatterimplementation;

import formatter.actions.IAction;
import formatter.actions.Indent;
import formatter.lexem.IToken;
import formatter.lexem.Lexer;
import formatter.statemachine.IState;
import formatter.statemachine.TransitionTable;
import formatter.core.IFormatter;
import formatter.core.FormatterException;
import formatter.core.IReader;
import formatter.core.IWrite;

/**
 * Edited the text style.
 */
public final class Formatter implements IFormatter {

    //private IReader<Character> in;
    /**
     * Formatter.
     * @param source source file.
     * @param destination output file.
     * @param in source.
     * @throws FormatterException exception.
     */
//    public void format(final IReader source,
//                       final IWrite destination) throws FormatterException {
        public void format(final IReader<IToken> source,
                       final IWrite<String> destination,
                           final IReader<Character> in)
                throws FormatterException {
        try {
            //final int space = 4;
            Indent indent = new Indent();
            indent.indent(0);
            //indent.space(space);
            IAction action;
            IToken token;
            String lexeme;
            TransitionTable currentState = new TransitionTable(indent);
            IState current = currentState.start();
            Lexer l = new Lexer(in);
            IToken lexer = null;
            //IToken lexer = l.start();
            while (source.hasChars()) {
                token = source.readChar(lexer);
                lexeme = token.getLexeme(lexer);
                lexer = l.getNextStateToken(lexeme, lexer);
                action  = current.getAction(lexeme, current);
                action.action(destination, lexeme, indent);
                current = currentState.getNextState(lexeme, current);
            }
            destination.close();
        } catch (Exception e) {
            throw new FormatterException(e);
        }
    }
}
