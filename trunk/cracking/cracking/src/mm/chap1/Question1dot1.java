package mm.chap1;


import java.util.Arrays;

/**
 * Implement an algorithm to determine if a string has all unique characters What if you can not use additional data structures?
 *
 * @author mmathuria
 */
public class Question1dot1 {
    
    //O(n) runtime + O(n) memory
    public boolean isUnique1(String input){
        boolean chars[] = new boolean[256];
        for(char c : input.toCharArray()){
            if(chars[c]) return false;
            chars[c] = true;
        }
        return true;
    }

    //O(n log n)
    public boolean isUnique2(String input){
        char[] sortedChars = input.toCharArray();
        Arrays.sort(sortedChars);
        for(int i=0,j=1;j<input.length();i++,j++){
            if(sortedChars[i] == sortedChars[j]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Question1dot1 obj = new Question1dot1();

        final String str1 = "lskdjgf";
        final String str2 = "lskdjgpfeirup";

        System.out.println(obj.isUnique1(str1));
        System.out.println(obj.isUnique1(str2));

        System.out.println("\n");
        
        System.out.println(obj.isUnique2(str1));
        System.out.println(obj.isUnique2(str2));
    }
}
