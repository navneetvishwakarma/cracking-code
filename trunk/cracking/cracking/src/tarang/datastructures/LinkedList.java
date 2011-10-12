package tarang.datastructures;


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

    public int remove() {
        int val = -1;
        if(head.getNext() == null) {
            throw new IllegalArgumentException("No more free nodes left");
        } else {
            val = head.getNext().getValue();
            head.setNext(head.getNext().getNext());
        }
        return val;
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

