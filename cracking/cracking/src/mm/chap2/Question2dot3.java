package mm.chap2;


import mm.ds.Node;

/**
 Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node
   EXAMPLE
   Input: the node ‘c’ from the linked list a->b->c->d->e
   Result: nothing is returned, but the new linked list looks like a->b->d->e
 * @author mmathuria
 */
public class Question2dot3 {
    
    public boolean deleteNode(Node n){
        if(n.next == null){
            return false;   //cannot delete the last node
        } else {
            n.data = n.next.data;
            n.next = n.next.next;
        }
        return true;
    }
}
