package mm;

import junit.framework.TestCase;
import mm.ds.BinaryTree;
import mm.ds.TreeNode;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class BinaryTreeTest extends TestCase {
    public void testInsert() {
        BinaryTree bTree = new BinaryTree(100);
        bTree.insert(88);
        bTree.insert(101);
        bTree.insert(87);
        bTree.insert(89);

        bTree.displayInorder();
    }


    public void testFindMin() {
        BinaryTree bTree = someTree();

        TreeNode node = bTree.findMin();
        assertNotNull("node is null", node);
        assertEquals("expected node was not found", 44, node.data);

    }

    public void testDeleteRightLeaf() {
        BinaryTree bTree = someTree();

        TreeNode nodeToBeDeleted = new TreeNode(150);
        TreeNode deletedNode = bTree.delete(nodeToBeDeleted);

        assertNotNull("nodeToBeDeleted not found", deletedNode);
        assertEquals("wrong node deleted", nodeToBeDeleted.data, deletedNode.data);
    }

    public void testDeleteLeftLeaf() {
        BinaryTree bTree = someTree();

        TreeNode nodeToBeDeleted = new TreeNode(44);
        TreeNode deletedNode = bTree.delete(nodeToBeDeleted);

        assertNotNull("nodeToBeDeleted not found", deletedNode);
        assertEquals("wrong node deleted", nodeToBeDeleted.data, deletedNode.data);
    }


    public void testDeleteNonExistentNode() {
        BinaryTree bTree = someTree();

        TreeNode nodeToBeDeleted = new TreeNode(199);
        TreeNode deletedNode = bTree.delete(nodeToBeDeleted);

        assertNull("nodeToBeDeleted not found", deletedNode);
    }


    public void testDeleteSingleRoot() {
        BinaryTree bTree = new BinaryTree(100);

        TreeNode nodeToBeDeleted = new TreeNode(100);
        TreeNode deletedNode = bTree.delete(nodeToBeDeleted);

        assertNotNull("nodeToBeDeleted not found", deletedNode);
        assertEquals("root was not deleted", nodeToBeDeleted.data, deletedNode.data);
    }
    
    private BinaryTree someTree() {
        BinaryTree bTree = new BinaryTree(100);
        bTree.insert(88);
        bTree.insert(101);
        bTree.insert(87);
        bTree.insert(89);
        bTree.insert(55);
        bTree.insert(44);
        bTree.insert(150);
        return bTree;
    }
}
