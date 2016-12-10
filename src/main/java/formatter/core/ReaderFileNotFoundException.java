package formatter.core;

import java.io.FileNotFoundException;

/**
 * Exception.
 */
public class ReaderFileNotFoundException extends Throwable {
    /**
     *
     * @param message message.
     * @param error error.
     */
    public ReaderFileNotFoundException(final String message,
                                       final FileNotFoundException error) {
        super(message, error);
    }
}
