package tarang.chap3;


/**
 * How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum
 * element? Push, pop and min should all operate in O(1) time
 *
 * @author tdesai
 */
public class Question2 {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(29);
        stack.push(81);
        stack.push(8);
        stack.push(13);
        stack.push(1);
        System.out.println(stack);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.min());
    }
}

class MinStack {
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