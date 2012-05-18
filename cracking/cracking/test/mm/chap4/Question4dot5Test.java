package mm.chap4;


import junit.framework.TestCase;
import mm.ds.BinaryTree;
import mm.ds.TreeNode;

/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question4dot5Test extends TestCase {
    BinaryTree btree;
    
    private void init(){
        if(btree != null) return;
        
        btree = new BinaryTree();
        int[] data = {7, 3, 1, 0, 2, 5, 4, 6, 11, 9, 8, 10, 13, 12, 14};
        for(int i: data){
            btree.insert(i);
        }
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        init();
    }

    public void testFindInorderSuccessor(){
        TreeNode node = btree.binarySearch(3);
        assertNotNull("binary search returned null",node);
        
        TreeNode inorderSuccessor = new Question4dot5().findInorderSuccessor(node);
        
        assertEquals("output did not match",4,inorderSuccessor.data);
    }
    
    public void testFindInorderSuccessorForNoChildNode(){
        TreeNode node = btree.binarySearch(2);
        assertNotNull("binary search returned null",node);
        
        TreeNode inorderSuccessor = new Question4dot5().findInorderSuccessor(node);
        
        assertEquals("output did not match",3,inorderSuccessor.data);
    }
    
    public void testFindInorderSuccessorForRightmostNode(){
        TreeNode node = btree.binarySearch(14);
        assertNotNull("binary search returned null",node);
        
        TreeNode inorderSuccessor = new Question4dot5().findInorderSuccessor(node);
        
        assertEquals("output did not match",null,inorderSuccessor);
    }
    
    public void testFindInorderSuccessorForLeftmostNode(){
        TreeNode node = btree.binarySearch(0);
        assertNotNull("binary search returned null",node);
        
        TreeNode inorderSuccessor = new Question4dot5().findInorderSuccessor(node);
        
        assertEquals("output did not match",1,inorderSuccessor.data);
    }
    
    public void testSingleNodeTree(){
        BinaryTree tree = new BinaryTree(5);
        TreeNode node = tree.getRoot();

        TreeNode inorderSuccessor = new Question4dot5().findInorderSuccessor(node);
        assertNull("output did not match",inorderSuccessor);
    }
}
