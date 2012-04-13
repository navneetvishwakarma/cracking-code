package tarang.careercup.amazon;


import tarang.datastructures.TreeNode;

import java.util.ArrayList;

/**
 * Given a binary tree and a number X, find if there exists a path that sums to X. Path starts from the root and
 * goes to the leaf
 *
 * @author tdesai
 */
public class Question13 {

    public static void findPathForX(TreeNode node, int X, int level, ArrayList<Integer> path) {
        if(node == null) {
            return;
        }
        path.add(node.getValue());
        int sum = X;
        for(int i = level; i >= 0; i--) {
            sum -= path.get(i);
            if(sum == 0) {
                // print path from i to level.
                for(int j = i; j <= level; j++) {
                    System.out.print(path.get(j));
                    if(j < level) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println();
            }
        }
        // clone because left node and right now cannot have the same list because they might change each other's list
        ArrayList<Integer> c1 = (ArrayList<Integer>) path.clone();
        ArrayList<Integer> c2 = (ArrayList<Integer>) path.clone();
        findPathForX(node.getLeft(), X, level+1, c1);
        findPathForX(node.getRight(), X, level+1, c2);
    }

    public static void main(String[] args) {
        int[] A = {3, 6, 0, 2, 3, 1, 4, 0, 4, 5, 9, 0, 1, 11, 10};
        TreeNode root = Question03.reconstruct_preorder(A, 0, A.length - 1);

        findPathForX(root, 7, 0, new ArrayList<Integer>());
    }
}
