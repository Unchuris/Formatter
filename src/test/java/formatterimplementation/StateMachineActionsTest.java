package formatterimplementation;

import formatter.core.*;
import formatter.formatterimplementation.Formatter;
import formatter.lexem.IToken;
import formatter.lexem.Lexer;
import formatter.stringio.StringReader;
import formatter.stringio.StringWriter;
import org.junit.Before;
import org.junit.Test;

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
        IReader<Character> source = new StringReader("{/*;{}sd;//\n;ds*/;}");
        IWrite<String> destination = new StringWriter();
        IReader<IToken> lexer = new Lexer(source);
        formatter.format(lexer, destination, null);
        assertEquals("{\n    /*;{}sd;//\n;ds*/;\n    }\n", destination.toString());
    }
    @Test
    public void testSlashReverse() throws FormatterException {
        IReader<Character> source = new StringReader("'{};\\{{\";}'{");
        IWrite<String> destination = new StringWriter();
        IReader<IToken> lexer = new Lexer(source);
        formatter.format(lexer, destination, null);
        assertEquals("'{};\\{{\";}'{\n    ", destination.toString());
    }
    @Test
    public void testSlashReverses() throws FormatterException {
        IReader<Character> source = new StringReader("'{};\\{{\";}'{");
        IWrite<String> destination = new StringWriter();
        IReader<IToken> lexer = new Lexer(source);
        formatter.format(lexer, destination, null);
        assertEquals("'{};\\{{\";}'{\n    ", destination.toString());
    }
    @Test
    public void testComment() throws FormatterException {
        IReader<Character> source = new StringReader("{//{};*/\n/{}");
        IWrite<String> destination = new StringWriter();
        IReader<IToken> lexer = new Lexer(source);
        formatter.format(lexer, destination, null);
        assertEquals("{\n    //{};*/\n/{\n        }\n    ", destination.toString());
    }

    @Test
    public void testBracket() throws FormatterException {
        IReader<Character> source = new StringReader("{{{;}");
        IWrite<String> destination = new StringWriter();
        IReader<IToken> lexer = new Lexer(source);
        formatter.format(lexer, destination, null);
        assertEquals("{\n    {\n        " +
                        "{\n            ;\n            }\n        ",
                destination.toString());
    }
    @Test
    public void testSpaceIndent() throws FormatterException {
        IReader<Character> source = new StringReader("}}}}}{");
        IWrite<String> destination = new StringWriter();
        IReader<IToken> lexer = new Lexer(source);
        formatter.format(lexer, destination, null);
        assertEquals("}\n}\n}\n}\n}\n{\n    ", destination.toString());
    }
    @Test
    public void testInserted() throws FormatterException {
        IReader<Character> source = new StringReader("/*d*///a\n{d}");
        IWrite<String> destination = new StringWriter();
        IReader<IToken> lexer = new Lexer(source);
        formatter.format(lexer, destination, null);
        assertEquals("/*d*///a\n{\n    d}\n", destination.toString());
    }
    @Test
    public void testChar() throws FormatterException {
        IReader<Character> source = new StringReader("{");
        IWrite<String> destination = new StringWriter();
        IReader<IToken> lexer = new Lexer(source);
        formatter.format(lexer, destination, null);
        assertEquals("{\n    ", destination.toString());
    }
    @Test
    public void testIgnore() throws FormatterException {
        IReader<Character> source = new StringReader("/*;{}sd;//\n;ds*/}");
        IWrite<String> destination = new StringWriter();
        IReader<IToken> lexer = new Lexer(source);
        formatter.format(lexer, destination, null);
        assertEquals("/*;{}sd;//\n;ds*/}\n", destination.toString());
    }
    @Test
    public void testSemicolon() throws FormatterException {
        IReader<Character> source = new StringReader("{}};{}d");
        IWrite<String> destination = new StringWriter();
        IReader<IToken> lexer = new Lexer(source);
        formatter.format(lexer, destination, null);
        assertEquals("{\n    }\n}\n;\n{\n    }\nd", destination.toString());
    }
    @Test
    public void testIgnoreL() throws FormatterException {
        IReader<Character> source = new StringReader("'{}\"{};;'{");
        IWrite<String> destination = new StringWriter();
        IReader<IToken> lexer = new Lexer(source);
        formatter.format(lexer, destination, null);
        assertEquals("'{}\"{};;'{\n    ", destination.toString());
    }
    @Test
    public void testIgnoreInserted() throws FormatterException {
        IReader<Character> source = new StringReader("//d*/;{}\n");
        IWrite<String> destination = new StringWriter();
        IReader<IToken> lexer = new Lexer(source);
        formatter.format(lexer, destination, null);
        assertEquals("//d*/;{}\n", destination.toString());
    }
    @Test
    public void testMulti() throws FormatterException {
        IReader<Character> source = new StringReader("a/*sd/{};");
        IWrite<String> destination = new StringWriter();
        IReader<IToken> lexer = new Lexer(source);
        formatter.format(lexer, destination, null);
        assertEquals("a/*sd/{};", destination.toString());
    }
    @Test
    public void testBracketOne() throws FormatterException {
        IReader<Character> source = new StringReader("{{}");
        IWrite<String> destination = new StringWriter();
        IReader<IToken> lexer = new Lexer(source);
        formatter.format(lexer, destination, null);
        assertEquals("{\n    {\n        }\n    ", destination.toString());
    }
    @Test
    public void testIg() throws FormatterException {
        IReader<Character> source = new StringReader("'{}{};\\'}{;;'{");
        IWrite<String> destination = new StringWriter();
        IReader<IToken> lexer = new Lexer(source);
        formatter.format(lexer, destination, null);
        assertEquals("'{}{};\\'}{;;'{\n    ", destination.toString());
    }
//    @Test
//    public void  testFileIgnoreLiterals() throws IOException, FormatterException, WriterException, ReaderFileNotFoundException, ReaderException {
//        IReader<Character> source = new ReaderFile("src/main/resources/input");
//        IWrite<String> destination = new WriterFile("src/main/resources/output");
//        IReader<IToken> lexer = new Lexer(source);
//        formatter.format(lexer, destination, null);
//        source.close();
//        destination.close();
//        Reader rez = new RFile("src/test/java/rez");
//        Reader output = new RFile("src/main/resources/output");
//        assertEquals(rez.toString(), output.toString());
//    }
}
