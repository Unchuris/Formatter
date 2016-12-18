package formatterimplementation;

import formatter.actions.IAction;
import formatter.actions.WriterSymbol;
import formatter.actions.WriterIndentSpaces;
import formatter.core.FormatterException;
import formatter.core.ReaderFileNotFoundException;
import formatter.core.WriterException;
import formatter.fileio.WriterFile;
import formatter.formatterimplementation.Formatter;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Exception.
 */
public class ExceptionTest {

    private WriterFile writer;

    @Before
    public void setUp() throws IOException, WriterException, ReaderFileNotFoundException {
        writer = new WriterFile("src/test/java/Test");
        //ReaderFile reader = new ReaderFile("src/test/java/Test");
    }

    @Test(expected = RuntimeException.class)
    public void WriteSymbolTest() throws WriterException {
        IAction s = new WriterSymbol();
        writer.close();
        s.action(writer, "{", null);
    }
    @Test(expected = RuntimeException.class)
    public void WriterIndentSpaces() throws WriterException {
        IAction s = new WriterIndentSpaces();
        writer.close();
        s.action(writer, "{", null);
    }
    @Test(expected = FormatterException.class)
    public void FormatterExceptionTest() throws FormatterException {
        Formatter f = new Formatter();
        f.format(null, null, null);
    }
}
