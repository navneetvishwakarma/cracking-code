package tarang.careercup.amazon;


import tarang.datastructures.TreeNode;

/**
 * Return true if two trees are same
 *
 * @author tdesai
 */
public class Question21 {

    public static boolean same(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) {
            return true;
        }
        if(node1 == null || node2 == null) {
            return false;
        }
        return node1.getValue() == node2.getValue()
                && same(node1.getLeft(), node2.getLeft())
                && same(node1.getRight(), node2.getRight());
    }
}
