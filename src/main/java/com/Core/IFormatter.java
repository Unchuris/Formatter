package com.Core;

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
    void format(IReader source, IWrite destination) throws FormatterException;
}
