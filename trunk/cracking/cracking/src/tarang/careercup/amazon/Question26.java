package tarang.careercup.amazon;


import tarang.datastructures.TreeNode;

import java.util.Stack;

/**
 * Implement an in-order traversal of a binary tree using iterator's method
 *
 * @author tdesai
 */
public class Question26 {

    public static void main(String[] args) {
        int[] A = {0, 3, 5, 7, 8, 9, 11, 21, 29};
        TreeNode root = Question03.reconstruct_inorder(A, 0, A.length - 1);
        IterableBinaryTree iterator = new IterableBinaryTree(root);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}

class IterableBinaryTree {
    private Stack<TreeNode> stack;

    public IterableBinaryTree(TreeNode root) {
        stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.getLeft();
        }
    }

    public boolean hasNext() {
        return !stack.empty();
    }

    public Integer next() {
        Integer value = null;
        if (!stack.empty()) {
            TreeNode node = stack.pop();
            value = node.getValue();
            TreeNode curr = node.getRight();
            while (curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            }
        }
        return value;
    }
}
