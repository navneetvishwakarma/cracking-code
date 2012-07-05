package mm.amazon;


import mm.ds.BinaryTree;
import mm.ds.TreeNode;

import java.util.Stack;

/**
 * Given two BST print the elements in sorted order
 * 
 * 
 * The idea is to traverse tree2 in descending sorted order (highest element first) and create a stack of its element. The 
 * Stack will be in ascending order.
 * Then traverse tree1 recursively; at each node pop stack elements lower than current node; print current node
 * 
 * This is an O(n + m + m)time and O(m)space algo
 * GeekforGeeks has a O(n+m)time and O(n+m)space algo
 */
public class Q37 {
    
    public void printSorted(BinaryTree tree1, BinaryTree tree2){
        Stack<TreeNode> postOrderStack = new Stack<TreeNode>();
        doPostOrderTraversal(tree2.getRoot(), postOrderStack);
        _printSorted(tree1.getRoot(),postOrderStack);
        while(!postOrderStack.empty()){
            System.out.print(postOrderStack.pop().data);
        }
        
    }

    private void _printSorted(TreeNode node, Stack<TreeNode> postOrderStack) {
        if(node == null) return;
        
        _printSorted(node.leftChild,postOrderStack);
        
        while(!postOrderStack.empty() && postOrderStack.peek().data < node.data){
            System.out.print(postOrderStack.pop().data);
        }

        System.out.print(node.data);
        
        _printSorted(node.rightChild,postOrderStack);
    }

    private void doPostOrderTraversal(TreeNode node, Stack<TreeNode> postOrder) {
        if(node == null) return;
        
        doPostOrderTraversal(node.rightChild,postOrder);
        postOrder.push(node);
        doPostOrderTraversal(node.leftChild,postOrder);
    }

    public static void main(String[] args) {
        Q37 obj = new Q37();

        BinaryTree tree1 = tree1();
        BinaryTree tree2 = tree2();
        
        obj.printSorted(tree1,tree2);
    }

    private static BinaryTree tree1() {
        BinaryTree tree = new BinaryTree(4);
        tree.insert(1);
        tree.insert(6);
        tree.insert(5);
        tree.insert(8);
        return tree;
    }
    private static BinaryTree tree2() {
        BinaryTree tree = new BinaryTree(3);
        tree.insert(2);
        tree.insert(7);
        tree.insert(0);
        return tree;
    }
}
