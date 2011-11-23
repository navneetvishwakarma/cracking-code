package mm.amazon;

import java.util.*;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Q09 {

    public List<Integer> findIntersection(int[] a, int[] b){
        List<Integer> intersection = new ArrayList<Integer>();
        Map<Integer, Integer> lookupMap;
        int[] walkThruArr;
        if(a.length < b.length){
            lookupMap = convertToMap(a);
            walkThruArr = b;
        }else{
            lookupMap = convertToMap(b);
            walkThruArr = a;
        }
        
        for(int i : walkThruArr){
            Integer entry = lookupMap.get(i);
            if(entry != null && entry > 0){
                intersection.add(i);
                lookupMap.put(i, --entry);
            }
        }
        return intersection;
    }
    
    
    private Map<Integer, Integer> convertToMap(int[] arr){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i : arr){
            Integer entry = map.get(i);
            if(entry == null){
                map.put(i, 1);
            }else{
                map.put(i, ++entry);
            }
        }
        return map;
    }
}
