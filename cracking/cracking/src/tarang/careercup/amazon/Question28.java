package tarang.careercup.amazon;


import java.util.*;

/**
 * Write a recursive and non-recursive program to generate all possible substrings of a string.
 *
 * @author tdesai
 */
public class Question28 {

    public static Set<String> subStrings1(String str) {
        // non-recursive way
        Set<String> substrings = new HashSet<String>();
        for(int i = 1; i <= str.length(); i++) {
            for(int j = 0; j+i  <= str.length(); j++) {
                String temp = "";
                for(int k = j; k < j + i; k++) {
                    temp += str.charAt(k);
                }
                substrings.add(temp);
            }
        }
        return substrings;
    }

    private static void subsets(Set<String> substrings, char[] chrs, int index) {
        if(index == chrs.length) {
            return;
        }
        Set<String> substrings2 = new HashSet<String>(substrings);
        for(String str : substrings2) {
            if(str.length() > 0 && str.charAt(str.length() - 1) != chrs[index-1]) {
                continue;
            }
            str += chrs[index];
            substrings.add(str);
        }
        subsets(substrings, chrs, ++index);
    }

    public static Set<String> subStrings2(String str) {
        // recursive way
        Set<String> substrings = new HashSet<String>();
        substrings.add("");
        subsets(substrings, str.toCharArray(), 0);
        return substrings;
    }

    public static void main(String[] args) {
        Set<String> substrings = subStrings2("abcd");   // a, b, c, d, ab, bc, cd, abc, bcd, abcd
        List<String> list = new ArrayList<String>(substrings);
        Collections.sort(list);
        for(String str : list) {
            System.out.println(str);
        }
    }
}
