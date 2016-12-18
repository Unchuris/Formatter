package formatter.core;

import formatter.lexem.IToken;

/**
 * Interface IFormatter.
 */
public interface IFormatter {
    /**
     *
     * format.
     * @param source source file.
     * @param destination output file.
     * @param characterIReader IReader<Character>.
     * @throws FormatterException exception.
     */
    void format(IReader<IToken> source, IWrite<String> destination,
                IReader<Character> characterIReader) throws FormatterException;;
}
