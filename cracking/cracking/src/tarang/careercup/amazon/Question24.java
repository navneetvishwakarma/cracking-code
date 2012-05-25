package tarang.careercup.amazon;


import tarang.datastructures.Node;
import tarang.datastructures.TreeNode;

/**
 * Given a BST, convert it so that each node has value equal to sum of all the nodes (including itself) which are
 greater than that node in the whole tree.
 *
 * @author tdesai
 */
public class Question24 {

    public static int sumGreater(TreeNode node, int sumSofar) {
        if(node == null) {
            return sumSofar;
        }
        node.setValue(node.getValue() + sumGreater(node.getRight(), sumSofar));
        return sumGreater(node.getLeft(), node.getValue());
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 3, 4, 5, 11, 14, 15, 18, 20};
        TreeNode root = Question03.reconstruct_inorder(A, 0, A.length - 1);
        sumGreater(root, 0);
        System.out.print(root);
    }
}
