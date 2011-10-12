package tarang.datastructures;


/**
 * Queue implemented with two stacks
 *
 * @author tdesai
 */
public class StackQueue {
    private Stack stack1;
    private Stack stack2;

    public StackQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    // add an element to the back of the queue
    public void push(int value) {
        stack1.push(value);
    }

    // remove an element from front of the queue
    public int pop() {
        if(stack2.getSize() == 0) {
            if(stack1.getSize() > 0) {
                while (stack1.getSize() > 0) {
                    stack2.push(stack1.pop());
                }
            } else {
                throw new IllegalArgumentException("Queue is empty");
            }
        }
        return stack2.pop();
    }

    @Override
    public String toString() {
        return "stack1: " + this.stack1 + " stack2: " + this.stack2;
    }
}
