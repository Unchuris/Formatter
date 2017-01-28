package formatter.actions;

/**
 * Write.
 */
class WriterIndentSpaces implements IAction {
    /**
     * indent.
     */
    private Indent indent;
    /**
     *
     * @param i indent.
     */
    WriterIndentSpaces(final Indent i) {
        this.indent = i;
    }

    /**
     *
     * @param symbol symbol.
     * @return String;
     */
    public final String execute(final String symbol) {
            String ind = "";
            for (int i = 0; i < indent.getIndent(); i++) {
                for (int j = 0; j < indent.getSpaces(); j++) {
                    ind = " " + ind;
                }
            }
        return symbol + "\n" + ind;
    }
}
