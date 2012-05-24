package mm.ds;


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

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insertPreorder(int[] data){
        for(int d : data){
            insert(d);
        }
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
                newNode.parent = current;
            }else{
                recursiveInsert(current.leftChild,newNode);
            }
        }else{
            if(current.rightChild == null){
                current.rightChild = newNode;
                newNode.parent = current;
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
    
    public TreeNode binarySearch(int data){
        TreeNode current = root;
        while(current != null){
            if(current.data == data) break;
            if(current.data > data)    current = current.leftChild;
            else current = current.rightChild;
        }
        return current;
    }
    
    public void displayInorder(){
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
}
