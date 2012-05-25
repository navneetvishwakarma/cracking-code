package tarang.careercup.amazon;


/**
 * Find if the given string is a palindrome. E.g. "..AB ,, CD, ED. CB...A..." is a palindrome.
 *
 * @author tdesai
 */
public class Question05 {

    // O(n)
    public static boolean isPalindrome(char[] chars) {
        int start = 0;
        int end = chars.length - 1;
        while(start < end) {
            while(start < end && !Character.isLetterOrDigit(chars[start])) {
                start++;    // advance until we hit a character that is letter or digit
            }
            while(start < end && !Character.isLetterOrDigit(chars[end])) {
                end--;  // advance until we hit a character that is letter or digit
            }
            if(start >= end) {
                return true;
            }
            if(chars[start] == chars[end]) {
                start++; end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeRecursive(char[] chars, int start, int end) {
        if(start > end) {
            return true;
        }
        if(!Character.isLetterOrDigit(chars[start])) {
            return isPalindromeRecursive(chars, ++start, end);
        }
        if(!Character.isLetterOrDigit(chars[end])) {
            return isPalindromeRecursive(chars, start, --end);
        }
        return chars[start] == chars[end] && isPalindromeRecursive(chars, ++start, --end);
    }

    public static void main(String[] args) {
        String str = "..AB ,, CD, ED. CB...A...";
        System.out.println(str + " -> " + isPalindrome(str.toCharArray()));
        System.out.println(str + " -> " + isPalindromeRecursive(str.toCharArray(), 0, str.length()-1));

    }
}
