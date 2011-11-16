package tarang.datastructures;


/**
 * Creates N stacks
 *
 * @author tdesai
 */
public class Stacks {
    private StacksNode[] arr;
    private LinkedList freelist;
    private int[] tops;

    public Stacks(int numOfStacks) {
        tops = new int[numOfStacks];
        for(int i = 0; i < tops.length; i++) {
            tops[i] = -1;
        }
        int numOfNodes = numOfStacks * 5;
        arr = new StacksNode[numOfNodes];
        // create the freelist
        freelist = new LinkedList();
        for(int i = numOfNodes - 1; i >= 0; i--) {
            freelist.add(i);
        }
    }

    public void push(int value, int stacknumber) {
        stacknumber -= 1;
        StacksNode node = new StacksNode(value);
        if(tops[stacknumber] != -1) {
            // had a top so set next to the current top
            node.setNext(tops[stacknumber]);
        }
        // make the new node a new top
        int index = freelist.remove();
        arr[index] = node;
        tops[stacknumber] = index;
    }

    public int pop(int stacknumber) {
        stacknumber -= 1;
        int index = tops[stacknumber];
        if(index == -1) {
            throw new IllegalArgumentException("Nothing left to pop");
        }
        StacksNode node = arr[index];
        freelist.add(index);
        tops[stacknumber] = node.getNext();
        return node.getValue();

    }

    @Override
    public String toString() {
        String str = "";
        if(arr != null && arr.length > 0) {
            int stacknumber = 1;
            for (int topIndex : tops) {
                if(topIndex < 0) {
                    str += "stack " + stacknumber + " empty\n";
                } else {
                    int index = topIndex;
                    str += "stack " + stacknumber + ": ";
                    while(index >= 0) {
                        str += arr[index].getValue() + " ";
                        index = arr[index].getNext();
                    }
                    str += "\n";
                }
                stacknumber++;
            }
            for(StacksNode node : arr) {
                str += node + " ";
            }
            str += "\n";
        }
        return str;
    }
}
