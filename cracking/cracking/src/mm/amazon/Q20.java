package mm.amazon;


import mm.ds.LinkedList;
import mm.ds.Node;

/**
 * Input linkedlist : 1->9->3->8->5->7->7. Odd indexed are increasin and even indexed are descreasing.
 * Output: Ordered linked list
 */
public class Q20 {
    public static void orderLinkedList(LinkedList list){
        Node head = list.head;
        
        if(head == null || head.next == null){
            System.out.println("List empty or single element");
        }
        
        //first get the tail
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        
        Node prev = head;
        Node current = prev.next;
        while (prev != tail && current != tail){
            //delete
            prev.next = current.next;

            //insert at the end
            current.next = tail.next;
            tail.next = current;

            //update current,prev
            current = prev.next.next;
            prev = prev.next;
        }
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1).append(9).append(3).append(8).append(5).append(7).append(7);
        orderLinkedList(list);

        LinkedList list2 = new LinkedList();
        list2.append(1).append(9).append(3).append(8).append(5).append(7);
        orderLinkedList(list2);

        LinkedList list3 = new LinkedList();
        list3.append(1).append(9).append(3);
        orderLinkedList(list3);
    }
    
}
