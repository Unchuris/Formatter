package formatter;

import formatter.core.*;
import formatter.fileio.ReaderFile;
import formatter.fileio.WriterFile;
import formatter.formatterimplementation.Formatter;
import formatter.lexeme.Lexer;
import formatter.statemachine.TransitionTable;
import formatter.stringio.StringReader;
import formatter.stringio.StringWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

/**
 * string.
 */
public class FormatterTest {
    /**
     * formatter.
     */
    private IFormatter formatter;

    private TransitionTable transitionTable = new TransitionTable();

    @Before
    public void setUp() {
        formatter = new Formatter(transitionTable);

    }
    @Test
    public void testLine() throws FormatterException {
        IReader<Character> source = new StringReader("     Start{\n\n\n\n\n\n\n\n\n\n");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals(" Start{\n    \n", destination.toString());
    }
    @Test
    public void testMultiComment() throws FormatterException {
        IReader<Character> source = new StringReader("{/*; {}sd;//; */;}");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("{\n    /*; {}sd;//; */;\n    }\n", destination.toString());
    }
    @Test
    public void testOne() throws FormatterException {
        IReader<Character> source = new StringReader("/");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("/", destination.toString());
    }
    @Test
    public void testOne1() throws FormatterException {
        IReader<Character> source = new StringReader("{");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("{\n    ", destination.toString());
    }
    @Test
    public void testOne2() throws FormatterException {
        IReader<Character> source = new StringReader("/*              ");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("/*  ", destination.toString());
    }
    @Test
    public void testSlashReverse() throws FormatterException {
        IReader<Character> source = new StringReader("'{};\\{{\";}'{");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("'{};\\{{\";}'{\n    ", destination.toString());
    }
    @Test
    public void testSlashReverses() throws FormatterException {
        IReader<Character> source = new StringReader("'{};\\{{\";}'{");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("'{};\\{{\";}'{\n    ", destination.toString());
    }
    @Test
    public void testComment() throws FormatterException {
        IReader<Character> source = new StringReader("{//{};*//{}");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("{\n    //{};*//{}", destination.toString());
    }

    @Test
    public void testBracket() throws FormatterException {
        IReader<Character> source = new StringReader("{{{;}");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("{\n    {\n        " +
                        "{\n            ;\n            }\n        ",
                destination.toString());
    }
    @Test
    public void testSpaceIndent() throws FormatterException {
        IReader<Character> source = new StringReader("}}}}}{");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("}\n}\n}\n}\n}\n{\n    ", destination.toString());
    }
    @Test
    public void testInserted() throws FormatterException {
        IReader<Character> source = new StringReader("/*{}{}*///a{d");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("/*{}{}*///a{d", destination.toString());
    }
    @Test
    public void testChar() throws FormatterException {
        IReader<Character> source = new StringReader("d");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("d", destination.toString());
    }
    @Test
    public void testIgnore() throws FormatterException {
        IReader<Character> source = new StringReader("/*;{}sd;//;ds*/}");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("/*;{}sd;//;ds*/}", destination.toString());
    }
    @Test
    public void testSemicolon() throws FormatterException {
        IReader<Character> source = new StringReader("{}};{}d");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("{\n    }\n}\n;\n{\n    }\nd", destination.toString());
    }
    @Test
    public void testIgnoreL() throws FormatterException {
        IReader<Character> source = new StringReader("'{}\"{};;'{");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("'{}\"{};;'{\n    ", destination.toString());
    }
    @Test
    public void testIgnoreInserted() throws FormatterException {
        IReader<Character> source = new StringReader("//d*/;{}\n\n\n\n\n\n");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("//d*/;{}\n", destination.toString());
    }
    @Test
    public void testMulti() throws FormatterException {
        IReader<Character> source = new StringReader("/*{}sd/{};");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("/*{}sd/{};", destination.toString());
    }
    @Test
    public void testBracketOne() throws FormatterException {
        IReader<Character> source = new StringReader("{{}");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("{\n    {\n        }\n    ", destination.toString());
    }
    @Test
    public void testIg() throws FormatterException {
        IReader<Character> source = new StringReader("'{}{};\\'}{;;'{");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("'{}{};\\'}{;;'{\n    ", destination.toString());
    }
    @Test
    public void testFor() throws FormatterException {
        IReader<Character> source = new StringReader("for (;) \n\n\n\n\n\n");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("for (;) \n", destination.toString());
    }
    @Test
    public void testForBracket() throws FormatterException {
        IReader<Character> source = new StringReader(" for (;) {");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals(" for (;) {\n    ", destination.toString());
    }
    @Test
    public void testSpace() throws FormatterException {
        IReader<Character> source = new StringReader("    word  op  {   }; word      T");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals(" word op {\n     }\n;\n word T", destination.toString());
    }
    @Test
    public void testComments() throws FormatterException {
        IReader<Character> source = new StringReader("/*{test;;;*//{");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("/*{test;;;*//{\n    ", destination.toString());
    }
    @Test
    public void testWord() throws FormatterException {
        IReader<Character> source = new StringReader("*{test;");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("*{\n    test;\n    ", destination.toString());
    }
    @Test
    public void testWord2() throws FormatterException {
        IReader<Character> source = new StringReader("/\'{}");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("/\'{}", destination.toString());
    }
    @Test
    public void testComment2() throws FormatterException {
        IReader<Character> source = new StringReader("//;;;;;;*/{");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("//;;;;;;*/{", destination.toString());
    }
    @Test
    public void testComment3() throws FormatterException {
        IReader<Character> source = new StringReader("/*{}{/*{*/;");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("/*{}{/*{*/;\n", destination.toString());
    }
    @Test
    public void testIgnore1() throws FormatterException {
        IReader<Character> source = new StringReader("\';{}{}\";\"{{{{\'{");
        IWriter<String> destination = new StringWriter();
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        assertEquals("\';{}{}\";\"{{{{\'{\n    ", destination.toString());
    }
    @Test
    public void  testFileIgnoreLiterals() throws IOException, FormatterException, WriterException, ReaderFileNotFoundException, ReaderException {
        IReader<Character> source = new ReaderFile("src/main/resources/input");
        IWriter<String> destination = new WriterFile("src/main/resources/output");
        IReader<String> lexer = new Lexer(source);
        formatter.format(lexer, destination);
        source.close();
        destination.close();
        Reader rez = new RFile("src/test/java/rez");
        Reader output = new RFile("src/main/resources/output");
        assertEquals(rez.toString(), output.toString());
    }
    @Test
    public void testClose() throws IOException, ReaderException {
        IReader<Character> source = new StringReader("    word  op  {   }; word      T");
        IReader<String> lexer = new Lexer(source);
        lexer.close();
    }
}
