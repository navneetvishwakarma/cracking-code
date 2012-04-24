package mm.chap1;

import junit.framework.TestCase;
import mm.chap1.Question1dot3;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question1dot3Test extends TestCase {
    
    
    public void testRemoveDup(){
        Question1dot3 singles = new Question1dot3();

        String[] inputs = {"madam", "abcabc", "aa", "abc", "ab","aabbcc"};
        String[] expecteds = {"adm", "abc", "a", "abc", "ab","abc"};

        for(int i=0;i<inputs.length;i++){
            String output = singles.removeDups(inputs[i]);
            assertEquals("output does not match expected string", expecteds[i], output);
            System.out.println(expecteds[i] + "=" + output);
        }
    }
    
    
    public void testRemoveDupsNoSort(){
        Question1dot3 singles = new Question1dot3();
        String[] inputs = {"madam", "abcabc","aa","abc","ab","aabbcc",""};
        String[] expecteds = {"mad","abc","a","abc","ab","abc",""};
        
        for(int i=0;i<inputs.length;i++){
            String output = singles.removeDupsNoSort(inputs[i]);
            assertEquals("output does not match expected string",expecteds[i],output);
            System.out.println(expecteds[i] + "=" + output);
        }
    }
}
