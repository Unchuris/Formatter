package com;

import com.Core.FormatterException;
import com.Core.IReader;
import com.Core.IWrite;
import com.Core.ReaderFileNotFoundException;
import com.FileIO.ReaderFile;
import com.FileIO.WriterFile;
import com.FormatterImplementation.Formatter;

import java.io.IOException;
/**
 * Simplest com.FormatterImplementation.Formatter implementation.
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
