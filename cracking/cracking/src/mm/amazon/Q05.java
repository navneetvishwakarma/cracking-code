package mm.amazon;


/**
 * Find if the given string is a palindrome. E.g. "..AB ,, CD, ED. CB...A..." is a palindrome.
 *
 * @author mmathuria
 */
public class Q05 {

    public static void main(String[] args) {
        String str  = "..AB ,, CD, ED. CB...A...";
        System.out.println(str  + "\t\t" + isPalindrome(str .toCharArray()));

        str = "..AAB ,, CD, ED. CB...A...";
        System.out.println(str  + "\t\t" + isPalindrome(str .toCharArray()));

        str = "...B..";
        System.out.println(str  + "\t\t" + isPalindrome(str .toCharArray()));

        str = "..A...A";
        System.out.println(str  + "\t\t" + isPalindrome(str .toCharArray()));
    }
    
    public static boolean isPalindrome(char[] str){
        int i = 0;
        int j = str.length-1;
        
        while(i < j){
            while(!Character.isLetterOrDigit(str[i]) && i<j){
                i++;
            }
            while(!Character.isLetterOrDigit(str[j])  && i<j){
                j--;
            }
            
            if(Character.isLetterOrDigit(str[i]) && Character.isLetterOrDigit(str[j])){
                if(str[i] != str[j]){
                    return false;
                }
                i++;j--;
            }
            
        }
        return true;
    }
    
    public static boolean isPalindrome2(char[] str){
        int start = -1;
        int end = str.length;
        
        while(start < end){
            while(!Character.isLetterOrDigit(str[++start]));
            while(!Character.isLetterOrDigit(str[--end]));
            
            if(str[start] != str[end]){
                return false;
            }
        }
        
        return true;
    }
}
