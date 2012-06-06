package tarang.careercup.amazon;


import java.util.Arrays;

/**
 There are two methods:
 void process(int[] A) and void enumerate(int base, int digits);
 call process with an array for given values of base and digit params:
 base = 2, digits = 3. Call process() for the following arrays:
 A = {0, 0, 0}
 A = {0, 0, 1}
 A = {0, 1, 0}
 A = {0, 1, 1}
 A = {1, 0, 0}
 A = {1, 0, 1}
 A = {1, 1, 0}
 A = {1, 1, 1}

 base = 10, digits = 2. Call process() for all possible numbers with length 2 in base 10. There will be 100 of them.
 So implement enumerate to call process. Cannot change signatures but can create your own methods.
 *
 * @author tdesai
 */
public class Question34 {

    public static void process(int[] A) {
        System.out.println(Arrays.toString(A));
    }

    public static void enumerate(int base, int digits) {
        enumerateInternal(base, digits - 1, new int[digits]);
    }

    public static void enumerateInternal(int base, int digits, int[] A) {
        if(digits == -1) {
            process(A);
            return;
        }
        for(int i = 0; i < base; i++) {
            A[digits] = i;
            enumerateInternal(base, digits - 1, A);
        }
    }

    public static void main(String[] args) {
        enumerate(2, 3);
    }
}
