package formatter.core;

/**
 * Interface to write.
 * @param <T> t.
 */
public interface IWrite<T> {
//    /**
//     * write char.
//     * @param c writeChar.
//     * @throws WriterException exception.
//     */
//    void writeChar(char c) throws WriterException;

    /**
     *
     * @param c symbol.
     * @throws WriterException exception.
     */
    //void writeChar(String c) throws WriterException;
    void writeChar(T c) throws WriterException;
    /**
     * close.
     * @throws WriterException exception.
     */
    void close() throws WriterException;
}