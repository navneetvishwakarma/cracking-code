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

    //same as replacedSpaces() but the while loop moves from 0 to end (instead of end to 0 above)
    public static String replacedSpaces2(String str){
        int spaceCount = 0;
        char[] s = str.toCharArray();
        for(char c : s){
            if(c == ' ') spaceCount++;
        }
        
        char[] c = new char[str.length() + (spaceCount*2)];
        
        int i = 0;
        int j = 0;
        while(i < s.length){
            if(s[i] == ' '){
                c[j] = '%';
                c[++j] = '2';
                c[++j] = '0';
            }else{
                c[j] = s[i];
            }
            i++;j++;
        }
        return new String(c);
    }
    
    //with stringbuilder
    public static String replacedSpaces3(String str){
        StringBuilder buf = new StringBuilder();
        for(char c : str.toCharArray()){
            if(c == ' '){
                buf.append('%');
                buf.append('2');
                buf.append('0');
            }else{
                buf.append(c);
            }
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        String str1 = "new apple device rocks";
        String str2 = " rocks ";
        System.out.println(replacedSpaces3(str1));        
        System.out.println(replacedSpaces3(str2));        
        System.out.println(replacedSpaces3(" "));
    }
}
