package formatter.actions;

/**
 * symbol processing '}'.
 */
public class ClosingBracket implements IAction {
    /**
     * indent.
     */
    private Indent indent;

    /**
     *
     * @param ind indent.
     */
    public ClosingBracket(final Indent ind) {
        this.indent = ind;
    }

    /**
     *
     * @param symbol symbol.
     * @return String;
     */
    public final String execute(final String symbol) {
        indent.decIndent();
        IAction write = new WriterIndentSpaces(indent);
        return write.execute(symbol);
    }
}
