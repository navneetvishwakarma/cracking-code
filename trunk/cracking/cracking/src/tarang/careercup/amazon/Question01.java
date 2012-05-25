package tarang.careercup.amazon;

import tarang.datastructures.TreeNode;


/**
 * Find if a binary tree is bst
 *
 * @author tdesai
 */
public class Question01 {

    // O(n)
    public boolean check(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        } else {
            int value = node.getValue();
            if(value < min || (node.getLeft() != null && value < node.getLeft().getValue())) {
                return false;
            }

            if(value > max || (node.getRight() != null && value > node.getRight().getValue())) {
                return false;
            }

            return check(node.getLeft(), min, value) && check(node.getRight(), value, max);
        }
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(7, new TreeNode(5), new TreeNode(8));
        TreeNode right = new TreeNode(14, new TreeNode(11), new TreeNode(16));
        TreeNode root = new TreeNode(10, left, right);
        System.out.println(new Question01().check(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}

