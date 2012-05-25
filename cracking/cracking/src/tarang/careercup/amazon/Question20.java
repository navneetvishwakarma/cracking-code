package tarang.careercup.amazon;


import tarang.datastructures.Node;

/**
 * Input linkedlist : 1->9->3->8->5->7->7. Odd indexed are increasing and even indexed are decreasing.
 *
 * @author tdesai
 */
public class Question20 {


    public static Node straightenOut2(Node ll) {
        Node tail = null;
        Node curr = ll;
        while(curr != null) {
            tail = curr;
            curr = curr.getNext();
        }
        Node stop = tail;

        // every odd one, delete and append at tail
        curr = ll;
        Node prev = curr;
        int count = 0;
        while(curr != stop) {
            if(count % 2 == 1) {
                // increasing, append ahead of tail
                prev.setNext(curr.getNext());
                curr.setNext(tail.getNext());
                tail.setNext(curr);
                curr = prev;
            }
            prev = curr;
            curr = curr.getNext();
            count++;
        }
        return ll;
    }

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
        Node node = straightenOut2(new Node(1, 9, 3, 8, 5, 7, 7));
        System.out.print(node);
    }
}
