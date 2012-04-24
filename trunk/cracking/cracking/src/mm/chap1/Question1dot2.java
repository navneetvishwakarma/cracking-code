package mm.chap1;


/**
 * Write code to reverse a C-Style String (C-String means that “abcd” is represented as five characters, including the null character )
 *
 * @author mmathuria
 */
public class Question1dot2 {
    
    public String reverse(String input){
        char[] chars = input.toCharArray();
        for(int i = 0, j = input.length()-1;i < j;i++,j--){
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Question1dot2 obj = new Question1dot2();
        System.out.println(obj.reverse("hello world"));
        System.out.println(obj.reverse("mihir"));
    }
}
