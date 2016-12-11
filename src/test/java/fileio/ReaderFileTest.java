package fileio;

import formatter.core.IReader;
import formatter.core.ReaderException;
import formatter.core.ReaderFileNotFoundException;
import formatter.fileio.ReaderFile;
import formatter.stringio.StringReader;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

/**
 * test.
 */
public class ReaderFileTest {

    private IReader reader;
    private BufferedReader read;
    @Before
    public void setUp() throws ReaderFileNotFoundException, FileNotFoundException {
        reader = new ReaderFile("src/main/resources/input");
        read = new BufferedReader(new FileReader("src/main/resources/input"));
    }
    @Test
    public void hasCharsTest() throws ReaderException, FileNotFoundException {
        boolean a = reader.hasChars();
        assertEquals(true, a);
    }
    @Test
    public void closeTest() throws IOException, ReaderException {
        IReader source = new StringReader("{}");
        source.close();
    }
    @Test
    public void TestReadChar() throws IOException, ReaderException {
        assertEquals(reader.readChar(null, null), (char) read.read());
    }
    @Test(expected = ReaderFileNotFoundException.class)
    public void TestFileNotFoundException() throws ReaderFileNotFoundException {
        reader = new ReaderFile("///");
    }
    @Test(expected = ReaderException.class)
    public void writeExceptionTest() throws ReaderException, IOException {
        reader.close();
        reader.readChar(null, null);
    }
}
