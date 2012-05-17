package tarang.chap1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Write a method to decide if two strings are anagrams or not
 *
 * @author tdesai
 */
public class Question4 {

    public static boolean anagrams(char[] str1, char[] str2) {
        if(str1.length != str2.length) {
            return false;
        }
        Arrays.sort(str1);
        Arrays.sort(str2);
        return new String(str1).equals(new String(str2));
    }

    public static boolean anagrams2(char[] str1, char[] str2) {
        // use a hashmap
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : str1) {
            Integer count = map.get(c);
            if(count == null) {
                count = 1;
            } else {
                count++;
            }
            map.put(c, count);
        }

        for(char c : str2) {
            Integer count = map.get(c);
            if(count == null) {
                return false;
            } else {
                count--;
            }
            map.put(c, count);
        }

        for(Integer count : map.values()) {
            if(count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "logarithm";
        String str2 = "algorithm";
        System.out.println(str1 + "=" + str2 + " " + Question4.anagrams(str1.toCharArray(), str2.toCharArray()));
        System.out.println(str1 + "=" + str2 + " " + Question4.anagrams2(str1.toCharArray(), str2.toCharArray()));
        System.out.println();

        str1 = "orchestra";
        str2 = "carthorse";
        System.out.println(str1 + "=" + str2 + " " + Question4.anagrams(str1.toCharArray(), str2.toCharArray()));
        System.out.println(str1 + "=" + str2 + " " + Question4.anagrams2(str1.toCharArray(), str2.toCharArray()));
        System.out.println();

        str1 = "orchestra";
        str2 = "farthorse";
        System.out.println(str1 + "=" + str2 + " " + Question4.anagrams(str1.toCharArray(), str2.toCharArray()));
        System.out.println(str1 + "=" + str2 + " " + Question4.anagrams2(str1.toCharArray(), str2.toCharArray()));
    }
}
