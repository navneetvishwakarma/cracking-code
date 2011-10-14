package tarang.chap8;


/**
 * Write a method to generate the nth Fibonacci number
 *
 * @author tdesai
 */
public class Question1 {


    // recursive
    public static int fib(int i) {
        return i < 2 ? i : fib(i - 1) + fib(i - 2);
    }

    // iterative
    public static int fib2(int i) {
        if(i < 2) {
            return i;
        }
        int prev_1 = 1;
        int prev_2 = 0;
        int sum = 0;  // for n = 2
        for(int k = 2; k <= i; k++) {
            sum = prev_1 + prev_2;
            prev_2 = prev_1;
            prev_1 = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(fib2(10));
    }
}
