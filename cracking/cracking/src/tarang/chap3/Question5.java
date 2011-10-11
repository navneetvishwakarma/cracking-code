package tarang.chap3;


/**
 * Implement a MyQueue class which implements a queue using two stacks
 *
 * @author tdesai
 */
public class Question5 {

    public static void main(String[] args) {
        StackQueue queue = new StackQueue();
        queue.push(18);
        queue.push(19);
        queue.push(21);
        queue.push(3);
        queue.push(1);
        queue.push(21);

        System.out.println(queue);
        System.out.println(queue.pop());
        System.out.println(queue.pop());

        queue.push(89);
        queue.push(14);
        System.out.println(queue);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

        System.out.println(queue);
    }
}

class StackQueue {
    private Stack stack1;
    private Stack stack2;

    StackQueue() {
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