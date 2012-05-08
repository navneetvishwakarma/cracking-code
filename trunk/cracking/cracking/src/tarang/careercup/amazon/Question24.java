package tarang.careercup.amazon;


import tarang.datastructures.TreeNode;

/**
 * Given a BST, convert it so that each node has value equal to sum of all the nodes (including itself) which are
 greater than that node in the whole tree.
 *
 * @author tdesai
 */
public class Question24 {

    public static int sumGreater(TreeNode node, int sumSoFar) {
        if(node == null) {
            return sumSoFar;
        }
        node.setValue(node.getValue() + sumGreater(node.getRight(), sumSoFar));
        return sumGreater(node.getLeft(), node.getValue());
    }

    public static void main(String[] args) {
        TreeNode eight = new TreeNode(8);
        TreeNode three = new TreeNode(3);
        TreeNode ten = new TreeNode(10);

        eight.setLeft(three);
        eight.setRight(ten);

        System.out.println(eight);
        sumGreater(eight, 0);
        System.out.println(eight);
    }
}
