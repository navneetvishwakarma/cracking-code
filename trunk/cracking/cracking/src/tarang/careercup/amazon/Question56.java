package tarang.careercup.amazon;


/**
 * Given a function, take a number and the bit position and return true if that bit is set to 1 and false otherwise.\
 *
 * Find the number of set bits in the given number.
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

    public static int numSet1(int number) {
        int k = 1;
        int count = 0;
        while(k <= number) {
            if((number & k) == k) {
                count++;
            }
            k = k << 1;
        }
        return count;
    }

    public static void main(String[] args) {
        /*System.out.println(isSet1(16, 2) + " " + Integer.toBinaryString(16));
        System.out.println(isSet1(15, 2));
        System.out.println(isSet1(14, 1));
        System.out.println(isSet1(11, 3));
*/
        float x = 16.15f;
        int int_x = (int) x;
        int dec_x = (int) ((x - int_x) * 10000);

        System.out.println(int_x + " " + dec_x);

        System.out.println(numSet1(16) + " " + Integer.toBinaryString(16));
        System.out.println(numSet1(15) + " " + Integer.toBinaryString(15));
        System.out.println(numSet1(11) + " " + Integer.toBinaryString(11));
    }
}
