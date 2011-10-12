package tarang.chap2;

import tarang.datastructures.LinkedList;
import tarang.datastructures.Node;


/**
 * Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node
 * EXAMPLE
 * Input: the node �c� from the linked list a->b->c->d->e
 * Result: nothing is returned, but the new linked list looks like a->b->d->e
 *
 * @author tdesai
 */
public class Question3 {


    public static void delete(Node node) {
        // move data from next node to the current node and delete next
        if(node == null) {
            return;
        }
        if(node.getNext() == null) {
            node = null;
            return;
        }
        // next node is not null
        Node nextNode = node.getNext();
        node.setValue(nextNode.getValue());
        // delete next node;
        node.setNext(nextNode.getNext());
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(3);
        list.add(29);
        Node node = list.add(9);
        list.add(4);
        list.add(32);

        list.print();

        System.out.println("Delete 9 ...");
        Question3.delete(node);

        list.print();
    }
}
