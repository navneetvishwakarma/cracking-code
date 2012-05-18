package mm.chap2;


import junit.framework.TestCase;
import mm.ds.LinkedList;
import mm.ds.Node;

/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question2dot3Test extends TestCase {
    Question2dot3 testObj = new Question2dot3();
    
    public void testDeleteNonLastNode(){
        LinkedList list = new LinkedList();
        Node nodeToBeDeleted = new Node('C');
        list.append(new Node('A')).append(new Node('B')).append(nodeToBeDeleted).append(new Node('D'));
        
        int originalListSize = list.count();
        assertTrue(testObj.deleteNode(nodeToBeDeleted));
        assertEquals("list size does not match",(originalListSize-1),list.count());
    }
    
    public void testDeleteLastNode(){
        LinkedList list = new LinkedList();
        Node nodeToBeDeleted = new Node('D');
        list.append(new Node('A')).append(new Node('B')).append(new Node('C')).append(nodeToBeDeleted);

        int originalListSize = list.count();
        assertFalse("did not return false",testObj.deleteNode(nodeToBeDeleted));
        assertEquals("list size does not match",originalListSize,list.count());
    }
}
