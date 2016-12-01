package formatter.Actions;

/**
 * Indent.
 */
public class Indent {
    /**
     * indent.
     */
    private int indent = 0;
    /**
     * spaces.
     */
    private  int spaces = 0;

    /**
     *
     * @param space space.
     */
    public final void space(final int space) {
        this.spaces = space;
    }

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
    public final int getIndent() {
        return indent;
    }

    /**
     *
     * @return space.
     */
    final int getSpaces() {
        return spaces;
    }

}
