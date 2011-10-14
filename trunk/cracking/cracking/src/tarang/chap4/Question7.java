package tarang.chap4;

import tarang.datastructures.TreeNode;


/**
 * You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes	Create an
 * algorithm to decide if T2 is a subtree of T1
 *
 * @author tdesai
 */
public class Question7 {

    // go through t1 and t2 - O(n)
    public static boolean isSubtree(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 != null) {
            // t1 has made it all the way to the leaf and not found a match for t2
            return false;
        }
        if(t2 == null) {
            // we've reached the leaf of t2 so matched
            return true;
        }
        if(t1.equals(t2)) {
            // nodes match so go a level deeper in both t1 and t2
            return isSubtree(t1.getLeft(), t2.getLeft()) && isSubtree(t1.getRight(), t2.getRight());
        } else {
            // nodes don't match so try a level deeper in t1 and see if either left or right matches
            return isSubtree(t1.getLeft(), t2) || isSubtree(t1.getRight(), t2);
        }
    }

    // based on a string representation of the trees and seeing if t2 is substring of t1
    public static boolean isSubtree2(TreeNode t1, TreeNode t2) {
        return t1.toString().contains(t2.toString());
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

        // method 2
        System.out.println("method 2: ");

        System.out.println(isSubtree2(eight, eight));    // true
        System.out.println(isSubtree2(eight, six));      // true
        System.out.println(isSubtree2(eight, seven));    // true


        TreeNode six2 = new TreeNode(6);
        TreeNode four2 = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        six2.setLeft(four2);
        six2.setRight(five);

        System.out.println(isSubtree2(eight, six2));
        System.out.println(isSubtree2(six2, six2));

        // method 1
        System.out.println("method 1: ");

        System.out.println(isSubtree(eight, eight));    // true
        System.out.println(isSubtree(eight, six));      // true
        System.out.println(isSubtree(eight, seven));    // true

        System.out.println(isSubtree(eight, six2));
        System.out.println(isSubtree(six2, six2));
    }
}
