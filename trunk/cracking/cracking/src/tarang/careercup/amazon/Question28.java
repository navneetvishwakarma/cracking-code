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
            // all substring starting at position 0, 1, 2 in j going up to i and i going from 1 to n
            for(int j = 0; j+i  <= str.length(); j++) {
                String temp = "";
                // substring is str[j : j + i - 1]
                for(int k = j; k < j + i; k++) {
                    temp += str.charAt(k);
                }
                substrings.add(temp);
            }
        }
        return substrings;
    }

    private static void subsets(Map<String, Integer> substrings, char[] chrs, int index) {
        if(index == chrs.length) {
            return;
        }
        Map<String, Integer> substrings2 = new HashMap<String, Integer>(substrings);
        for(String str : substrings2.keySet()) {
            if (substrings.get(str) == -1 || substrings.get(str) == index - 1) {
                str += chrs[index];
                substrings.put(str, index);
            }
        }
        subsets(substrings, chrs, ++index);
    }

    public static Map<String, Integer> subStrings2(String str) {
        // recursive way
        Map<String, Integer> substrings = new HashMap<String, Integer>();
        substrings.put("", -1);
        subsets(substrings, str.toCharArray(), 0);
        return substrings;
    }

    public static void main(String[] args) {
        Map<String, Integer> substrings = subStrings2("abcd");   // a, b, c, d, ab, bc, cd, abc, bcd, abcd
        List<String> list = new ArrayList<String>(substrings.keySet());
        Collections.sort(list);
        for(String str : list) {
            System.out.println(str);
        }
    }
}
