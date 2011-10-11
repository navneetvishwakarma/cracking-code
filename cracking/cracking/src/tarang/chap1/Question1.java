package tarang.chap1;

import java.util.Arrays;


/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 *
 * @author tdesai
 */
public class Question1 {

    // O(n) in time and O(256) in space
    public static boolean unique(char[] chars) {
        if(chars.length < 2) {
            return false;
        }
        boolean[] bools = new boolean[256];
        for(char c : chars) {
            if(bools[c]) {
                return false;
            }
            bools[c] = true;
        }
        return true;
    }

    // O(n log(n)) in time
    public static boolean unique2(char[] chars) {
        if(chars.length < 2) {
            return false;
        }
        Arrays.sort(chars);
        char curr = chars[0];
        char next;
        for(int i = 1; i < chars.length; i++) {
            next = chars[i];
            if(curr == next) {
                return false;
            }
            curr = next;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "budy";
        System.out.println(str + ": " + Question1.unique(str.toCharArray()));
        System.out.println(str + ": " + Question1.unique2(str.toCharArray()));

        str = "missisippie";
        System.out.println(str + ": " + Question1.unique(str.toCharArray()));
        System.out.println(str + ": " + Question1.unique2(str.toCharArray()));

        str = "harmo";
        System.out.println(str + ": " + Question1.unique(str.toCharArray()));
        System.out.println(str + ": " + Question1.unique2(str.toCharArray()));
    }
}
