package tarang.datastructures;


/**
 * Node in a stack
 *
 * @author tdesai
 */
public class StackNode {
    private int value;
    private StackNode next;

    StackNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value + ":" + next;
    }
}
