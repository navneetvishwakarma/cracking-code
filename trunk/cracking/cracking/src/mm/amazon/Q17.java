package mm.amazon;


/**
 * Given a function, take a number and the bit position and return true if that bit is set to 1 and false otherwise.
 */
public class Q17 {
    
    public static boolean isSet(int n, int pos){
        n = n >> pos;
        return ((n & 1) == 1);
    }

    public static void main(String[] args) {
        System.out.println(isSet(8,3));
        System.out.println(isSet(23,3));//10111
        System.out.println(isSet(23,2));//10111
    }
}
