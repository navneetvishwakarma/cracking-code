package mm.amazon;


/**
 * Delete extra spaces in a string
 */
public class Q29 {
    
    public static String deleteSpaces(String str){
        if(str == null || str.length() == 0) throw new IllegalAccessError("String cannot be null or empty");

        char[] chars = str.toCharArray();
        int i=0;

        for(int j=0; j<chars.length;j++){
            if(chars[j] != ' '){
                chars[i++] = chars[j];    
            }
        }

        return new String(chars,0,i);
    }
    
    public static String deleteExtraSpaces(String str){
        if(str == null || str.length() == 0) throw new IllegalAccessError("String cannot be null or empty");
        
        char[] chars = str.toCharArray();
        int i=0;

        boolean flag = (chars[0] == ' ');
        for(int j=0; j<chars.length;j++){
            if(chars[j] == ' ' && flag){
                continue;
            }
            
            if(chars[j] != ' '){
                flag = false;
            } else if(chars[j] == ' '){
                flag = true;
            }
            
            chars[i++] = chars[j];
            
        }
                
        return new String(chars,0,i);
    }

    public static void main(String[] args) {
        System.out.println(deleteExtraSpaces("hello   world  ssup?  "));
        System.out.println(deleteExtraSpaces("  hello   world  ssup?"));
        System.out.println(deleteExtraSpaces("hello world!"));

        System.out.println("\n\n");
        System.out.println(deleteSpaces("hello   world  ssup?  "));
        System.out.println(deleteSpaces("  hello   world  ssup?"));
        System.out.println(deleteSpaces("hello world!"));
    }
}
