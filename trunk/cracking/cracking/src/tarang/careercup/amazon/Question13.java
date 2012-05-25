package tarang.careercup.amazon;


import tarang.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a number X, find if there exists a path that sums to X. Path starts from the root and goes to
 * the leaf
 *
 * @author tdesai
 */
public class Question13 {

    public static void findPathForX(TreeNode node, int X, int level, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.getValue());
        int sum = X;
        for (int i = level; i >= 0; i--) {
            sum -= path.get(i);
            if (sum == 0) {
                // print path from i to level.
                for (int j = i; j <= level; j++) {
                    System.out.print(path.get(j));
                    if (j < level) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println();
            }
        }
        // clone because left node and right now cannot have the same list because they might change each other's list
        ArrayList<Integer> c1 = (ArrayList<Integer>) path.clone();
        ArrayList<Integer> c2 = (ArrayList<Integer>) path.clone();
        findPathForX(node.getLeft(), X, level + 1, c1);
        findPathForX(node.getRight(), X, level + 1, c2);
    }

    public static ArrayList<Integer> pathRootToLeaf(TreeNode node, int X, ArrayList<Integer> path) {
        if(node == null) {
            if (X == 0) {
                return path;
            } else {
                return null;
            }
        }
        ArrayList<Integer> leftPath = pathRootToLeaf(node.getLeft(), X - node.getValue(), (ArrayList<Integer>) path.clone());
        if(leftPath != null) {
            leftPath.add(node.getValue());
            path.addAll(leftPath);
            return path;
        }
        ArrayList<Integer> rightPath = pathRootToLeaf(node.getRight(), X - node.getValue(), (ArrayList<Integer>) path.clone());
        if(rightPath != null) {
            rightPath.add(node.getValue());
            path.addAll(rightPath);
            return path;
        }
        return null;
    }

    private static void print(List<Integer> path) {
        if(path.size() == 1) {
            System.out.print(path.get(0) + " ");
        } else {
            print(path.subList(1, path.size()));
            System.out.print(path.get(0) + " ");
        }
    }

    public static void main(String[] args) {
        int[] A = {9, 11, 5, 4, 3, 7, 1, 1, 14, 6, 8, 5, 11};
        TreeNode root = Question03.reconstruct_preorder(A, 0, A.length - 1);

        //findPathForX(root, 7, 0, new ArrayList<Integer>());
        ArrayList<Integer> path = pathRootToLeaf(root, 26, new ArrayList<Integer>());
        if(path == null) {
            System.out.print("No path");
        } else {
            print(path);
        }
    }
}
