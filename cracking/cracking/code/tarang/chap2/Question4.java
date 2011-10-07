package cracking.code.tarang.chap2;


/**
 * You have two numbers represented by a linked list, where each node contains a sin- gle digit	The digits are stored
 * in reverse order, such that the 1Õs digit is at the head of the list	Write a function that adds the two numbers and
 * returns the sum as a linked list
 * EXAMPLE Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
 * Output: 8 -> 0 -> 8
 *
 * @author tdesai
 */
public class Question4 {

    public static LinkedList add(LinkedList list1, LinkedList list2) {
        if(list1 == null || list2 == null) {
            return null; // null plus anything is null
        }
        LinkedList result = new LinkedList();
        int carry = 0;
        int value;
        Node list1Node = list1.getHead().getNext();
        Node list2Node = list2.getHead().getNext();
        while(list1Node != null && list2Node != null) {
            // both lists have to be valid
            value  = list1Node.getValue() + list2Node.getValue() + carry;
            result.add(value % 10);
            carry = value > 9 ? 1 : 0;
            // advance the pointers
            list1Node = list1Node.getNext();
            list2Node = list2Node.getNext();
        }
        if(list1Node == null && list2Node == null) {
            // do nothing;
        } else if(list1Node == null) {
            while(list2Node != null) {
                value = list2Node.getValue() + carry;
                result.add(value);
                carry = value > 9 ? 1 : 0;
                list2Node = list2Node.getNext();
            }
        } else {
            while (list1Node != null) {
                value = list1Node.getValue() + carry;
                result.add(value);
                carry = value > 9 ? 1 : 0;
                list1Node = list1Node.getNext();
            }
        }
        if (carry == 1) {
            result.add(1);
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.add(6);
        list1.add(1);
        list1.add(3);
        LinkedList list2 = new LinkedList();
        list2.add(2);
        list2.add(9);
        list2.add(5);

        LinkedList result = Question4.add(list1, list2);
        list1.print();
        System.out.println("add");
        list2.print();
        System.out.println("equals");
        result.print();

        System.out.println();

        list1 = new LinkedList();
        list1.add(4);
        list1.add(1);
        list1.add(3);
        list1.add(3);
        list2 = new LinkedList();
        list2.add(2);
        list2.add(9);

        result = Question4.add(list1, list2);
        list1.print();
        System.out.println("add");
        list2.print();
        System.out.println("equals");
        result.print();
    }
}
