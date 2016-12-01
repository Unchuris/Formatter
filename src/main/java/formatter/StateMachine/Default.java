package formatter.StateMachine;

import formatter.Actions.ClosingBracket;
import formatter.Actions.IAction;
import formatter.Actions.OpeningBracket;
import formatter.Actions.Semicolon;
import formatter.Actions.Indent;
import formatter.Actions.WriterSymbol;
import formatter.Core.IWrite;

import java.util.HashMap;

/**
 * DefaultState.
 */
class Default implements ICommand {
    /**
     * indent.
     */
    private Indent indent;
    /**
     * HashMap.
     */
    private HashMap<Character, IAction> hashMap;

    /**
     * Default.
     * @param ind indent.
     */
    Default(final Indent ind) {
        hashMap = new HashMap<Character, IAction>();
        hashMap.put('{', new OpeningBracket());
        hashMap.put('}', new ClosingBracket());
        hashMap.put(';', new Semicolon());
        this.indent = ind;
    }

    /**
     * execute.
     * @param destination output file.
     * @param symbol symbol.
     */
    public void execute(final IWrite destination, final char symbol) {
        IAction write = new WriterSymbol();
        if (hashMap.containsKey(symbol)) {
            hashMap.get(symbol).action(destination, symbol, indent);
        } else {
            write.action(destination, symbol, null);
        }
    }
}
