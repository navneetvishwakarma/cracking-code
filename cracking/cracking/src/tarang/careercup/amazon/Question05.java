package tarang.careercup.amazon;


/**
 * Find if the given string is a palindrome. E.g. "..AB ,, CD, ED. CB...A..." is a palindrome.
 *
 * @author tdesai
 */
public class Question05 {

    public static boolean isPalindrome(char[] chars) {
        int start = 0;
        int end = chars.length - 1;
        while(start < end) {
            if(!Character.isLetterOrDigit(chars[start])) {
                start++;
            }
            if (!Character.isLetterOrDigit(chars[end])) {
                end--;
            }
            if(Character.isLetterOrDigit(chars[start]) && Character.isLetterOrDigit(chars[end])) {
                if(chars[start] != chars[end]) {
                    return false;
                }
                start++; end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "..AB ,, CD, ED. CB...A...";
        System.out.println(str + " -> " + isPalindrome(str.toCharArray()));

    }
}
