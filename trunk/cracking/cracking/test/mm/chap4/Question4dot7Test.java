package mm.chap4;


import junit.framework.TestCase;
import mm.ds.BinaryTree;

/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question4dot7Test extends TestCase {

    public void testisSubtreeTrueForSmallerTree() {
        int[] d1 = {2, 8, 24, 12, 6, 8, 10, 4, 16, 18, 14};
        BinaryTree t1 = new Question4dot3().createMinimalBT(d1);

        int[] d2 = {8, 12, 6, 4, 16, 18, 14};
        BinaryTree t2 = new Question4dot3().createMinimalBT(d2);
        
        assertTrue(new Question4dot7().isSubtree(t1.getRoot(),t2.getRoot()));
    }

    public void testisSubtreeTrueForIdenticalTrees() {
        int[] d1 = {2, 8, 24, 12, 6, 8, 10, 4, 16, 18, 14};

        BinaryTree t1 = new Question4dot3().createMinimalBT(d1);
        BinaryTree t2 = new Question4dot3().createMinimalBT(d1);
        
        assertTrue(new Question4dot7().isSubtree(t1.getRoot(),t2.getRoot()));
    }

    public void testisSubtreeTrueForSingleNodeT2() {
        int[] d1 = {2, 8, 24, 12, 6, 8, 10, 4, 16, 18, 14};
        BinaryTree t1 = new Question4dot3().createMinimalBT(d1);

        BinaryTree t2 = new Question4dot3().createMinimalBT(new int[]{12});
        
        assertTrue(new Question4dot7().isSubtree(t1.getRoot(),t2.getRoot()));
    }

    public void testisSubtreeFails() {
        int[] d1 = {2, 8, 24, 12, 6, 8, 10, 4, 16, 18, 14};
        BinaryTree t1 = new Question4dot3().createMinimalBT(d1);

        int[] d3 = {9, 12, 6};
        BinaryTree t3 = new Question4dot3().createMinimalBT(d3);

        assertFalse(new Question4dot7().isSubtree(t1.getRoot(),t3.getRoot()));
        
    }
}
