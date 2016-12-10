package formatter.core;

import java.io.IOException;

/**
 * Exception.
 */
public class WriterFileNotFoundException extends IOException {
    /**
     *
     * @param message message.
     */
    public WriterFileNotFoundException(final String message) {
        super(message);
    }
}
