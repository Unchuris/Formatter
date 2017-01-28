package formatter;

import formatter.actions.Indent;
import formatter.core.FormatterException;
import formatter.core.IReader;
import formatter.core.IWriter;
import formatter.core.ReaderFileNotFoundException;
import formatter.fileio.ReaderFile;
import formatter.fileio.WriterFile;
import formatter.formatterimplementation.Formatter;
import formatter.lexeme.Lexer;
import formatter.statemachine.TransitionTable;

import java.io.IOException;
/**
 * Simplest Formatter implementation.
 */
public final class Main {
    /**
     * default constructor.
     */
    private Main() {
        throw new RuntimeException();
     }

     /**
     * Entry method.
     * @param args filenames.
     * @throws FormatterException exception.
     * @throws MainException exception.
     */
     public static void main(final String[] args)
             throws FormatterException, MainException {
         if (args.length == 2) {
             try {
                 TransitionTable transitionTable = new TransitionTable();
                 Formatter formatter = new Formatter(transitionTable);
                 IReader<Character> source =
                    new ReaderFile(args[0]);
                 IWriter<String> destination =
                         new WriterFile(args[1]);
                 IReader<String> lexer = new Lexer(source);
                 formatter.format(lexer, destination);
                 Indent indent = new Indent();
                 indent.indent(0);
             } catch (IOException e) {
                 throw new FormatterException("File is error");
             } catch (ReaderFileNotFoundException e) {
                 throw new MainException("Error", e);
             }
         }
     }
}
