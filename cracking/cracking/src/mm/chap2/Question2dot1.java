package mm.chap2;

import mm.ds.LinkedList;
import mm.ds.Node;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;



/**
 * Write code to remove duplicates from an unsorted linked list
 * How would you solve this problem if a temporary buffer is not allowed?
 *
 * @author mmathuria
 */
public class Question2dot1 {

    public LinkedList removeDups2(LinkedList list){
        if(list == null || list.head == null){
            return null;
        }

        Set<Integer> set = new HashSet<Integer>();
        Node current = list.head.next;
        Node prev = list.head;
        set.add(prev.iData);
        while(current != null){
            if (!set.contains(current.iData)) {
                set.add(current.iData);
                prev.next = current;
                prev = current;
            }
            current = current.next();
        }
        prev.next = null;
        return list;
    }


    public LinkedList removeDups(LinkedList list){
        if(list == null || list.head == null){
            return null;
        }

        Set<Integer> set = new HashSet<Integer>();
        Node current = list.head.next;
        Node prev = list.head;
        set.add(prev.iData);
        while(current != null){
            if(set.contains(current.iData)){
                prev.next = current.next;
            }else{
                set.add(current.iData);
                prev = current;
            }
            current = current.next;
        }
        prev.next = null;
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
        if(list == null || list.head == null){
            return null;
        }

        Node prev = list.head;
        Node current = prev.next;
        while(current != null){
            if (!doesCurrentExists(list.head,prev, current)) {
                prev.next = current;
                prev = current;
            }
            current = current.next();
        }
        prev.next = null;
        return list;
    }

    private boolean doesCurrentExists(Node head, Node end, Node n){
        Node current = head;
        while(current.iData != end.iData){
            if(current.iData == n.iData){
                return true;
            }
            current = current.next;
        }
        return current.iData == n.iData;
    }
}
