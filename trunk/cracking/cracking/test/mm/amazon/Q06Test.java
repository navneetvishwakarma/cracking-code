package mm.amazon;


import junit.framework.TestCase;
import mm.ds.BinaryTree;

import java.util.ArrayList;

/**
 * Put class JavaDoc here
 */
public class Q06Test extends TestCase {
    Q06 testObj = new Q06();
    
    public void testCountNodesAtEachLevel(){

        BinaryTree tree = Q03_BT.createFromInOrder(new int[]{3,4,5,6,7,9,17,20,22});
        ArrayList<Integer> output = new ArrayList<Integer>();
        testObj.countNodesAtEachLevel(tree.getRoot(),0,output);
        
        assertNotNull("output is null",output);
        assertEquals("", new Integer(1), output.get(0));
        assertEquals("", new Integer(2), output.get(1));
        assertEquals("",new Integer(3),output.get(2));
        assertEquals("",new Integer(3),output.get(3));

        System.out.println(new ArrayList<Integer>().size());
    }

    public void testCountNodesAtEachLevelEmptyTree(){
        
        BinaryTree tree = new BinaryTree();
        ArrayList<Integer> output = new ArrayList<Integer>();
        testObj.countNodesAtEachLevel(tree.getRoot(),0,output);
        
        assertNotNull("output is null", output);
        assertTrue("output is not empty",output.isEmpty());
    }
    
    public void testCountNodesBelow(){

        BinaryTree tree = Q03_BT.createFromInOrder(new int[]{3, 4, 5, 6, 7, 9, 17, 20, 22});
        ArrayList<Integer> output = new ArrayList<Integer>();
        int count = testObj.countNodesBelowGiven(tree.getRoot().leftChild);

        assertNotNull("output is null", output);
        assertEquals("count does not match",3,count-1);
    }
    
    
}
