package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by vlad on 19.10.16.
 */
public class Formatter {

    public void format(BufferedReader source, BufferedWriter destination) {
        try {
            int indent = 0;
            int symbol;
            while ((symbol = source.read()) != -1) {
                switch (symbol) {
                    case '{':
                        destination.write(symbol);
                        destination.write("\n");
                        indent++;
                        for (int i = 0; i < indent; i++) {
                            destination.write("    ");
                        }
                        break;
                    case ';':
                        destination.write(symbol);
                        destination.write('\n');
                        for (int i = 0; i < indent; i++) {
                            destination.write("    ");
                        }
                        break;
                    case '}':
                        destination.write(symbol);
                        destination.write("\n");
                        indent--;
                        for (int i = 0; i < indent; i++) {
                            destination.write("    ");
                        }
                        break;
                    default:
                        destination.write(symbol);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
