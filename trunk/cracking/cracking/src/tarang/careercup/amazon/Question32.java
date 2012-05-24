package tarang.careercup.amazon;


import tarang.datastructures.Node;

/**
 * Reverse a linkedlist
 *
 * @author tdesai
 */
public class Question32 {
    public static Node reverse(Node node) {
        if(node == null || node.getNext() == null) {
            return node;
        }
        Node curr = node;
        Node prev = null;
        while(curr != null) {
            Node temp = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        one.setNext(two);
        two.setNext(three);
        three.setNext(four);
        four.setNext(five);

        Node node = reverse(one);
        System.out.print(node);
    }
}
