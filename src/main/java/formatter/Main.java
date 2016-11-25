package formatter;

import formatter.Core.FormatterException;
import formatter.Core.IReader;
import formatter.Core.IWrite;
import formatter.Core.ReaderFileNotFoundException;
import formatter.FileIO.ReaderFile;
import formatter.FileIO.WriterFile;
import formatter.FormatterImplementation.Formatter;

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
                 IReader source;
                 source = new
                         ReaderFile(args[0]);
                 IWrite destination = new
                         WriterFile(args[1]);
                 formatter.format(source, destination);
             } catch (IOException e) {
                 throw new FormatterException("File is error");
             } catch (ReaderFileNotFoundException e) {
                 throw new MainException("Error", e);
             }
         }
     }
    }
