package formatter.actions;


/**
 * symbol processing '{'.
 */
public class OpeningBracket implements IAction {
    /**
     * indent.
     */
    private Indent indent;
    /**
     *
     * @param ind indent.
     */
    public OpeningBracket(final Indent ind) {
        this.indent = ind;
    }

    /**
     *
     * @param symbol symbol.
     * @return String;
     */
    public final String execute(final String symbol) {
        indent.incIndent();
        IAction write = new WriterIndentSpaces(indent);
        return write.execute(symbol);
    }
}
