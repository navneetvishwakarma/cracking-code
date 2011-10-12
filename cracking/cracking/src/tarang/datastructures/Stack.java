package tarang.datastructures;


/**
 * My very own Stack
 *
 * @author tdesai
 */
public class Stack {
    private StackNode top;
    private int size = 0;

    public void push(int value) {
        StackNode node = new StackNode(value);
        if (top != null) {
            node.setNext(top);
        }
        top = node;
        size++;
    }

    public int pop() {
        if (top == null) {
            throw new IllegalArgumentException("Stack is empty");
        }
        int value = top.getValue();
        top = top.getNext();
        size--;
        return value;
    }

    public int peek() {
        if (top == null) {
            throw new IllegalArgumentException("Stack is empty");
        }
        return top.getValue();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StackNode node = top;
        String str = "";
        while (node != null) {
            str += node.getValue() + " ";
            node = node.getNext();
        }
        return str.trim();
    }
}
