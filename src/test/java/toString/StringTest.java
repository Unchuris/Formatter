package toString;

import com.Core.*;
import com.FormatterImplementation.Formatter;
import com.StringIO.StringReader;
import com.StringIO.StringWriter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertEquals;

/**
 * string.
 */
public class StringTest {
    private IFormatter formatter;

    @Before
    public void setUp() {
        formatter = new Formatter();
    }
    @Test
    public void test() throws FormatterException {
        IReader source = new StringReader("/*d*///a\n{d");
        IWrite destination = new StringWriter();
        formatter.format(source, destination);
        assertEquals("/*d*///a\n{\n    d", destination.toString());
    }
    @Test
    public void testChar() throws FormatterException {
        IReader source = new StringReader("1");
        IWrite destination = new StringWriter();
        formatter.format(source, destination);
        assertEquals("1", destination.toString());
    }
    @Test
    public void testIgnore() throws FormatterException {
        IReader source = new StringReader("/*;{}sd;//\n;ds*/f");
        IWrite destination = new StringWriter();
        formatter.format(source, destination);
        assertEquals("/*;{}sd;//\n;ds*/f", destination.toString());
    }
    @Test
    public void testT() throws FormatterException {     //performed
        IReader source = new StringReader("{}};{}");
        IWrite destination = new StringWriter();
        formatter.format(source, destination);
        assertEquals("{\n    }\n}\n;\n{\n    }\n", destination.toString());
    }
    @Test
    public void testL() throws FormatterException {
        IReader source = new StringReader("\"{}{};;\"");
        IWrite destination = new StringWriter();
        formatter.format(source, destination);
        assertEquals("\"{}{};;\"", destination.toString());
    }
    @Test
    public void testI() throws FormatterException {
        IReader source = new StringReader("//d*/;{}\n");
        IWrite destination = new StringWriter();
        formatter.format(source, destination);
        assertEquals("//d*/;{}\n", destination.toString());
    }

    @Test
    public void ExceptionFormatter() throws ReaderException, FormatterException {
        IReader source = Mockito.mock(IReader.class);
        Mockito.when(source.readChar()).thenReturn('\n');
        formatter.format(source, null);
    }
}
