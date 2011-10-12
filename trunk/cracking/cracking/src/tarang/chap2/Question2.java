package tarang.chap2;

import tarang.datastructures.LinkedList;
import tarang.datastructures.Node;


/**
 * Implement an algorithm to find the nth to last element of a singly linked list
 *
 * @author tdesai
 */
public class Question2 {

    public static Integer nthLast(LinkedList list, int n) {
        Node next = list.getHead();
        int count = 1;
        while(count <= n && next != null) {
            next = next.getNext();
            count++;
        }
        if (next == null) {
            return null; // throw an error cause the list is too small
        }
        // now walk to the last node
        Node target = list.getHead();
        while(next != null) {
            target = target.getNext();
            next = next.getNext();
        }
        return target.getValue();
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(3);    // 8
        list.add(29);    // 7
        list.add(9);    // 6
        list.add(4);    // 5
        list.add(6);    // 4
        list.add(1);    // 3
        list.add(23);   // 2
        list.add(34);   // 1
        list.add(14);    // 0

        list.print();

        System.out.println("n=" + 5 + ": " + Question2.nthLast(list, 5));
        System.out.println("n=" + 3 + ": " + Question2.nthLast(list, 3));
        System.out.println("n=" + 10 + ": " + Question2.nthLast(list, 10));
        System.out.println("n=" + 9 + ": " + Question2.nthLast(list, 9));
    }
}
