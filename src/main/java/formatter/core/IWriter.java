package formatter.core;

/**
 * Interface to write.
 * @param <T> t.
 */
public interface IWriter<T> {
//    /**
//     * write char.
//     * @param c writeChar.
//     * @throws WriterException exception.
//     */
//    void writeChar(char c) throws WriterException;
    //void writeChar(String c) throws WriterException;

    /**
     *
     * @param c symbol.
     * @throws WriterException exception.
     */
    void writeChar(T c) throws WriterException;

    /**
     * close.
     * @throws WriterException exception.
     */
    void close() throws WriterException;
}
