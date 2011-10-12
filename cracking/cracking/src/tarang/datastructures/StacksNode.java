package tarang.datastructures;


/**
 * Node in a stack
 *
 * @author tdesai
 */
public class StacksNode {
    private int value;
    private int next = -1;

    StacksNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value + ":" + next;
    }
}
