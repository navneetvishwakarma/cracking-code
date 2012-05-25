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

    // number of nodes at each level - O(n)

    public static Map<Integer, Integer> levelNodeCount(TreeNode root) {
        Map<Integer, Integer> levelNodes = new HashMap<Integer, Integer>();
        levelNodeCount(root, 0, levelNodes);
        return levelNodes;
    }

    private static void levelNodeCount(TreeNode node, int level, Map<Integer, Integer> levelNodes) {
        if(node == null) {
            return;
        }
        // update count at this level
        Integer count = levelNodes.get(level);
        if(count == null) {
            count = 0;
        }
        levelNodes.put(level, count + 1);
        levelNodeCount(node.getLeft(), level + 1, levelNodes);
        levelNodeCount(node.getRight(), level + 1, levelNodes);
    }

    // count number of nodes under each node + 1 - O(n)

    public static Map<Integer, Integer> countNodes(TreeNode root) {
        Map<Integer, Integer> nodeCount = new HashMap<Integer, Integer>();
        countNodes(root, nodeCount);
        return nodeCount;
    }

    private static int countNodes(TreeNode node, Map<Integer, Integer> nodeCount) {
        int currNodeCnt = 0;    // each not starts out with 0
        if(node.getLeft() != null) {
            currNodeCnt += 1;   // has left node, add 1
            currNodeCnt += countNodes(node.getLeft(), nodeCount);   // count whats in the left subtree
        }
        if(node.getRight() != null) {
            currNodeCnt += 1;   // has right node, add 1
            currNodeCnt += countNodes(node.getRight(), nodeCount);  // count whats in the right subtree
        }
        nodeCount.put(node.getValue(), currNodeCnt);
        return currNodeCnt;
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
