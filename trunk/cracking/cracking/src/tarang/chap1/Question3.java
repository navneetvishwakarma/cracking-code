package cracking.src.tarang.chap1;

import java.util.Arrays;


/**
 * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer
 * NOTE: One or two additional variables are fine An extra copy of the array is not
 *
 * @author tdesai
 */
public class Question3 {

    // O(n log n)
    public static String removeDups(char[] chars) {
        Arrays.sort(chars);
        int i=0,j=1;
        while(j < chars.length - 1) {
            if(chars[i] == chars[j]) {
                j++;
            } else {
                i++;
                chars[i] = chars[j];
            }
        }
        i++;
        chars[i] = 0;
        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "missisippie";
        System.out.println(str + ": " + Question3.removeDups(str.toCharArray()));
    }
}
