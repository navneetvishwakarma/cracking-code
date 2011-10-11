package tarang.careercup.amazon;

import tarang.careercup.TreeNode;

import java.util.HashMap;
import java.util.Map;


/**
 * Given a binary tree count the number of nodes at each level in the tree.
 *
 * @author tdesai
 */
public class Question06 {

    private static void countNodes(TreeNode node, int level, Map<Integer, Integer> levelNodes) {
        if(node == null) {
            return;
        }
        levelNodes.put(level, levelNodes.get(level) == null ? 1 : levelNodes.get(level) + 1);
        countNodes(node.getLeft(), level + 1, levelNodes);
        countNodes(node.getRight(), level + 1, levelNodes);
    }

    public static Map<Integer, Integer> countNodes(TreeNode root) {
        Map<Integer, Integer> levelNodes = new HashMap<Integer, Integer>();
        countNodes(root, 0, levelNodes);
        return levelNodes;
    }

    public static void main(String[] args) {
        int[] A = {0, 3, 5, 7, 8, 9, 11, 13, 15, 18, 21, 52, 101, 120, 123, 156, 189, 191};
        TreeNode root = Question03.reconstruct_inorder(A, 0, A.length-1);
        Map<Integer, Integer> levelNodes = countNodes(root);
        int count = 0;
        for(Integer level : levelNodes.keySet()) {
            count += levelNodes.get(level);
            System.out.println(level + " : " + levelNodes.get(level));
        }
        System.out.println(count + " -> " + A.length);
    }
}
