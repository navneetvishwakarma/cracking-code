package tarang.careercup.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Given two integer arrays, find their intersection. E.g.: arr1 = {8, 15, 23, 32, 44, 91, 3},
 * arr2 = {18, 2, 32, 44, 91, 18} -> {32, 44, 91}
 *
 * @author tdesai
 */
public class Question09 {

    // O(n) + O(m) solution. space complexity is O(n) or O(m), whichever is smaller.
    public static List<Integer> intersection(int[] A, int[] B) {
        Map<Integer, Integer> oneset = new HashMap<Integer, Integer>();
        int[] ref_copy1 = B;
        int[] ref_copy2 = A;
        if(A.length < B.length) {
            ref_copy1 = A;
            ref_copy2 = B;
        }
        Integer cnt;
        for (int anInt : ref_copy1) {
            cnt = oneset.get(anInt);
            if (cnt == null) {
                oneset.put(anInt, 1);
            } else {
                oneset.put(anInt, cnt + 1);
            }
        }
        List<Integer> intersect = new ArrayList<Integer>();
        for(int anInt : ref_copy2) {
            cnt = oneset.get(anInt);
            if(cnt != null && cnt > 0) {
                intersect.add(anInt);
                oneset.put(anInt, --cnt);
            }
        }
        return intersect;
    }

    public static void main(String[] args) {
        List<Integer> result = Question09.intersection(new int[]{8, 15, 23, 32, 44, 91, 3}, new int[]{18, 2, 32, 32, 44, 91, 18});
        for(int a : result) {
            System.out.print(a + " ");
        }
    }
}
