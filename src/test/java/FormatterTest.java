import com.*;
import com.exception.ExceptionFormatter;
import org.junit.Before;
import org.junit.Test;
import toString.Reader;
import toString.ReaderFile;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

/**
 * Test for com.Formatter.
 */
public class FormatterTest {

    private IFormatter formatter;

    @Before
    public void setUp() {
        formatter = new Formatter();
    }
    @Test
    public void  two() throws IOException {

        IReader source = new ReadFile("src/main/resources/input");
        IWrite destination = new WriterFile("src/main/resources/output");

        formatter.format(source, destination);

        source.close();
        destination.close();

        Reader rez = new ReaderFile("src/test/java/rez");
        Reader output = new ReaderFile("src/main/resources/output");

        assertEquals(rez.toString(), output.toString());
    }
}

