package tarang.careercup.amazon;


import tarang.datastructures.Node;

/**
 * Reverse a linked list
 *
 * @author tdesai
 */
public class Question12 {

    public static Node reverse(Node root) {
        Node curr = root;
        Node temp;
        Node prev = null;
        while(curr != null) {
            temp = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node prev = null;
        Node node;
        Node root = null;
        for(int i = 1; i <= 5; i++) {
            node = new Node(i);
            if(i == 1) {
                root = node;
            }
            if(prev != null) {
                prev.setNext(node);
            }
            prev = node;
        }

        root = reverse(root);
    }
}
