package formatter.actions;


/**
 * symbol processing ';'.
 */
public class Semicolon implements IAction {
    /**
     * indent.
     */
    private Indent indent;
    /**
     *
     * @param ind indent.
     */
    public Semicolon(final Indent ind) {
        this.indent = ind;
    }

    /**
     *
     * @param symbol symbol.
     * @return String;
     */
    public final String execute(final String symbol) {
        IAction write = new WriterIndentSpaces(indent);
        return write.execute(symbol);
    }
}
