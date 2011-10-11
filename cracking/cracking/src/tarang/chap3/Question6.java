package cracking.src.tarang.chap3;


/**
 * Write a program to sort a stack in ascending order You should not make any assump- tions about how the stack is
 * implemented	The following are the only functions that should be used to write this program: push | pop | peek | isEmpty
 *
 * @author tdesai
 */
public class Question6 {

    // O(n^2)
    public static void sort(int[] A) {
        if(A == null || A.length == 0) {
            throw new IllegalArgumentException("array A is null or empty");
        }
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        // create stack1
        for(int a : A) {
            stack1.push(a);
        }

        // one element in stack so it is sorted
        int value = stack1.pop();
        stack2.push(value);
        while(!stack1.isEmpty()) {
            value = stack1.pop();
            if(value < stack2.peek()) {
                // pop stack2 element is greater then value
                while (!stack2.isEmpty() && stack2.peek() > value) {
                    stack1.push(stack2.pop());
                }
            }
            stack2.push(value);
        }

        for(int i = A.length - 1; i >= 0; i--) {
            A[i] = stack2.pop();
        }
    }

    public static void main(String[] args) {
        int[] A = {3, 1, 4, 1, 5, 9, 2, 6, 5, 4};

        Question6.sort(A);
        String str = "";
        for(int a : A) {
            str += a + " ";
        }

        System.out.println(str.trim());
    }
}
