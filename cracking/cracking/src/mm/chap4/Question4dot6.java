/*
 * $Id$
 *
 * Copyright (c) 2001-2008 Bridge Entertainment, Inc. (dba E-Poll Market Research)
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information
 * of Bridge Entertainment, Inc. ("Confidential Information").
 */


package mm.chap4;

import mm.BinaryTree;
import mm.TreeNode;


/**
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree Avoid storing
 * additional nodes in a data structure	NOTE: This is not necessarily a binary search tree
 *
 * @author mmathuria
 */
public class Question4dot6 {

    public static TreeNode findCommonAncestor(BinaryTree tree, TreeNode node1, TreeNode node2){
        if(tree == null) throw new IllegalStateException("Tree cannot be empty");
        TreeNode ancestor = find(tree.getRoot(),node1, node2);
        if(ancestor!=null && (ancestor.getData() == node1.getData()
                || ancestor.getData() == node2.getData())) {
            ancestor = null;
        }
        return ancestor;
    }

    private static TreeNode find(TreeNode current, TreeNode node1, TreeNode node2){
        if(current == null) return null;
        //System.out.print(current.getData() + ", ");

        if(current.getData() == node1.getData()
                || current.getData() == node2.getData()){
            return current;
        }

        TreeNode left = find(current.getLeftChild(), node1, node2);
        TreeNode right = find(current.getRightChild(), node1, node2);

        if(left!= null && right != null){
            return current;
        }else if(left == null){
            return right;
        }else{
            return left;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(8);

        TreeNode seven = new TreeNode(7);
        TreeNode five = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode four = new TreeNode(4);
        TreeNode one = new TreeNode(1);
        TreeNode six = new TreeNode(6);
        TreeNode three = new TreeNode(3);

        four.leftChild = one;
        four.rightChild = six;

        nine.leftChild = four;
        nine.rightChild = three;

        five.leftChild = nine;

        tree.getRoot().leftChild = seven;
        tree.getRoot().rightChild = five;

        System.out.println(findCommonAncestor(tree, seven, six).data);  // 8
        System.out.println(findCommonAncestor(tree, one, six).data);    // 4
        System.out.println(findCommonAncestor(tree, one, three));   // null
        System.out.println(findCommonAncestor(tree, four, three));  // null
        System.out.println(findCommonAncestor(tree, seven, five));  // 8
        System.out.println(findCommonAncestor(tree, seven, three)); // 8
    }

}
