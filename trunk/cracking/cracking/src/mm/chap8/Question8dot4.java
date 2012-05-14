package mm.chap8;


import java.util.ArrayList;

/**
 * Write a method to compute all permutations of a string
 *
 * @author mmathuria
 */
public class Question8dot4 {
    
    //logic very similar to qn8.3
    
    public ArrayList<String> getPerms(String s){
        if(s.length() == 2){
            ArrayList<String> list = new ArrayList<String>();
            list.add("" + s.charAt(0) + s.charAt(1));
            list.add("" + s.charAt(1) + s.charAt(0));
            return list;
        }
        
        ArrayList<String> allPerms = new ArrayList<String>();
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            String newS = s.replace(""+c,"");
            ArrayList<String> perms = getPerms(newS);
            for(String str : perms){
                allPerms.add(c + str);
            }
        }
        
        return allPerms;
    }


    public ArrayList<String> getPerms2(String s){
        ArrayList<String> allPerms = new ArrayList<String>();
        
        if(s.length() == 2){
            ArrayList<String> list = new ArrayList<String>();
            list.add("" + s.charAt(0) + s.charAt(1));
            list.add("" + s.charAt(1) + s.charAt(0));
            return list;
        }
    
        char head = s.charAt(0);
        String remaining = s.substring(1);
        ArrayList<String> perms = getPerms(remaining);
        for(String perm : perms){
            for(int j=0; j<=perm.length();j++){
                allPerms.add(insertCharAt(perm, head, j));        
            }
        }

        return allPerms;
    }
    
    private String insertCharAt(String word, char c, int j){
        String start = word.substring(0,j);
        String end = word.substring(j);
        return start + c + end;
    }
}
