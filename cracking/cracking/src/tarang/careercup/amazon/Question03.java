package tarang.careercup.amazon;

import tarang.datastructures.TreeNode;


/**
 * Reconstruct a BST given its preorder traversal. No extra space is allowed and accomplish this in O(n)
 *
 * @author tdesai
 */
public class Question03 {

    public static TreeNode reconstruct_preorder(int[] A, int start, int end) {
        if (start <= end) {
            int mid = (int) Math.ceil((start + end) / 2.0);
            TreeNode node = new TreeNode(A[start]);
            TreeNode leftNode = reconstruct_preorder(A, start + 1, mid);
            if (leftNode != null) {
                leftNode.setParent(node);
            }
            TreeNode rightNode = reconstruct_preorder(A, mid + 1, end);
            if (rightNode != null) {
                rightNode.setParent(node);
            }
            node.setLeft(leftNode);
            node.setRight(rightNode);
            return node;
        } else {
            return null;
        }
    }

    public static TreeNode reconstruct_inorder(int[] A, int start, int end) {
        if(start <= end) {
            int mid = (start + end)/2;
            TreeNode node = new TreeNode(A[mid]);
            TreeNode leftNode = reconstruct_inorder(A, start, mid - 1);
            if(leftNode != null) {
                leftNode.setParent(node);
            }
            TreeNode rightNode = reconstruct_inorder(A, mid + 1, end);
            if (rightNode != null) {
                rightNode.setParent(node);
            }
            node.setLeft(leftNode);
            node.setRight(rightNode);
            return node;
        } else {
            return null;
        }
    }

    public static TreeNode reconstruct_postorder(int[] A, int start, int end) {
        if (start <= end) {
            int mid = (int) Math.ceil((start + end) / 2.0);
            TreeNode node = new TreeNode(A[end]);
            TreeNode leftNode = reconstruct_postorder(A, start, mid - 1);
            if (leftNode != null) {
                leftNode.setParent(node);
            }
            TreeNode rightNode = reconstruct_postorder(A, mid, end - 1);
            if (rightNode != null) {
                rightNode.setParent(node);
            }
            node.setLeft(leftNode);
            node.setRight(rightNode);
            return node;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        int[] A = {0, 3, 5, 7, 8, 9, 11, 21, 29};
        TreeNode root = reconstruct_inorder(A, 0, A.length - 1);
        System.out.println(root);

        A = new int[]{7, 3, 0, 5, 9, 8, 11};
        root = reconstruct_preorder(A, 0, A.length - 1);
        System.out.println(root);

        A = new int[]{0, 5, 3, 8, 11, 9, 7};
        root = reconstruct_postorder(A, 0, A.length - 1);
        System.out.println(root);
    }
}
