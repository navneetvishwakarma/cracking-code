package mm.chap2;

import junit.framework.TestCase;
import mm.ds.LinkedList;
import mm.ds.Node;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question2dot2Test extends TestCase {

    public void testNthToLast() {
        Question2dot2 obj = new Question2dot2();

        LinkedList list = new LinkedList();
        
        list.append(new Node(1)).append(new Node(2)).append(new Node(3)).append(new Node(4)).append(new Node(5));
        Node n = obj.nthToLast(list,2);
        assertEquals("node did not match",4,n.iData);

        n = obj.nthToLast(list,0);
        assertEquals("node did not match",5,n.iData);

        n = obj.nthToLast(list,1);
        assertEquals("node did not match",5,n.iData);

        n = obj.nthToLast(list,5);
        assertEquals("node did not match",1,n.iData);

        try {
            n = obj.nthToLast(list,6);
            fail("did not throw exception");
        } catch (Exception e) {
            //empty
        }

    }
}
