package FileIO;

import formatter.Core.IReader;
import formatter.Core.ReaderException;
import formatter.Core.ReaderFileNotFoundException;
import formatter.FileIO.ReaderFile;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static junit.framework.TestCase.assertEquals;

/**
 * test.
 */
public class ReaderFileTest {

    private IReader reader;

    @Before
    public void setUp() throws ReaderFileNotFoundException {
        reader = new ReaderFile("src/main/resources/input");
    }
    @Test
    public void hasCharsTest() throws ReaderException, FileNotFoundException {
        boolean a = reader.hasChars();
        assertEquals(true, a);
    }
//    private IReader read = Mockito.mock(ReaderFile.class);
//    @Test(expected = ReaderException.class)
//    public void test() throws ReaderFileNotFoundException {
//        read = new ReaderFile("qq");
//    }
//    @Test
//    public void close() throws ReaderException {
//        try {
//            read.close();
//        } catch (IOException e) {
//            throw  new ReaderException("Can't close the file.");
//        }
//    }
}
