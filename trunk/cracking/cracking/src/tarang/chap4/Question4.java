package tarang.chap4;

import tarang.careercup.amazon.Question03;
import tarang.datastructures.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


/**
 * Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth (i e , if
 * you have a tree with depth D, youll have D linked lists)
 *
 * @author tdesai
 */
public class Question4 {

    // O(n)
    private static void findLevelLinkList_internal(TreeNode node, int level, Map<Integer, LinkedList<TreeNode>> map) {
        if(node == null) {
            return;
        }
        LinkedList<TreeNode> nodes = map.get(level);
        if(nodes == null) {
            nodes = new LinkedList<TreeNode>();
            map.put(level, nodes);
        }
        nodes.add(node);
        findLevelLinkList_internal(node.getLeft(), level + 1, map);
        findLevelLinkList_internal(node.getRight(), level + 1, map);
    }

    public static Map<Integer, LinkedList<TreeNode>> findLevelLinkList(TreeNode root) {
        Map<Integer, LinkedList<TreeNode>> map = new HashMap<Integer, LinkedList<TreeNode>>();
        findLevelLinkList_internal(root, 0, map);
        return map;
    }

    public static void main(String[] args) {
        int[] A = {0, 3, 5, 7, 8, 9, 11, 13, 15, 18, 21, 52, 101, 120, 123, 156, 189, 191};
        TreeNode root = Question03.reconstruct_inorder(A, 0, A.length - 1);
        Map<Integer, LinkedList<TreeNode>> map = findLevelLinkList(root);
        int count = 0;
        for(int key : map.keySet()) {
            String str = key + ": ";
            for(TreeNode node : map.get(key)) {
                str += node.getValue() + " -> ";
                count++;
            }
            System.out.println(str);
        }
        System.out.println("orig: " + A.length + " found: " + count);
    }
}
