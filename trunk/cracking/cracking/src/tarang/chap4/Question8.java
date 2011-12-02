package tarang.chap4;

import tarang.careercup.amazon.Question03;
import tarang.datastructures.TreeNode;

import java.util.*;


/**
 * You are given a binary tree in which each node contains a value	Design an algorithm to print all paths which sum up
 * to that value. Note that it can be any path in the tree - it does not have to start at the root
 *
 * @author tdesai
 */
public class Question8 {

    private static void traverseNodePath(TreeNode node, int X, int sum, LinkedList<TreeNode> path,
                                 List<LinkedList<TreeNode>> paths) {
        if(node == null) {
            return;
        }
        int nodesum = sum + node.getValue();
        if(nodesum == X) {
            path.add(node);
            paths.add(path);
        }
        traverseNodePath(node.getLeft(), X, nodesum, (LinkedList<TreeNode>) path.clone(), paths);
        traverseNodePath(node.getRight(), X, nodesum, (LinkedList<TreeNode>) path.clone(), paths);
    }

    private static void traverse(TreeNode node, int X, List<LinkedList<TreeNode>> paths) {
        if(node == null) {
            return;
        }
        traverseNodePath(node, X, 0, new LinkedList<TreeNode>(), paths);
        traverse(node.getLeft(), X, paths);
        traverse(node.getRight(), X, paths);
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = Question03.reconstruct_inorder(A, 0, A.length - 1);
        List<LinkedList<TreeNode>> paths = new ArrayList<LinkedList<TreeNode>>();
        int X = 4;
        traverse(root, X, paths);
        String str;
        str = X + ":\n";
        for (LinkedList<TreeNode> path : paths) {
            for (TreeNode node : path) {
                str += node.getValue() + " -> ";
            }
            str += "\n";
        }
        System.out.println(str);
    }
}
