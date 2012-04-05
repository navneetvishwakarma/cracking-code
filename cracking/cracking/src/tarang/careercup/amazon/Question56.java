package tarang.careercup.amazon;


/**
 * Given a function, take a number and the bit position and return true if that bit is set to 1 and false otherwise.
 *
 * @author tdesai
 */
public class Question56 {

    public static boolean isSet1(int number, int pos) {
        int k = 1;

        for(int i = 1; i <= pos; i++) {
            k = k << 1;
        }
        return (number & k) == k;
    }

    public static void main(String[] args) {
        System.out.println(isSet1(16, 2) + " " + Integer.toBinaryString(16));
        System.out.println(isSet1(15, 2));
        System.out.println(isSet1(14, 1));
        System.out.println(isSet1(11, 3));
    }
}
