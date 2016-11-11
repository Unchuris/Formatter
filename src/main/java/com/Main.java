package com;

import java.io.IOException;
/**
 * Simplest com.Formatter implementation.
 */
public final class Main {
    /**
     * default constructor.
     */
    private Main() {

     }

     /**
     * Entry method.
     * @param args filenames.
     * @throws IOException exception.
     */
     public static void main(final String[] args)
             throws IOException {
        try {
                Formatter formatter = new Formatter();
                IReader source = new
                        ReadFile("src/main/resources/input");
                IWrite destination = new
                        WriterFile("src/main/resources/output");
                formatter.format(source, destination);
                destination.close();
            } catch (IOException e) {
                e.printStackTrace();
              }
        }
    }
