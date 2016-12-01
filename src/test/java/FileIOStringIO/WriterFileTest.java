package FileIOStringIO;

import formatter.Actions.IAction;
import formatter.Actions.WriterSymbol;
import formatter.Core.*;
import formatter.FileIO.ReaderFile;
import formatter.FileIO.WriterFile;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
/**
 * Writer.
 */
public class WriterFileTest {

    private WriterFile writer;
    private ReaderFile reader;
    @Before
    public void setUp() throws IOException, WriterException, ReaderFileNotFoundException {
        writer = new WriterFile("src/test/java/Test");
        reader = new ReaderFile("src/test/java/Test");
    }
    @Test
    public void writeOneCharTest() throws WriterException, ReaderException {
        writer.writeChar('q');
        writer.close();
        assertEquals('q', reader.readChar());
    }
    @Test
    public void writeCharTest() throws WriterException, ReaderException {
        writer.writeChar("}}");
        char c = reader.readChar();
        char b = reader.readChar();
        String a = "" + c + b;
        assertEquals("}}", a);
    }
    @Test(expected = WriterException.class)
    public void writeExceptionTest() throws WriterException, ReaderException {
        writer.close();
        writer.writeChar(';');
    }
    @Test(expected = WriterFileNotFoundException.class)
    public void TestFileNotFoundException() throws WriterFileNotFoundException {
        writer = new WriterFile("/");
    }
}
