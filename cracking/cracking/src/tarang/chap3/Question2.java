package tarang.chap3;

import tarang.datastructures.MinStack;


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

