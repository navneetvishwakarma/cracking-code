package tarang.chap2;

import tarang.datastructures.LinkedList;
import tarang.datastructures.Node;


/**
 * Given a circular linked list, implement an algorithm which returns node at the beginning of the loop DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node�s next pointer points to an earlier node, so as to make
 * a loop in the linked list EXAMPLE input: A -> B -> C -> D -> E -> C [the same C as earlier] output: C
 *
 * @author tdesai
 */
public class Question5 {

    public static Node findBeginning(LinkedList circular) {
        // use the tortoise and hare algorithm
        if (circular == null || circular.getHead().getNext() == null) {
            return null; // no nodes in the LL
        }
        Node tort = circular.getHead().getNext();
        Node hare = tort.getNext();
        while (tort != hare) {
            tort = tort.getNext();
            hare = hare.getNext().getNext();
        }

        // both are the same, now put one back to the head
        tort = circular.getHead();
        while (tort != hare) {
            tort = tort.getNext();
            hare = hare.getNext();
        }
        // tort and hare are the beginning of the loop
        return tort; // or hare
    }


    public static void main(String[] args) {
        // create 1 -> 2 -> 3 -> 4 -> 5 -> 3
        LinkedList list = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node3);

        list.add(node1);

        System.out.println("1 -> 2 -> 3 -> 4 -> 5 -> 3 beginning: " + Question5.findBeginning(list));
    }
}
