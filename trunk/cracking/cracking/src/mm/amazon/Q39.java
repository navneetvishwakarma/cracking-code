package mm.amazon;


import mm.ds.TreeNode;

import java.util.Stack;

/**
 * Given a binary tree, print out the tree in zigzaag level order (ie, from L to R, then R to L for the next level and 
 * alternate between them). Ouput a newline after the end of each level
 */
public class Q39 {
    
    public void zigzagTraversal(TreeNode root) throws Exception {
        if(root == null){
            throw new Exception(("root node cannot be null"));
        }

        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        int i = 0;
        
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            if (node != null) {
                System.out.print(node.data + " ");
                if (i % 2 == 1) {
                    stack2.push(node.leftChild);
                    stack2.push(node.rightChild);
                } else {
                    stack2.push(node.rightChild);
                    stack2.push(node.leftChild);
                }
            }

            if(stack1.isEmpty()){
                Stack<TreeNode> tmp = stack1;
                stack1 = stack2;
                stack2 = tmp;
                i++;
                System.out.println();
            }
            
        }
    }

    public static void main(String[] args) throws Exception {
        Q39 obj = new Q39();
        obj.zigzagTraversal(obj.testData1());
    }
    
    private TreeNode testData1(){
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2); 
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);
        TreeNode ten = new TreeNode(10);
        TreeNode eleven = new TreeNode(11);
        TreeNode twelve = new TreeNode(12);
        TreeNode thirteen = new TreeNode(13);
        TreeNode fourteen = new TreeNode(14);
        TreeNode fifteen = new TreeNode(15);
        
        root.leftChild = two;
        root.rightChild = three;
        
        two.leftChild = four;
        two.rightChild = five;
        
        three.leftChild = six;
        three.rightChild = seven;
        
        four.leftChild = eight;
        four.rightChild = nine;
        
        six.leftChild = ten;
        six.rightChild = eleven;
        
        ten.leftChild = twelve;
        ten.rightChild = thirteen;
        
        eleven.leftChild = fourteen;
        eleven.rightChild = fifteen;
        
        return root;
    }
}
