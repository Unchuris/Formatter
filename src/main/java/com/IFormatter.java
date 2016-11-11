package com;

import com.exception.ExceptionFormatter;

/**
 * interface IFormatter.
 */
public interface IFormatter {
    /**
     *
     * @param source source file.
     * @param destination output file.
     * @throws ExceptionFormatter Exception.
     */
    void format(IReader source, IWrite destination) throws ExceptionFormatter;
}
