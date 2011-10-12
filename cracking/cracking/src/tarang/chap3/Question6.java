package tarang.chap3;

import tarang.datastructures.Stack;


/**
 * Write a program to sort a stack in ascending order You should not make any assump- tions about how the stack is
 * implemented	The following are the only functions that should be used to write this program: push | pop | peek | isEmpty
 *
 * @author tdesai
 */
public class Question6 {

    // O(n^2)
    public static Stack sort(Stack stack1) {
        if(stack1.isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }
        Stack stack2 = new Stack();

        // one element in stack so it is sorted
        int value = stack1.pop();
        stack2.push(value);
        while(!stack1.isEmpty()) {
            value = stack1.pop();
            if(value > stack2.peek()) {
                // pop stack2 element is greater then value
                while (!stack2.isEmpty() && stack2.peek() < value) {
                    stack1.push(stack2.pop());
                }
            }
            stack2.push(value);
        }
        return stack2;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(1);
        stack.push(5);
        stack.push(9);
        stack.push(2);
        stack.push(6);
        stack.push(5);
        stack.push(4);

        stack = Question6.sort(stack);
        String str = "";
        while(!stack.isEmpty()) {
            str += stack.pop() + " ";
        }

        System.out.println(str.trim());
    }
}
