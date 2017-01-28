package formatter.core;

/**
 * Exception.
 */
public class FormatterException extends Exception {

    /**
     * @param message string.
     */
    public FormatterException(final String message) {
        super(message);
    }

    /**
     *
     * @param error error.
     */
    public FormatterException(final Throwable error) {
        super(error);
    }

}
