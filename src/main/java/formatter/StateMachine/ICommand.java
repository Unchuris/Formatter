package formatter.StateMachine;


import formatter.Core.IWrite;

/**
 * ICommand.
 */
public interface ICommand {
     /**
      * execute.
      * @param destination output file.
      * @param symbol symbol.
      */
     void execute(IWrite destination, char symbol);
}
