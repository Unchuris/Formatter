package StateMachine;

import formatter.Actions.IAction;
import formatter.Actions.WriterSymbol;
import formatter.Core.*;
import formatter.FileIO.ReaderFile;
import formatter.FileIO.WriterFile;
import formatter.FormatterImplementation.Formatter;
import formatter.StringIO.StringReader;
import formatter.StringIO.StringWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

/**
 * string.
 */
public class StateMachineActionsTest {
    /**
     * formatter.
     */
    private IFormatter formatter;

    @Before
    public void setUp() {
        formatter = new Formatter();
    }
    @Test
    public void testMultiComment() throws FormatterException {
        IReader source = new StringReader("{/*;{}sd;//\n;ds*/f");
        IWrite destination = new StringWriter();
        formatter.format(source, destination);
        assertEquals("{\n    /*;{}sd;//\n;ds*/f", destination.toString());
    }
    @Test
    public void testSlashReverse() throws FormatterException {
        IReader source = new StringReader("'{};\\{{\";}'");
        IWrite destination = new StringWriter();
        formatter.format(source, destination);
        assertEquals("'{};\\{{\";}'", destination.toString());
    }
    @Test
    public void testComment() throws FormatterException {
        IReader source = new StringReader("{//{};*/\n/{}");
        IWrite destination = new StringWriter();
        formatter.format(source, destination);
        assertEquals("{\n    //{};*/\n/{\n        }\n    ", destination.toString());
    }

    @Test
    public void testBracket() throws FormatterException {
        IReader source = new StringReader("{{{;}");
        IWrite destination = new StringWriter();
        formatter.format(source, destination);
        assertEquals("{\n    {\n        " +
                        "{\n            ;\n            }\n        ",
                destination.toString());
    }
    @Test
    public void testSpaceIndent() throws FormatterException {
        IReader source = new StringReader("}}}}}{");
        IWrite destination = new StringWriter();
        formatter.format(source, destination);
        assertEquals("}\n}\n}\n}\n}\n{\n    ", destination.toString());
    }
    @Test
    public void testInserted() throws FormatterException {
        IReader source = new StringReader("/*d*///a\n{d}");
        IWrite destination = new StringWriter();
        formatter.format(source, destination);
        assertEquals("/*d*///a\n{\n    d}\n", destination.toString());
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
    public void testSemicolon() throws FormatterException {
        IReader source = new StringReader("{}};{}d");
        IWrite destination = new StringWriter();
        formatter.format(source, destination);
        assertEquals("{\n    }\n}\n;\n{\n    }\nd", destination.toString());
    }
    @Test
    public void testIgnoreL() throws FormatterException {
        IReader source = new StringReader("'{}\"{};;'{");
        IWrite destination = new StringWriter();
        formatter.format(source, destination);
        assertEquals("'{}\"{};;'{\n    ", destination.toString());
    }
    @Test
    public void testIgnoreInserted() throws FormatterException {
        IReader source = new StringReader("//d*/;{}\n");
        IWrite destination = new StringWriter();
        formatter.format(source, destination);
        assertEquals("//d*/;{}\n", destination.toString());
    }
    @Test
    public void testMulti() throws FormatterException {
        IReader source = new StringReader("a/*sd/{};");
        IWrite destination = new StringWriter();
        formatter.format(source, destination);
        assertEquals("a/*sd/{};", destination.toString());
    }
    @Test
    public void testBracketOne() throws FormatterException {
        IReader source = new StringReader("{{}");
        IWrite destination = new StringWriter();
        formatter.format(source, destination);
        assertEquals("{\n    {\n        }\n    ", destination.toString());
    }
    @Test
    public void  testFileIgnoreLiterals() throws IOException, FormatterException, WriterException, ReaderFileNotFoundException, ReaderException {
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
