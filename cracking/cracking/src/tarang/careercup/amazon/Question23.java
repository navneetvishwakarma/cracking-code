package tarang.careercup.amazon;


import tarang.datastructures.Node;

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


    public static void findSeq(int[] A, int start, List<SeqNode> tails) {
        if(start == A.length) {
            return;
        }
        if(tails.size() > 0) {
            // append to a tail or branch
            List<SeqNode> remove = new ArrayList<SeqNode>();
            List<SeqNode> add = new ArrayList<SeqNode>();
            for(SeqNode tail : tails) {
                if(tail.getData() > A[start]) {
                    // traverse up
                    while(tail != null && tail.getData() > A[start]) {
                        tail = tail.getParent();
                    }
                }
                SeqNode node = new SeqNode(A[start]);
                if(tail != null) {
                    // simply attach
                    node.setParent(tail);
                    tail.getChildren().add(node);
                    remove.add(tail);
                }
                add.add(node);
            }
            tails.removeAll(remove);
            tails.addAll(add);
        } else {
            tails.add(new SeqNode(A[start]));
        }
        findSeq(A, start+1, tails);
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
        List<SeqNode> tails = new ArrayList<SeqNode>();
        findSeq(A, 0, tails);
        for(SeqNode node : tails) {
            while (node != null) {
                System.out.print(node.getData() + " ");
                node = node.getParent();
            }
            System.out.println();
        }
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