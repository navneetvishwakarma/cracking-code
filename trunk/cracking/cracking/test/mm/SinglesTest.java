package mm;

import junit.framework.TestCase;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class SinglesTest extends TestCase {
    
    
    public void testRemoveDup(){
        Singles singles = new Singles();

        String[] inputs = {"madam", "abcabc", "aa", "abc", "ab","aabbcc"};
        String[] expecteds = {"adm", "abc", "a", "abc", "ab","abc"};

        for(int i=0;i<inputs.length;i++){
            String output = singles.removeDups(inputs[i]);
            assertEquals("output does not match expected string", expecteds[i], output);
            System.out.println(expecteds[i] + "=" + output);
        }
    }
    
    
    public void testRemoveDupsNoSort(){
        Singles singles = new Singles();
        String[] inputs = {"madam", "abcabc","aa","abc","ab","aabbcc"};
        String[] expecteds = {"mad","abc","a","abc","ab","abc"};
        
        for(int i=0;i<inputs.length;i++){
            String output = singles.removeDupsNoSort(inputs[i]);
            assertEquals("output does not match expected string",expecteds[i],output);
            System.out.println(expecteds[i] + "=" + output);
        }
    }
}
