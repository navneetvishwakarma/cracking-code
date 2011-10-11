package tarang.chap1;


/**
 * Write code to reverse a C-Style String (C-String means that �abcd� is represented as five characters, including the
 * null character )
 *
 * @author tdesai
 */
public class Question2 {

    // O(n) in time
    public static String reverse(char[] chars) {
        int start = 0, end = chars.length-1;
        char temp;
        while(start < end) {
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++; end--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "harmo";
        System.out.println(str + ": " + Question2.reverse(str.toCharArray()));
    }
}
