package formatter;


import formatter.core.FormatterException;
import formatter.formatterimplementation.Formatter;
import formatter.statemachine.TransitionTable;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Exception.
 */
public class ExceptionTest {

    //private WriterFile writer;

    private TransitionTable transitionTable = new TransitionTable();

//    @Before
//    public void setUp() throws IOException, WriterException, ReaderFileNotFoundException {
//        writer = new WriterFile("src/test/java/Test");
//        //ReaderFile reader = new ReaderFile("src/test/java/Test");
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void WriteSymbolTest() throws WriterException {
//        IAction s = new WriterSymbol();
//        writer.close();
//        s.execute(writer, "{");
//    }
//    @Test(expected = RuntimeException.class)
//    public void WriterIndentSpaces() throws WriterException {
//        IAction s = new WriterIndentSpaces(null);
//        writer.close();
//        s.execute(writer, "{");
//    }
    @Test(expected = FormatterException.class)
    public void FormatterExceptionTest() throws FormatterException {
        Formatter f = new Formatter(transitionTable);
        f.format(null, null);
    }
}
