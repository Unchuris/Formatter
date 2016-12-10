package formatter.core;

import formatter.lexem.IToken;

/**
 * Interface IFormatter.
 */
public interface IFormatter {
    /**
     *
     * format.
     * @param source source .
     * @param destination output file.
     * @param lexer source file.
     * @throws FormatterException exception.
     */
    void format(IReader<IToken> lexer, IWrite<String> destination,
                IReader<Character> source) throws FormatterException;;
}
