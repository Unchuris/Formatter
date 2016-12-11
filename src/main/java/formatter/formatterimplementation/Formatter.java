package formatter.formatterimplementation;

import formatter.actionlexer.IAct;
import formatter.actions.IAction;
import formatter.actions.Indent;
import formatter.lexem.IToken;
import formatter.lexem.Lexer;
import formatter.lexem.StoreSymbol;
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

    /**
     * Formatter.
     * @param source source file.
     * @param destination output file.
     * @param in source.
     * @throws FormatterException exception.
     */
        public void format(final IReader<IToken> source,
                       final IWrite<String> destination,
                           final IReader<Character> in)
                throws FormatterException {
        try {
            Indent indent = new Indent();
            indent.indent(0);
            StoreSymbol store = new StoreSymbol();
            store.string((char) 0);
            IAction action;
            IAct actionToken;
            char symbol;
            String lexeme;
            TransitionTable currentState = new TransitionTable(indent);
            IState current = currentState.start();
            Lexer lexer = new Lexer(in);
            IToken token = lexer.start();
            while (source.hasChars()) {
                symbol = source.readChar(store);
                actionToken = token.getAct(symbol, token);
                lexeme = actionToken.getLexeme(symbol, in, store);
                token = lexer.getNextStateToken(lexeme, token, symbol);
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
