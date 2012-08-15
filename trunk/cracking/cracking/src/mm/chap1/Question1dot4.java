package mm.chap1;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question1dot4 {
    
    public boolean araAnagrams1(String str1, String str2){
        if(str1 == null || str2 == null) return false;
        
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        
        Arrays.sort(c1);
        Arrays.sort(c2);
        
        return new String(c1).equals(new String(c2));
        
    }
    
    public boolean areAnagrams2(String str1, String str2){
        if(str1 == null || str2 == null) return false;
        
        if(str1.length() != str2.length()) return false;
        
        Map<Character, Integer> map1 = charToCountMap(str1);
        for(char c : str2.toCharArray()){
            Integer count = map1.get(c);
            if(count == null || count <= 0) return false;
            map1.put(c,--count);
        }
        
        return true;
    }

    public boolean areAnagrams3(String str1, String str2){
        if(str1 == null || str2 == null) return false;

        Map<Character,Integer> map1 = charToCountMap(str1);
        Map<Character,Integer> map2 = charToCountMap(str2);
        
        if(map1.size() != map2.size()) return false;
        
        for(Character key : map1.keySet()){
            int count1 = map1.get(key);
            int count2 = map2.get(key);
            
            if(count1 != count2) return false;
        }
        
        return true;
    }
    
    private Map<Character,Integer> charToCountMap(String string){
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for(char c : string.toCharArray()){
            if(map.containsKey(c)){
                int count = map.get(c);
                map.put(c,++count);
            }else{
                map.put(c,1);
            }
        }
        return map;
    }
    
}
