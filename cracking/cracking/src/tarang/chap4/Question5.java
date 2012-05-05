package tarang.chap4;

import tarang.datastructures.TreeNode;


/**
 * Write an algorithm to find the next node (i e , in-order successor) of a given node in a binary search tree where
 * each node has a link to its parent
 *
 * @author tdesai
 */
public class Question5 {


    // O(n)
    public static TreeNode successor(TreeNode node) {
        if(node == null) {
            throw new IllegalArgumentException("node is null");
        }

        // minimum node in the right subtree
        TreeNode curr = node.getRight();
        while(curr != null) {
            if(curr.getLeft() == null) {
                return curr;
            }
            curr = curr.getLeft();
        }
        // go up the tree until we find a node which is the left child, parent of such a node is the successor
        TreeNode parent = node.getParent();
        curr = node;
        while(parent != null && (parent.getLeft() == null || !parent.getLeft().equals(curr))){
            curr = parent;
            parent = curr.getParent();
        }
        return parent;

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

        eight.setLeft(three);
        eight.setRight(ten);

        three.setLeft(one);
        three.setRight(six);

        ten.setRight(fourteen);

        six.setLeft(four);
        six.setRight(seven);

        fourteen.setLeft(thirteen);

        System.out.println("successor(8): " + Question5.successor(eight));
        System.out.println("successor(1): " + Question5.successor(one));
        System.out.println("successor(7): " + Question5.successor(seven));
        System.out.println("successor(14): " + Question5.successor(fourteen));
    }
}
