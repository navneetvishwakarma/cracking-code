package tarang.careercup.amazon;


import tarang.datastructures.Node;

/**
 * Input linkedlist : 1->9->3->8->5->7->7. Odd indexed are increasin and even indexed are descreasing.
 *
 * @author tdesai
 */
public class Question20 {

    public static Node straightenOut(Node ll) {
        Node inc_tail = null;
        Node dec_tail = null;
        Node ll2 = null;
        Node curr = ll;
        int count = 0;
        while(curr != null) {
            if(++count % 2 == 1) {
                // increasing track
                if(inc_tail != null) {
                    inc_tail.setNext(curr);
                }
                inc_tail = curr;
            } else {
                // decreasing track
                if(dec_tail != null) {
                    dec_tail.setNext(curr);
                } else {
                    ll2 = curr;
                }
                dec_tail = curr;
            }
            curr = curr.getNext();
        }

        // reverse ll2
        Node prev = null;
        curr = ll2;
        while(curr != null) {
            Node temp = curr.getNext();
            if(prev != null) {
                curr.setNext(prev);
            } else {
                curr.setNext(null);
            }
            prev = curr;
            curr = temp;
        }
        return ll;
    }

    public static void main(String[] args) {
        straightenOut(new Node(1, 9, 3, 8, 5, 7, 7));
    }
}
