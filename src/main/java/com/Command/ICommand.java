package com.Command;


import com.Core.IReader;
import com.Core.IWrite;

/**
 * ICommand.
 */
public interface ICommand {
    /**
     * execute.
     * @param source source file.
     * @param destination output file.
     */
     void execute(IReader source, IWrite destination);
}
