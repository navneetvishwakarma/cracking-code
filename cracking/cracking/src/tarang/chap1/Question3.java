package tarang.chap1;

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

    // O(n^2)
    public static String removeDups2(char[] chars) {
        if (chars.length < 2) {
            return new String(chars);
        }

        int tail = 1;
        for(int i = 1; i < chars.length; i++) {
            // go through all characters starting with index 1
            int j;
            for(j = 0; j < tail; j++) {
                // go through all characters starting with index 0 to tail. 0 to tail is all non dup characters
                if(chars[i] == chars[j]) {
                    // char[i] already seen so should be overwritten by the next character
                    break;
                }
            }
            if(j == tail) {
                // we made it to the end so this character can be included in the clean section
                chars[tail] = chars[i];
                tail++;

            }
        }
        if(chars.length != tail) {
            chars[tail] = 0;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "missisippie";
        System.out.println(str + ": " + Question3.removeDups2(str.toCharArray()));
    }
}
