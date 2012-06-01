package tarang.careercup.amazon;


/**
 * Delete extra spaces in a string
 *
 * @author tdesai
 */
public class Question29 {

    public static String fullTrim(String str) {
        char[] chrs = str.toCharArray();
        int i, j;
        for(i = j = 0; i < str.length(); i++) {
            if(chrs[i] != ' ') {
                if(i > j) {
                    // swap i and j
                    chrs[j] = chrs[i];
                }
                j++;
            }
        }
        return new String(chrs, 0, j);
    }

    public static void main(String[] args) {
        System.out.println(fullTrim("min i m  um"));
        System.out.println(fullTrim(" min i m  um"));
        System.out.println(fullTrim("   minim  um "));
        System.out.println(fullTrim("minimum"));
    }
}
