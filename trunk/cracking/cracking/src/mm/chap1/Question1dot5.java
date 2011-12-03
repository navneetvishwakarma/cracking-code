package mm.chap1;


/**
 * Replace all spaces in String with %20
 *
 * @author mmathuria
 */
public class Question1dot5 {
    
    public static String replacedSpaces(String str){
        int spaceCount = 0;
        char[] s = str.toCharArray();
        for(char c : s){
            if(c == ' ') spaceCount++;
        }
        
        char[] c = new char[str.length() + (spaceCount*2)];
        
        int i = s.length-1;
        int j = c.length-1;
        while(i >= 0){
            if(s[i] == ' '){
                c[j] = '0';
                c[--j] = '2';
                c[--j] = '%';
            }else{
                c[j] = s[i];
            }
            i--;j--;
        }
        return new String(c);
    }

    public static void main(String[] args) {
        String str1 = "new apple device rocks";
        String str2 = "rocks";
        System.out.println(replacedSpaces(str1));        
        System.out.println(replacedSpaces(str2));        
        System.out.println(replacedSpaces(" "));        
    }
}
