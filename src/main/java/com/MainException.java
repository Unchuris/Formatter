package com;

import com.Core.ReaderFileNotFoundException;

/**
 * Exception.
 */
public class MainException extends Throwable {
    /**
     *
     * @param massage massage.
     * @param error error.
     */
    MainException(final String massage,
                  final ReaderFileNotFoundException error) {
        super(massage, error);
    }
}