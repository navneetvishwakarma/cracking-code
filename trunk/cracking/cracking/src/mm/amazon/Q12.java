package mm.amazon;

import mm.ds.LinkedList;
import mm.ds.Node;


/**
 * Reverse linked list (both, singly and doubly)
 *
 * @author mmathuria
 */
public class Q12 {
    
   public LinkedList reverseSLL(LinkedList list){
       if(list.head() == null){
           throw new IllegalArgumentException("list cannot be null");
       }

       Node a = null;
       Node b = list.head;
       Node c = b.next;
       
       while(b != null){
           b.next = a;
           a = b;
           b = c;
           if(c != null) c = c.next;
       }
       list.head = a;
       
       return list;
   } 
    
    public LinkedList reverseDLL(LinkedList list){
        if(list == null){
            throw new IllegalArgumentException("list cannot be null");
        }
        
        //one element list
        if(list.head.next() == null){
            return list;
        }
        
        
        Node a = list.head;
        Node b = a.next;
        Node c = b.next;
        a.next = null;
        
        while(c != null){
            a.prev = b;
            b.next = a;
            a = b;
            b = c;
            c = c.next;
        }
        a.prev = b;
        b.next = a;
        list.head = b;
        return list;                
    }
    
    private void doReverseSLL(Q12 q12) {
        LinkedList singlyLL = new LinkedList();
        singlyLL.append(new Node(2));
        singlyLL.append(new Node(4));
        singlyLL.append(new Node(10));
        singlyLL.append(new Node(8));

        System.out.println(singlyLL.toString());
        q12.reverseSLL(singlyLL);
        System.out.println(singlyLL.toString());

        //single node
        singlyLL = new LinkedList();
        singlyLL.append(new Node(1));
        System.out.println(singlyLL.toString());
        q12.reverseSLL(singlyLL);
        System.out.println(singlyLL.toString());
    }
    
    
    private void doReverseDLL(Q12 q12){
        LinkedList doublyLL = new LinkedList();
        doublyLL.appendDLL(new Node(2));
        doublyLL.appendDLL(new Node(4));
        doublyLL.appendDLL(new Node(10));
        doublyLL.appendDLL(new Node(8));

        System.out.println(doublyLL.toString());
        q12.reverseDLL(doublyLL);
        System.out.println(doublyLL.toString());
    }
    
    public static void main(String[] args) {
        Q12 q12 = new Q12();
        System.out.println("Singly");
        q12.doReverseSLL(q12);
        System.out.println("\nDoubly");
        q12.doReverseDLL(q12);
    }

    public LinkedList reverseSLL2(LinkedList list){
        if(list.head() == null){
            throw new IllegalArgumentException("list cannot be null");
        }

        //if the list has only one element
        if(list.head().next() == null){
            return list;
        }


        Node a = list.head();
        Node b = a.next();
        Node c = b.next();
        a.next = null;

        while(c != null){
            b.next = a;
            a = b;
            b = c;
            c = b.next();
        }
        b.next = a;
        list.head = b;

        return list;
    }

}
