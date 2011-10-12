package tarang.chap3;

import tarang.datastructures.StackQueue;


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

