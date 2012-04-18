package tarang.careercup.amazon;


import java.util.*;

/**
 *
 print all palindromes of size k possible from given alphabet set.
 eg alphabet set : {a,e,i,o,u}
 print all palindromes of size say 10.
 *
 * @author tdesai
 */
public class Question22 {


    public static void palindromes(char[] letters, int k, int position, char[] str, Set<String> result) {
        for(char c : letters) {
            char[] str_copy = str.clone();
            str_copy[position] = c;
            str_copy[(k-1)-position] = c;
            if(position == k/2) {
                // finished
                result.add(new String(str_copy));
            } else {
                palindromes(letters, k, position+1, str_copy, result);
            }
        }
    }

    public static void main(String[] args) {
        int k = 3;
        char[] str = new char[k];
        Set<String> result = new HashSet<String>();
        palindromes(new char[]{'a', 'e', 'i', 'o', 'u'}, k, 0, str, result);
        System.out.println("Total: " + result.size());
        List<String> result_sorted = new ArrayList<String>(result);
        Collections.sort(result_sorted);
        for(String x : result_sorted) {
            System.out.println(x);
        }
    }
}
