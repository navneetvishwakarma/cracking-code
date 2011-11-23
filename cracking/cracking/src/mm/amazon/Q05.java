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
    }
    
    public static boolean isPalindrome(char[] str){
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
