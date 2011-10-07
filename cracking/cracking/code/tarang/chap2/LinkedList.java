package cracking.code.tarang.chap2;


/**
 * My very own linkedlist
 *
 * @author tdesai
 */
public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = new Node();
    }

    public Node getHead() {
        return head;
    }

    public Node add(Node node) {
        if (node.getNext() == null) {
            node.setNext(head.getNext());
        }
        head.setNext(node);
        return node;
    }

    public Node add(Integer value) {
        Node node = new Node();
        node.setValue(value);
        return add(node);
    }

    private void print(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.getValue() + " -> ");
        print(node.getNext());
    }

    public void print() {
        print(this.head.getNext());
        System.out.println();
    }
}

class Node {
    private Integer value;
    private Node next;

    Node() {
    }

    Node(Integer value) {
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
