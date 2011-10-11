package tarang.careercup.amazon;

import tarang.careercup.TreeNode;


/**
 * Find if a binary tree is bst
 *
 * @author tdesai
 */
public class Question01 {

    public boolean check(TreeNode node) {
        if (node == null) {
            return true;
        } else {
            int value = node.getValue();
            if (node.getLeft() != null && value < node.getLeft().getValue()) {
                return false;
            }
            if (node.getRight() != null && value > node.getRight().getValue()) {
                return false;
            }
            return check(node.getLeft()) && check(node.getRight());
        }
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(3, new TreeNode(0), new TreeNode(5));
        TreeNode right = new TreeNode(9, new TreeNode(8), new TreeNode(11));
        TreeNode root = new TreeNode(7, left, right);
        System.out.println(new Question01().check(root));
    }
}

