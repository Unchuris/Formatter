package com.Core;
/**
 * Exception.
 */
public class WriterException extends Exception {
    /**
     * Writer.
     */
    public WriterException() {

    }
    /**
     * @param message string.
     */
    public WriterException(final String message) {
        super(message);
    }

    /**
     *
     * @param error error.
     */
    public WriterException(final Throwable error) {
        super(error);
    }

    /**
     *
     * @param message message.
     * @param error error.
     */
    public WriterException(final String message, final Throwable error) {
        super(message, error);
    }
}
