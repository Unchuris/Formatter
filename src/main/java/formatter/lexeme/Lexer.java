package formatter.lexeme;

import formatter.core.IReader;
import formatter.core.ReaderException;

import java.io.IOException;

/**
 * Lexer.
 */
public class Lexer implements IReader<String> {
    /**
     * IReader Character.
     */
    private IReader<Character> source;
    /**
     * StringBuilder.
     */
    private StringBuilder lexeme;
    /**
     * state.
     */
    private State state;
    /**
     * StateLexerMap.
     */
    private StateLexerMap stateLexerMap;

    /**
     * @param in source.
     *
     */
    public Lexer(final IReader<Character> in) {
        this.source = in;
        stateLexerMap = new StateLexerMap();
        state = stateLexerMap.getInitializationState();
        lexeme = new StringBuilder();
        lexerBuilder = new LexerBuilder(lexeme);
    }
    /**
     * LexerBuilder.
     */
    private LexerBuilder lexerBuilder;
    /**
     *
     * @return boolean.
     * @throws ReaderException ex.
     */
    public final boolean hasChars() throws ReaderException {
//        if (!source.hasChars() && check) {
//            check = false;
//            return true;
//        }
       return source.hasChars() || !lexerBuilder.toString().equals("");
    }

    /**
     *
     * @return String.
     * @throws ReaderException Exception.
     */
    public final String readLexeme() throws ReaderException {
        IActionLexer action;
        char c;
        String lexemeString;
        lexemeString = lexerBuilder.toString();
        lexeme.delete(0, lexeme.length());
        if (state.equals(new State("return"))) {
            lexerBuilder.returnToken();
            state = stateLexerMap.getInitializationState();
            return lexemeString;
        }
        while (source.hasChars()) {
            c = source.readLexeme();
            action = state.getAction(c, state);
            action.execute(lexerBuilder, c);
            state = stateLexerMap.getNextState(c, state);
            if (action.returnToken()) {
                return lexerBuilder.getString();
            }
        }
        lexerBuilder.returnToken();
        return lexerBuilder.getString();
    }
    /**
     *
     * @throws IOException Exception.
     * @throws ReaderException Exception.
     */
    public final void close() throws IOException, ReaderException {
        source.close();
    }
}
