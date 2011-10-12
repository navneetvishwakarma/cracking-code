package tarang.datastructures;


/**
 * LinkedList node
 *
 * @author tdesai
 */
public class Node {
    private Integer value;
    private Node next;

    public Node() {
    }

    public Node(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
