package mm.amazon;


/**
 * We are given three strings: s1, s2, s3
 s3 is said to be a valid shuffle of s1 and s2 if it can be formed by interleaving the characters of s1 and s2 in a way 
 that maintains the left to right ordering of the characters from each string. s1="dude", s2="dog", valid s3="dodudeg"
 Write code that will detect if s3 is a valid shuffle of s1 and s2.
 */
public class Q40 {

    public boolean isShuffle(String s1, String s2, String s3){
        if(s1 == null && s2 == null){
            return s3 == null;
        }
        if(s1 == null || s1.length() == 0){
            return s2.equals(s3);
        }
        if(s2 == null || s2.length() == 0){
            return s1.equals(s3);
        }
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }

        if(s1.charAt(0) == s3.charAt(0) && isShuffle(s1.substring(1), s2, s3.substring(1))){
            return true;
        }

        if(s2.charAt(0) == s3.charAt(0) && isShuffle(s1, s2.substring(1), s3.substring(1))){
            return true;
        }

        return false;


    }

    public static void main(String[] args) {
        Q40 obj = new Q40();

        System.out.println(obj.isShuffle("abc", "def", "adebcf"));
        System.out.println(obj.isShuffle(null, "", "def"));
        System.out.println(obj.isShuffle("dude","dog","dodudeg"));
        System.out.println(obj.isShuffle("dude", "dog", "dudedog"));

    }
}
