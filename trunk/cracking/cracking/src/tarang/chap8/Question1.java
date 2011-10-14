package tarang.chap8;


/**
 * Write a method to generate the nth Fibonacci number
 *
 * @author tdesai
 */
public class Question1 {

    public static int fib(int i) {
        return i < 2 ? i : fib(i - 1) + fib(i - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
    }
}
