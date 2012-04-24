package tarang.careercup.amazon;


import java.util.ArrayList;
import java.util.List;

/**
 *
 Find the all the sequence from Unsorted array.

 Example : {2,4,6,8,10,14,11,12,15,7} is the unsorted array. We have to find out possible sequences.
 Output would be :
 Seq 1 : {2,4,6,8,10,11,12,15}
 Seq 2 : {2,4,6,8,10,14,15}

 Note : if I pick any element in array than next element would be grater than the previous element.

 * @author tdesai
 */
public class Question23 {


    public static SeqNode findSeq(int[] A, int start, SeqNode prev) {
        if(start == A.length) {
            return null;
        }
        SeqNode node = new SeqNode(A[start]);
        if(prev != null) {
            if(prev.getData() < node.getData()) {
                node.setParent(prev);
            } else {
                // go up to the point where this node's value is greater
                prev = prev.getParent();
                while(prev != null && prev.getData() > node.getData()) {
                    prev = prev.getParent();
                }
                node.setParent(prev);
            }
        }
        findSeq(A, start+1, node);
        return node;
    }

    public static void print(SeqNode node, String path) {
        path += node.getData() + " -> ";
        if(node.getChildren().size() == 0) {
            System.out.println(path);
        } else {
            for(SeqNode child : node.getChildren()) {
                print(child, path);
            }
        }
    }

    public static void main(String[] args) {
        int[] A =  {2,4,6,8,10,14,11,12,15,7};
        SeqNode node = findSeq(A, 0, null);
        print(node, "");
    }
}

class SeqNode {
    private int data;
    private SeqNode parent;
    private List<SeqNode> children;

    public SeqNode(int data) {
        this.data = data;
        this.children = new ArrayList<SeqNode>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SeqNode getParent() {
        return parent;
    }

    public void setParent(SeqNode parent) {
        this.parent = parent;
        parent.children.add(this);
    }

    public List<SeqNode> getChildren() {
        return children;
    }
}