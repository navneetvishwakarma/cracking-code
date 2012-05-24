package tarang.careercup.amazon;


/**
 * Delete extra spaces in a string
 *
 * @author tdesai
 */
public class Question29 {

    public static String fullTrim(String str) {
        char[] chrs = str.toCharArray();
        int j = 0;
        for(int i = 0; i < str.length(); i++) {
            if(chrs[i] != ' ') {
                if(i > j) {
                    // swap i and j
                    char temp = chrs[i];
                    chrs[i] = chrs[j];
                    chrs[j] = temp;
                }
                j++;
            }
        }
        String res = "";
        for(int i = 0; i < j; i++) {
            res += chrs[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fullTrim("min i m  um"));
        System.out.println(fullTrim(" min i m  um"));
        System.out.println(fullTrim("   minim  um "));
        System.out.println(fullTrim("minimum"));
    }
}
