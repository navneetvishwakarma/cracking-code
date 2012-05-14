package mm.chap8;


import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question8dot3Test extends TestCase {
    Question8dot3 testObj = new Question8dot3();
    
    public void testGenerateSubsets(){
        ArrayList<Integer> set = new ArrayList<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);

        ArrayList<ArrayList<Integer>> allSubsets = testObj.generateSubsetsIterative(set);
        assertNotNull("",allSubsets);
        assertEquals("",8,allSubsets.size());
        
    }

    public void testEmptyGenerateSubsets(){
        ArrayList<Integer> set = new ArrayList<Integer>();

        ArrayList<ArrayList<Integer>> allSubsets = testObj.generateSubsetsIterative(set);
        assertNotNull("",allSubsets);
        assertEquals("",1,allSubsets.size());
    }
}
