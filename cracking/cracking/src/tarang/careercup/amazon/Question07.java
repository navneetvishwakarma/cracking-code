package tarang.careercup.amazon;

import tarang.datastructures.TreeNode;


/**
 * Find the maximum sum path in a binary tree
 *
 * @author tdesai
 */
public class Question07 {

    // O(n)
    private static int maxSumPath(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftSum = maxSumPath(node.getLeft());
        int rightSum = maxSumPath(node.getRight());
        int sum = node.getValue();
        if(leftSum > rightSum) {
            node.setPred(node.getLeft());
            sum += leftSum;
        } else {
            node.setPred(node.getRight());
            sum += rightSum;
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] A = {3, 6, 0, 2, 3, 1, 4, 0, 4, 5, 9, 0, 1, 11, 10};
        TreeNode root = Question03.reconstruct_preorder(A, 0, A.length - 1);

        maxSumPath(root);
        TreeNode curr = root;
        int count = 0;
        while(curr != null) {
            count += curr.getValue();
            System.out.print(curr + " -> ");
            curr = curr.getPred();
        }
        System.out.println();
        System.out.println("total: " + count);
    }
}
