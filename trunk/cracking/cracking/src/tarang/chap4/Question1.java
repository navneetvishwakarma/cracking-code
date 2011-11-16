package tarang.chap4;

import tarang.careercup.amazon.Question03;
import tarang.datastructures.TreeNode;


/**
 * Implement a function to check if a tree is balanced	For the purposes of this question, a balanced tree is defined to
 * be a tree such that no two leaf nodes differ in distance from the root by more than one
 *
 * @author tdesai
 */
public class Question1 {

    public static int minDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        return Math.min(minDepth(node.getRight(), depth + 1), minDepth(node.getLeft(), depth + 1));
    }

    public static int maxDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        return Math.max(maxDepth(node.getRight(), depth + 1), maxDepth(node.getLeft(), depth + 1));
    }

    // find the min depth and max depth 0(n)
    public static boolean isBalanced(TreeNode root) {
        int max = maxDepth(root, 0);
        int min = minDepth(root, 0);
        System.out.println("min: " + min + " max: " + max);
        return max - min <= 1;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = Question03.reconstruct_preorder(A, 0, A.length-1);
        System.out.println(isBalanced(root));

        TreeNode ten = new TreeNode(10);
        ten.setRight(new TreeNode(11));
        root.getLeft().getRight().setRight(ten);

        System.out.print(isBalanced(root));
    }
}
