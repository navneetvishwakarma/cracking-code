package mm.chap1;


/**
 * Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2, 
 * write code to check if s2 is a rotation of s1 using only one call to isSubstring 
 * (i e , “waterbottle” is a rotation of “erbottlewat”)
 *
 * @author mmathuria
 */
public class Question1dot8 {
    
    public static boolean isRotation(String s1, String s2){
        return isSubstring(s1 + s1, s2);
    }
    
    private static boolean isSubstring(String s1, String s2){
        return s1.contains(s2);
    }

    public static void main(String[] args) {
        System.out.println(isRotation("hello","lohel"));
        System.out.println(isRotation("hello","lohee"));
    }
}
