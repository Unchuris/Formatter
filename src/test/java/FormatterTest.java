import com.*;
import org.junit.Before;
import org.junit.Test;
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

        IReader source = new StringReader("src/main/resources/input");
        IWrite destination = new StringWriter("src/main/resources/output");

        formatter.format(source, destination);

        source.close();
        destination.close();

        IReader rez = new StringReader("src/test/java/rez");
        IReader output = new StringReader("src/main/resources/output");

        assertEquals(rez.toString(), output.toString());
    }
}

