package mm.chap9;


/**
 * Given a sorted array of strings which is interspersed with empty strings, write a meth- od to find the location of a
 *  given string
    Example: find “ball” in [“at”, “”, “”, “”, “ball”, “”, “”, “car”, “”, “”, “dad”, “”, “”] will return 4 
    Example: find “ballcar” in [“at”, “”, “”, “”, “”, “ball”, “car”, “”, “”, “dad”, “”, “”] will return -1
 *
 * @author mmathuria
 */
public class Question9dot5 {
    
    public int findIndex(String[] input, String key){
        return binarySearch(input,0,input.length-1,key);
    }
    
    
    private int binarySearch(String[] input, int lower, int upper, String key){
        if(lower > upper){
            return -1;
        }
        
        int middle = (lower + upper) / 2;
        
        int oldMiddle = middle;
        while("".equals(input[middle])){
            if(middle == upper){
                break;
            }
            middle++;
        }
        
        if(input[middle].equals(key)){
            return middle;
        }else if("".equals(input[middle]) || key.compareTo(input[middle]) < 0){
            return binarySearch(input,lower,oldMiddle-1,key);
        }else{
            return binarySearch(input,middle+1,upper,key);
        }
    }
}
