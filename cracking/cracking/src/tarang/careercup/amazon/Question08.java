package tarang.careercup.amazon;


/**
 * If there is a n-digit, print the digits one by one without using temporary storage and how will you do it efficiently?
 * Example: if the number is 1054 print: 1 0 5 4
 *
 * @author tdesai
 */
public class Question08 {

    // O(n)
    public static void print(int number) {
        if(number == 0) {
            return;
        }
        int digit = number % 10;
        number = (number - digit) / 10;
        print(number);
        System.out.print(digit + " ");
    }

    public static void main(String[] args) {
        System.out.print(1054 + " -> ");
        print(1054);
    }
}
