package mm.chap2;

import mm.LinkedList;
import mm.Node;

import java.util.HashSet;
import java.util.Set;


/**
 * Write code to remove duplicates from an unsorted linked list
 * How would you solve this problem if a temporary buffer is not allowed?
 *
 * @author mmathuria
 */
public class Question2dot1 {
    
    public LinkedList removeDups(LinkedList list){
        if(list == null){
            throw new IllegalArgumentException("list cannot be null");
        }
        
        if(list.head.next == null){
            return list;
        }

        Set<Node> set = new HashSet<Node>();
        Node p = list.head;
        Node n = p.next();
        set.add(p);
        
        while(n != null){
            while(set.contains(n)){
                n = n.next();
            }
            
            if(n == null ){
                p.next = null;
                break;
            }

            set.add(n);
            p.next = n;
            p = n;
            n = n.next();
        }
        
        return list;
    }


    /**
     * Something like this:
     * We iterate with two pointers: “current” does a normal iteration, while “runner” iterates through all prior nodes 
     * to check for dups
     * @param list
     * @return
     */
    public LinkedList removeDupsNoMem(LinkedList list){
        if (list == null) {
            throw new IllegalArgumentException("list cannot be null");
        }

        if (list.head.next == null) {
            return list;
        }

        Node p = list.head;
        Node n = p.next();
        
        while(n != null){
            if(!isPresent(p,n, list.head)){
                p.next = n;
                p = n;
            }
            n = n.next;
        }
        p.next = null;
        return list;
    }
    
    
    private boolean isPresent(Node end, Node n, Node head){
        Node c = head;
        while(true){
            if(c.iData == n.iData){
                return true;
            }
            
            if(c == end){
                return false;
            }
            
            c = c.next;
        }
    }
}
