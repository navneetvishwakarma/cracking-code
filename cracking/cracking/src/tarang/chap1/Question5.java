package tarang.chap1;


/**
 * Write a method to replace all spaces in a string with �%20�
 *
 * @author tdesai
 */
public class Question5 {

    public static String replaceSpaces(char[] str) {
        int spaceCnt = 0;
        for(char c : str) {
            if(c == ' ') {
                spaceCnt++;
            }
        }
        if(spaceCnt == 0) {
            return new String(str);
        }
        char[] newStr = new char[str.length + 2*spaceCnt];
        int i = 0;
        for(char c : str) {
            if(c == ' ') {
                newStr[i++] = '%';
                newStr[i++] = '2';
                newStr[i++] = '0';
            } else {
                newStr[i++] = c;
            }
        }
        return new String(newStr);
    }

    public static void main(String[] args) {
        String str = "I am a weakish speller";
        System.out.println(str + ": " + Question5.replaceSpaces(str.toCharArray()));
    }
}
