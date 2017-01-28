package formatter.actions;

/**
 * Indent.
 */
public class Indent {
    /**
     * indent.
     */
    private int indent = 0;

    /**
     *
     * @param c indent.
     */
    public final void indent(final int c) {
        this.indent = c;
    }

    /**
     * increment.
     */
    final void incIndent() {
        indent++;
    }

    /**
     * decrement.
     */
    final void decIndent() {
        indent--;
        if (indent < 0) {
            indent = 0;
        }
    }

    /**
     *
     * @return get.
     */
    final int getIndent() {
        return indent;
    }

    /**
     *
     * @return space.
     */
    final int getSpaces() {
        return 4;
    }
}
