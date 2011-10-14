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


    private static void initializeMap(TreeNode node, Map<Integer, List<LinkedList<TreeNode>>> map) {
        if(node == null) {
            return;
        }
        List<LinkedList<TreeNode>> paths = map.get(node.getValue());
        if(paths == null) {
            paths = new ArrayList<LinkedList<TreeNode>>();
            map.put(node.getValue(), paths);
        }
        initializeMap(node.getLeft(), map);
        initializeMap(node.getRight(), map);
    }

    private static void traverseNodePath(TreeNode node, int sum, LinkedList<TreeNode> path,
                                 Map<Integer, List<LinkedList<TreeNode>>> map) {
        if(node == null) {
            return;
        }
        int nodesum = sum + node.getValue();
        if(map.get(nodesum) != null) {
            path.add(node);
            map.get(nodesum).add(path);
        }
        traverseNodePath(node.getLeft(), nodesum, (LinkedList<TreeNode>) path.clone(), map);
        traverseNodePath(node.getRight(), nodesum, (LinkedList<TreeNode>) path.clone(), map);
    }

    private static void traverse(TreeNode node, Map<Integer, List<LinkedList<TreeNode>>> map) {
        if(node == null) {
            return;
        }
        traverseNodePath(node, 0, new LinkedList<TreeNode>(), map);
        traverse(node.getLeft(), map);
        traverse(node.getRight(), map);
    }


    public static Map<Integer, List<LinkedList<TreeNode>>> nodePathSum(TreeNode root) {
        Map<Integer, List<LinkedList<TreeNode>>> map  = new HashMap<Integer, List<LinkedList<TreeNode>>>();
        // get a map with empty paths
        initializeMap(root, map);
        traverse(root, map);
        return map;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = Question03.reconstruct_inorder(A, 0, A.length - 1);
        Map<Integer, List<LinkedList<TreeNode>>> map = nodePathSum(root);
        String str;
        for(Integer key : map.keySet()) {
            str = key + ":\n";
            List<LinkedList<TreeNode>> list = map.get(key);
            for(LinkedList<TreeNode> path : list) {
                for(TreeNode node : path) {
                    str += node.getValue() + " -> ";
                }
                str += "\n";
            }
            System.out.println(str);
        }
    }
}
