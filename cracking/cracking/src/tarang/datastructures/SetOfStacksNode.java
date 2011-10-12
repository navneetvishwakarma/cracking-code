package tarang.datastructures;


/**
 * Node for a <code>SetOfStacks</code>
 *
 * @author tdesai
 */
public class SetOfStacksNode {
    private Stack stack;
    private SetOfStacksNode prev;

    SetOfStacksNode() {
        stack = new Stack();
    }

    public Stack getStack() {
        return stack;
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }

    public SetOfStacksNode getPrev() {
        return prev;
    }

    public void setPrev(SetOfStacksNode prev) {
        this.prev = prev;
    }
}
