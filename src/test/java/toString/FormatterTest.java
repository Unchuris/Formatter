package toString;

import formatter.Core.*;
import formatter.FileIO.ReaderFile;
import formatter.FileIO.WriterFile;
import formatter.FormatterImplementation.Formatter;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

/**
 * Test for Formatter.
 */
public class FormatterTest {

    private IFormatter formatter;

    @Before
    public void setUp() {
        formatter = new Formatter();
    }
    @Test
    public void  two() throws IOException, FormatterException, WriterException, ReaderFileNotFoundException, ReaderException {
            IReader source = new ReaderFile("src/main/resources/input");
            IWrite destination = new WriterFile("src/main/resources/output");

            formatter.format(source, destination);

            source.close();
            destination.close();

            Reader rez = new RFile("src/test/java/rez");
            Reader output = new RFile("src/main/resources/output");

            assertEquals(rez.toString(), output.toString());
    }
}
