package formatter.Core;

/**
 * Exception.
 */
public class FormatterException extends Exception {
//    /**
//     * Formatter.
//     */
//    public FormatterException() {
//
//    }

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

//    /**
//     *
//     * @param message message.
//     * @param error error.
//     */
//    public FormatterException(final String message, final Throwable error) {
//        super(message, error);
//    }
}
