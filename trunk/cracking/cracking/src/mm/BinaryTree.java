package mm;


/**
 * Put class JavaDoc here 
 *
 * @author mmathuria
 */
public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
    }

    public BinaryTree(int rootData) {
        root = new TreeNode(rootData);
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int data){
        TreeNode newNode = new TreeNode(data);
        
        if(root == null){
            root = newNode;
            return;
        }

        recursiveInsert(root, newNode);
        
    }

    private void recursiveInsert(TreeNode current, TreeNode newNode) {
        if(newNode.data <= current.data){
            if(current.leftChild == null){
                current.leftChild = newNode;
            }else{
                recursiveInsert(current.leftChild,newNode);
            }
        }else{
            if(current.rightChild == null){
                current.rightChild = newNode;
            }else{
                recursiveInsert(current.rightChild, newNode);
            }
        }
    }
    
    public TreeNode delete(TreeNode node){
        if(root == null || node == null){
            return null;
        }

        TreeNode tmp;
        if(root.data == node.data){
            tmp = root;
            root = null;
            return tmp;
        }

        TreeNode parent, current;
        parent = current = root;
        boolean isLeftChild = false;
        
        while(current != null && current.data != node.data){
            parent = current;
            if(node.data <= current.data){
                current = current.leftChild;
                isLeftChild = true;
            }else{
                current = current.rightChild;
                isLeftChild = false;
            }            
        }
        if(current == null){
            return null;
        }
        if(isLeftChild){
            tmp = parent.leftChild;
            parent.leftChild = null;
        }else{
            tmp = parent.rightChild;
            parent.rightChild = null;
        }
        return tmp;       
    }
    
    public TreeNode findMin(){
        if(root == null){
            System.out.println("empty tree");
            return null;
        }
        
        TreeNode current = root;
        while(current.leftChild != null)    current = current.leftChild;
        return current;
    }
    
    
    public void display(){
        if(root == null){
            System.out.println("empty tree");
            return;
        }
        System.out.println("\n");
        recursiveDisplay(root);
        System.out.println("\n");
    }
    
    private void recursiveDisplay(TreeNode current){
        if(current == null){
            return;
        }
        
        recursiveDisplay(current.leftChild);
        System.out.println(" " + current.data);
        recursiveDisplay(current.rightChild);
    }
    
    
    public static BinaryTree createFromInorder(int[] preOrderedArray){
        int middle = (preOrderedArray.length - 1) / 2;
        BinaryTree bTree = new BinaryTree(preOrderedArray[middle]);
        _createFromInorder(0,middle-1,preOrderedArray, bTree.getRoot());
        _createFromInorder(middle+1,preOrderedArray.length-1,preOrderedArray, bTree.getRoot());
        return bTree;
    }
    
    private static void _createFromInorder(int lower, int upper, int[] preOrderedArray, TreeNode current){
        if(lower > upper)   return;
        
        int middle = (lower + upper) / 2;
        int middleValue = preOrderedArray[middle];
        TreeNode treeNode = new TreeNode(middleValue);
        
        if(middleValue < current.getData()){
            current.leftChild = treeNode;
        }else{
            current.rightChild = treeNode;
        }
        
        _createFromInorder(lower,middle-1,preOrderedArray,treeNode);
        _createFromInorder(middle+1,upper,preOrderedArray,treeNode);
    }
}
