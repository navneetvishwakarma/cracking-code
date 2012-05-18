package mm.chap2;

import mm.ds.LinkedList;
import mm.ds.Node;


/**
 * Implement an algorithm to find the nth to last element of a singly linked list
 *
 * @author mmathuria
 */
public class Question2dot2 {
    
    public Node nthToLast(LinkedList list, int n){
        if(list.head == null){
            throw new IllegalArgumentException("list cannot be null");
        }
        
        Node p = list.head;
        Node c = list.head;
        for(int i=1;i<n;i++){
            c = c.next;
            if(c == null){
                throw new IllegalArgumentException("n cannt be more than list size");
            }
        }
        
        while(c.next != null){
            p = p.next;
            c = c.next;
        }
        
        return p;
    }


}
