package mm.amazon;

import junit.framework.TestCase;
import mm.BinaryTree;

import java.util.Map;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Q07Test extends TestCase {

    public void testMaxPath(){
        int[] a = {-3, 6, 0, 2, 3, 1, 4, 0, 4, 5, -9, 0, 1, 11, 10};
        BinaryTree bTree = Q03_BT.createFromPreOrder(a);

        Map<String,Object> resultMap = new Q07().maxPath(bTree);
        assertEquals("sum not equal",19,resultMap.get("sum"));
        assertEquals("path not equal","3459",resultMap.get("path"));
    }
}
