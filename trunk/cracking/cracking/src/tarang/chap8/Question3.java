package tarang.chap8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * Write a method that returns all subsets of a set
 * todo: incomplete
 * @author tdesai
 */
public class Question3 {

    public static void subsets(Set<String> input, Set<Set<String>> result) {

    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>(Arrays.asList("A", "B", "C"));
        Set<Set<String>> result = new HashSet<Set<String>>();
        subsets(set, result);
        int count = 1;
        for(Set<String> resultset : result) {
            String str = "{";
            for(String setelement : resultset) {
                str += setelement + ",";
            }
            str = str.substring(0, str.lastIndexOf(','));
            System.out.println(count + ") " + str);
        }
    }
}
