package mm.amazon;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Write a recursive and non-recursive program to generate all possible substrings of a string.
 */
public class Q28 {

    /**
     * Similar to 8.3 and 8.4
     * 
     * for input "abcd":
     * last level returns a list of single String "d"
     * other levels loop through the recd list looking for a string that starts with a character whose index is 1 more than 
     * the current level char, eg, 
     * at level "c" : look for strings starting with "d'; when found prepend self to make "cd"
     * at level "b": skip "d", but prepend "c" and "cd" to create "bc" and "bcd"
     * @param src
     * @return
     */
    public List<String> makeSubstrings(String src){
        if(src.length() == 1){
            ArrayList<String> list = new ArrayList<String>();
            list.add(src);
            return list;
        }
        
        char head = src.charAt(0);
        String remainder = src.substring(1);
        List<String> strings = new ArrayList<String>();
        
        List<String> substrings = makeSubstrings(remainder);
        for (String substring : substrings) {
            char firstCharOfSubstring = substring.charAt(0);
            if (src.indexOf(firstCharOfSubstring) == 1) {
                strings.add(head + substring);
            }
        }
        strings.add(""+head);
        strings.addAll(substrings);
        return strings;
    }

    public static void main(String[] args) {
        Q28 obj = new Q28();
        List<String> substrings = obj.makeSubstrings("abcd");
        Collections.sort(substrings);
        System.out.println(substrings);
    }
}
