package formatter.Core;

/**
 * Interface to write.
 */
public interface IWrite {
    /**
     * write char.
     * @param c writeChar.
     * @throws WriterException exception.
     */
    void writeChar(char c) throws WriterException;

    /**
     *
     * @param c symbol.
     * @throws WriterException exception.
     */
    void writeChar(String c)throws WriterException;
    /**
     * close.
     * @throws WriterException exception.
     */
    void close() throws WriterException;
}
