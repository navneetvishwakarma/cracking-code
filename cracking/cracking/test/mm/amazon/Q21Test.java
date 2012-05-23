package mm.amazon;


import junit.framework.TestCase;
import mm.ds.BinaryTree;

/**
 * Put class JavaDoc here
 */
public class Q21Test extends TestCase {
    
    public void testIsSame(){
        BinaryTree tree1 = tree1();
        BinaryTree tree2 = tree1();
        
        assertTrue("incorrect result",new Q21().isSame(tree1.getRoot(),tree2.getRoot()));
    }

    public void testIsNotSame(){
        BinaryTree tree1 = tree1();
        BinaryTree tree2 = tree2();

        assertFalse("incorrect result",new Q21().isSame(tree1.getRoot(),tree2.getRoot()));

    }

    private BinaryTree tree1(){
        int[] data = {12,24,8,14,22,32,6,10,26,40};

        BinaryTree tree = new BinaryTree(16);

        for(int i : data){
            tree.insert(i);
        }

        return tree;
    }

    private BinaryTree tree2(){
        int[] data = {12,24,8,14,22,32,7,10,26,40};

        BinaryTree tree = new BinaryTree(16);

        for(int i : data){
            tree.insert(i);
        }

        return tree;
    }

}
