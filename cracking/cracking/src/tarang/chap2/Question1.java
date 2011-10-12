package tarang.chap2;

import tarang.datastructures.LinkedList;
import tarang.datastructures.Node;

import java.util.HashMap;
import java.util.Map;


/**
 * Write code to remove duplicates from an unsorted linked list. How would you solve this problem if a temporary buffer
 * is not allowed?
 *
 * @author tdesai
 */
public class Question1 {

    // using a temporary buffer O(n)
    public static void removeDuplicates(LinkedList list) {
        Map<Integer, Boolean> buffer = new HashMap<Integer, Boolean>();
        Node curr = list.getHead();
        Node next;
        while (curr.getNext() != null) {
            next = curr.getNext();
            if(buffer.get(next.getValue()) != null) {
                // already seen it, so delete
                curr.setNext(next.getNext());
            } else {
                buffer.put(next.getValue(), true);
                curr = curr.getNext();
            }
        }
    }

    // without a temporary buffer O(n^2), another option is to sort the list but that is no allowed according to the
    // question
    public static void removeDuplicates2(LinkedList list) {
        Node curr = list.getHead().getNext();
        if(curr == null || curr.getNext() == null) {
            return; // 0 or 1 nodes in the list so no duplicates
        }
        Node curr2;
        Node prev;
        while(curr != null) {
            curr2 = curr.getNext();
            prev = curr;
            while(curr2 != null) {
                // check and see if curr and curr2 values are the same, if they are then delete curr2
                if(curr.getValue().equals(curr2.getValue())) {
                    prev.setNext(curr2.getNext());
                }
                prev = curr2;
                curr2 = curr2.getNext();
            }
            curr = curr.getNext();
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(3);
        list.add(29);
        list.add(3);
        list.add(12);
        list.add(29);
        list.add(29);
        list.add(23);
        list.add(34);
        list.add(3);

        list.print();
        Question1.removeDuplicates(list);
        list.print();

        list = new LinkedList();
        list.add(3);
        list.add(29);
        list.add(3);
        list.add(12);
        list.add(29);
        list.add(29);
        list.add(23);
        list.add(34);
        list.add(3);

        list.print();
        Question1.removeDuplicates2(list);
        list.print();
    }

}
