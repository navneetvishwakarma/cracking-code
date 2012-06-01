package tarang.careercup.amazon;


import tarang.datastructures.TreeNode;

/**
 * Given a node in a binary tree, how will you find out if left and right subtrees are mirror images of each other?
 *
 * @author tdesai
 */
public class Question25 {

    public static boolean isMirror(TreeNode node1, TreeNode node2) {
        // check if both nodes are null, if they are, done.
        // check neither are null and both have same value, proceed with comparing node1.left to node2.right
        // and node2.left to node2.right
        // otherwise return false
        if(node1 == null && node2 == null) {
            return true;
        }
        if(node1 == null || node2 == null) {
            return false;
        }
        return (node1.getValue() == node2.getValue()) && isMirror(node1.getLeft(), node2.getRight())
                && isMirror(node1.getRight(), node2.getLeft());
    }

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode nine1 = new TreeNode(9);
        TreeNode nine2 = new TreeNode(9);
        TreeNode eight1 = new TreeNode(8);
        TreeNode eight2 = new TreeNode(8);
        TreeNode seven1 = new TreeNode(7);
        TreeNode seven2 = new TreeNode(7);
        TreeNode four1 = new TreeNode(4);
        TreeNode four2 = new TreeNode(4);
        TreeNode six1 = new TreeNode(6);
        TreeNode six2 = new TreeNode(6);
        TreeNode zero1 = new TreeNode(0);
        TreeNode zero2 = new TreeNode(0);
        TreeNode one1 = new TreeNode(1);
        TreeNode one2 = new TreeNode(1);

        three.setLeft(nine1);
        three.setRight(nine2);

        nine1.setLeft(eight1);
        nine2.setRight(eight2);
        nine1.setRight(seven1);
        nine2.setLeft(seven2);

        eight1.setLeft(four1);
        eight2.setRight(four2);
        eight1.setRight(six1);
        eight2.setLeft(six2);

        seven1.setLeft(zero1);
        seven2.setRight(zero2);
        seven1.setRight(one1);
        seven2.setLeft(one2);

        System.out.println(isMirror(three.getLeft(), three.getRight()));
    }
}
