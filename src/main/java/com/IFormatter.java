package com;

/**
 * interface IFormatter.
 */
public interface IFormatter {
    /**
     *
     * @param source source file.
     * @param destination output file.
     */
    void format(IReader source, IWrite destination);
}
