package formatter;

import formatter.core.FormatterException;
import formatter.core.IReader;
import formatter.core.IWrite;
import formatter.core.ReaderFileNotFoundException;
import formatter.fileio.ReaderFile;
import formatter.fileio.WriterFile;
import formatter.formatterimplementation.Formatter;
import formatter.lexem.IToken;
import formatter.lexem.Lexer;

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
                 Formatter formatter = new Formatter();
                 IReader<Character> source =
                    new ReaderFile(args[0]);
                 IWrite<String> destination =
                         new WriterFile(args[1]);
                 IReader<IToken> lexer = new Lexer(source);
                 formatter.format(lexer, destination, source);
             } catch (IOException e) {
                 throw new FormatterException("File is error");
             } catch (ReaderFileNotFoundException e) {
                 throw new MainException("Error", e);
             }
         }
     }
    }
