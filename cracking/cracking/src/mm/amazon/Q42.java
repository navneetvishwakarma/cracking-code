package mm.amazon;


import mm.ds.LinkedList;
import mm.ds.Node;

/**
 * Merge 2 sorted linked lists
 */
public class Q42 {
    
    Node mergeSortedLinkedLists(Node a, Node b){
        if(a == null && b == null){
            throw new IllegalArgumentException("Input cannot be null");
        }
        
        if(a == null) return b;
        if(b == null) return a;
        
        Node c = new Node(-1);  //dummy node to act as placeholder for the new head
        Node head = c;
        
        while(a != null && b != null){
            if(a.iData < b.iData){
                c.next = a;
                c = a;
                a = a.next;
            }else if(b.iData < a.iData){
                c.next = b;
                c = b;
                b = b.next;
            }
        }
        
        c.next = (a == null) ? b : a;
        return head.next;
    }

    public static void main(String[] args) {
        Q42 obj = new Q42();
        test1(obj);
        test2(obj);
    }

    private static void test1(Q42 obj) {
        LinkedList list1 = new LinkedList();
        list1.append(new Node(5)).append(new Node(10)).append(new Node(15));

        LinkedList list2 = new LinkedList();
        list2.append(new Node(2)).append(new Node(3)).append(new Node(20)).append(new Node(21));

        Node result = obj.mergeSortedLinkedLists(list1.head(), list2.head());
        printResult(result);
    }

    private static void test2(Q42 obj) {
        LinkedList list1 = new LinkedList();
        list1.append(new Node(5)).append(new Node(10)).append(new Node(15));

        Node result = obj.mergeSortedLinkedLists(list1.head(), null);
        printResult(result);
    }

    private static void printResult(Node result) {
        while(result != null){
            System.out.print(result.iData);
            result = result.next;
            if(result == null) break;
            System.out.print("-->");
        }
        System.out.println();
    }

}
