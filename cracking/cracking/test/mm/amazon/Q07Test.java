package mm.amazon;

import junit.framework.TestCase;
import mm.ds.BinaryTree;
import mm.chap4.Question4dot3;

import java.util.Map;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Q07Test extends TestCase {

    public void testMaxPath(){
        //int[] a = {-3, 6, 0, 2, 3, 1, 4, 0, 4, 5, -9, 0, 1, 11, 10};
        int[] a = new int[]{-5, 4, -4, 1, -1, -2, 2, -3, 1};
        BinaryTree bTree = new Question4dot3().createMinimalBT(new int[]{-2,1,-3,4,-1,2,1,-5,-4});

        Map<String,Object> resultMap = new Q07().maxPath(bTree);
        assertEquals("sum not equal",19,resultMap.get("sum"));
        assertEquals("path not equal","3459",resultMap.get("path"));
    }
}
