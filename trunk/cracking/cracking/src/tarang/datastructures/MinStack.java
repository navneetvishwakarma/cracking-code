package tarang.datastructures;


/**
 * MinStacks push(), pop() and min() all in O(1) at the cost of another internal stack for mins
 *
 * @author tdesai
 */
public class MinStack {
    private StackNode top;
    private StackNode min;

    public MinStack() {

    }

    public void push(int value) {
        StackNode node = new StackNode(value);
        if(top != null) {
            node.setNext(top);
        }
        top = node;
        if(min == null) {
            min = new StackNode(value);
        } else if(min.getValue() >= value) {
            node = new StackNode(value);
            node.setNext(min);
            min = node;
        }
    }

    public int pop() {
        if(top == null) {
            throw new IllegalArgumentException("Stack is empty");
        }
        int value = top.getValue();
        top = top.getNext();
        if(value == min.getValue()) {
            // pop min
            min = min.getNext();
        }
        return value;
    }

    public int min() {
        // return the min
        if(min == null) {
            throw new IllegalArgumentException("Stack is empty");
        } else {
            return min.getValue();
        }
    }

    @Override
    public String toString() {
        StackNode node = top;
        String str = "";
        while(node != null) {
            str += node.getValue() + " ";
            node = node.getNext();
        }
        str += "\n";
        node = min;
        while (node != null) {
            str += node.getValue() + " ";
            node = node.getNext();
        }
        return str.trim();
    }
}
