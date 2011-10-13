package tarang.chap4;

import tarang.datastructures.TreeNode;


/**
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree Avoid storing
 * additional nodes in a data structure	NOTE: This is not necessarily a binary search tree
 *
 * @author tdesai
 */
public class Question6 {

    private static boolean contains(TreeNode tree, TreeNode node) {
        if(tree == null) {
            return false;
        }
        if(tree.equals(node)) {
            return true;
        }
        return contains(tree.getLeft(), node) || contains(tree.getRight(), node);
    }

    public static TreeNode commonAncestors(TreeNode tree, TreeNode node1, TreeNode node2) {
        if(tree == null) {
            return null;
        }
        boolean left = contains(tree.getLeft(), node1) && contains(tree.getLeft(), node2);
        boolean right = contains(tree.getRight(), node1) && contains(tree.getRight(), node2);
        if(left)  {
            // both nodes are in left subtree
            return commonAncestors(tree.getLeft(), node1, node2);
        } else if(right) {
            // both nodes are in right subtree
            return commonAncestors(tree.getRight(), node1, node2);
        } else {
            // the nodes are both neither in left or right, so one no each side
            return tree;
        }
    }

    public static void main(String[] args) {
        TreeNode eight = new TreeNode(8);
        TreeNode three = new TreeNode(3);
        TreeNode ten = new TreeNode(10);
        TreeNode one = new TreeNode(1);
        TreeNode six = new TreeNode(6);
        TreeNode fourteen = new TreeNode(14);
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode thirteen = new TreeNode(13);
        TreeNode eleven = new TreeNode(11);

        eight.setLeft(three);
        eight.setRight(ten);

        three.setLeft(one);
        three.setRight(six);

        ten.setRight(fourteen);

        six.setLeft(four);
        six.setRight(seven);

        fourteen.setLeft(thirteen);

        one.setRight(eleven);

        System.out.println("node1: " + six.getValue() + " node2: " + fourteen.getValue() + " common:" + commonAncestors(eight, six, fourteen));
        System.out.println("node1: " + four.getValue() + " node2: " + seven.getValue() + " common:" + commonAncestors(eight, four, seven));
        System.out.println("node1: " + six.getValue() + " node2: " + seven.getValue() + " common:" + commonAncestors(eight, six, seven));
        System.out.println("node1: " + seven.getValue() + " node2: " + eleven.getValue() + " common:" + commonAncestors(eight, eleven, seven));
    }

}
