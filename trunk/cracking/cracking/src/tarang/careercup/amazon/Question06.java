package tarang.careercup.amazon;

import tarang.datastructures.TreeNode;

import java.util.HashMap;
import java.util.Map;


/**
 * Given a binary tree count the number of nodes at each level in the tree. Follow up: count the number of nodes below
 * each node
 *
 * @author tdesai
 */
public class Question06 {

    private static void levelNodeCount(TreeNode node, int level, Map<Integer, Integer> levelNodes) {
        if(node == null) {
            return;
        }
        levelNodes.put(level, levelNodes.get(level) == null ? 1 : levelNodes.get(level) + 1);
        levelNodeCount(node.getLeft(), level + 1, levelNodes);
        levelNodeCount(node.getRight(), level + 1, levelNodes);
    }

    private static int countNodes(TreeNode node, Map<Integer, Integer> nodeCount) {
        if(node == null) {
            return 0;
        }
        int currNodeCnt  = 1 + countNodes(node.getLeft(), nodeCount) + countNodes(node.getRight(), nodeCount);
        nodeCount.put(node.getValue(), currNodeCnt);
        return currNodeCnt;
    }

    // count number of nodes under each node + 1
    public static Map<Integer, Integer> countNodes(TreeNode root) {
        Map<Integer, Integer> nodeCount = new HashMap<Integer, Integer>();
        countNodes(root, nodeCount);
        return nodeCount;
    }

    // number of nodes at each level
    public static Map<Integer, Integer> levelNodeCount(TreeNode root) {
        Map<Integer, Integer> levelNodes = new HashMap<Integer, Integer>();
        levelNodeCount(root, 0, levelNodes);
        return levelNodes;
    }

    public static void main(String[] args) {
        int[] A = {0, 3, 5, 7, 8, 9, 11, 13, 15, 18, 21, 52, 101, 120, 123, 156, 189, 191};
        TreeNode root = Question03.reconstruct_inorder(A, 0, A.length-1);
        Map<Integer, Integer> levelNodes = levelNodeCount(root);
        int count = 0;
        for(Integer level : levelNodes.keySet()) {
            count += levelNodes.get(level);
            System.out.println(level + " : " + levelNodes.get(level));
        }
        System.out.println(count + " -> " + A.length);
        System.out.println();

        Map<Integer, Integer> nodeCount = countNodes(root);
        for (Integer node : nodeCount.keySet()) {
            System.out.println(node + " : " + nodeCount.get(node));
        }
    }
}
