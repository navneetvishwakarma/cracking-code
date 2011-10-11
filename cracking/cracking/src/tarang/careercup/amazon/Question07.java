package tarang.careercup.amazon;

import tarang.careercup.TreeNode;


/**
 * Find the maximum sum path in a binary tree
 *
 * @author tdesai
 */
public class Question07 {

    private static int countNodes(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftSum = countNodes(node.getLeft());
        int rightSum = countNodes(node.getRight());
        int sum = node.getValue();
        if(leftSum > rightSum) {
            node.setRight(null);
            sum += leftSum;
        } else {
            node.setLeft(null);
            sum += rightSum;
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] A = {3, 6, 0, 2, 3, 1, 4, 0, 4, 5, 9, 0, 1, 11, 10};
        TreeNode root = Question03.reconstruct_preorder(A, 0, A.length - 1);

        countNodes(root);
        TreeNode curr = root;
        int count = 0;
        while(curr != null) {
            count += curr.getValue();
            System.out.print(curr + " -> ");
            if(curr.getLeft() != null) {
                curr = curr.getLeft();
            } else {
                curr = curr.getRight();
            }
        }
        System.out.println();
        System.out.println("total: " + count);
    }
}
