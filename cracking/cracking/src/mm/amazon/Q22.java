package mm.amazon;


import java.util.ArrayList;
import java.util.List;

/**
 22) print all palindromes of size k possible from given alphabet set.
 eg alphabet set : {a,e,i,o,u}
 print all palindromes of size say 10.
 */
public class Q22 {
    public List<String> genPalindromes(char[] str, int ctr, int baseLen){
        if(ctr == (baseLen / 2)){
            if(baseLen % 2 == 0){
                return listOfEmptyStrings(str.length);
            }else {
                return listOfStrings(str);
            }
        }
        
        List<String> output = new ArrayList<String>();
        for(char c : str){
            String s = c+"";
            List<String> subList = genPalindromes(str, ctr + 1, baseLen);
            for(String subStr : subList){
                output.add(s + subStr + s);
            }
        }
        return output;
    }
    
    private List<String> listOfEmptyStrings(int len){
        List<String> list = new ArrayList<String>();
        list.add("");
        return list;
    }
    
    private List<String> listOfStrings(char[] src){
        List<String> list = new ArrayList<String>();
        for(char c : src){
            list.add(c+"");
        }
        return list;
    }
}
