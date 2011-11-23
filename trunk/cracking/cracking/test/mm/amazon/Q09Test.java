package mm.amazon;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Q09Test extends TestCase {
    
    public void testFindIntersection(){
        Q09 q09 = new Q09();
        
        int[] a = {8, 15, 23, 32, 44, 91, 3};
        int[] b = {18, 3, 32, 44, 18, 91};
        Integer[] c = {32,44,91};
        List<Integer> expected = Arrays.asList(c);
        
        

        List<Integer> output = q09.findIntersection(a, b);
        assertEquals("collections dont match", expected, output);
    }
    
}
