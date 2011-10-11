package tarang.chap1;


/**
 * Assume you have a method isSubstring which checks if one word is a substring of another Given two strings, s1 and s2,
 *  write code to check if s2 is a rotation of s1 using only one call to isSubstring (i e , �waterbottle� is a rotation
 * of �erbottlewat�)
 *
 * @author tdesai
 */
public class Question8 {

    public static boolean rotation(String s1, String s2) {
        return isSubstring(s2 + s2, s1);
    }

    public static boolean isSubstring(String str1, String str2) {
        return str1.contains(str2);
    }

    public static void main(String[] args) {
        String str1 = "waterbottle";
        String str2 = "erbottlewat";
        System.out.println(str1 + " : " + str2 + " -> " + Question8.rotation(str1, str2));
    }
}
