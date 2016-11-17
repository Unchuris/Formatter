package toString;

import com.Core.*;
import com.FileIO.ReaderFile;
import com.FileIO.WriterFile;
import com.FormatterImplementation.Formatter;
import com.StringIO.StringReader;
import com.StringIO.StringWriter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

/**
 * Test for com.FormatterImplementation.Formatter.
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
