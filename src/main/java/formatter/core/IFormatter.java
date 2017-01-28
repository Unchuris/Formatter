package formatter.core;

/**
 * Interface IFormatter.
 */
public interface IFormatter {
    /**
     *
     * format.
     * @param source source file.
     * @param destination output file.
     * @throws FormatterException exception.
     */
    void format(IReader<String> source,
                IWriter<String> destination) throws FormatterException;;
}
