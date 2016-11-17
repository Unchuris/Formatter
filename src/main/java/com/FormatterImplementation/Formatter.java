package com.FormatterImplementation;

import com.Command.CommandFactory;
import com.Command.ICommand;
import com.Core.IFormatter;
import com.Core.FormatterException;
import com.Core.IReader;
import com.Core.IWrite;

/**
 * Edited the text style.
 */
public final class Formatter implements IFormatter {

    /**
     *
     * @param source source file.
     * @param destination output file.
     * @throws FormatterException exception.
     */
        public void format(final IReader source,
                           final IWrite destination)
                throws FormatterException {
            char previous = 0;
            char symbol = 0;
            try {
                if (source.hasChars()) {
                    previous = source.readChar();
                    while (source.hasChars()) {
                        symbol = source.readChar();
                        ICommand command =
                                CommandFactory.getCommand(previous, symbol);
                        assert command != null;
                        command.execute(source, destination);
                        previous = symbol;
                    }
                    ICommand command =
                            CommandFactory.getCommand(previous, '\'');
                    assert command != null;
                    command.execute(source, destination);
                }
                destination.close();
            } catch (Exception e) {
               throw new FormatterException(e);
            }
            }
    }
