package mm.amazon;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Q10Test extends TestCase {
    
    Q10 q10 = new Q10();
    
    public void testWithNullArrays(){

        try {
            q10.mergeSorted(null,null);
            fail("method did not throw exception");
        } catch (IllegalArgumentException e) {
            
        }
    }
    
    public void testWithBothArraysZeroLength(){
        int[] c = q10.mergeSorted(new int[0],new int[0]);
        assertEquals("output array is not zero length",0,c.length);
    }
    
    
    public void testWithOneArrayNullOrZero(){
        int[] a = null;
        int[] b = {2,3,5};
        
        int[] c = q10.mergeSorted(a,b);
        assertEquals("arrays are not equal",b,c);
        
        c = q10.mergeSorted(b,a);
        assertEquals("arrays are not equal",b,c);
        
        a = new int[0];

        c = q10.mergeSorted(b, a);
        assertEquals("arrays are not equal", b, c);
    } 
    
    
    public void testBothArrayLoaded(){
        
        int[] a = {3, 14, 21, 22, 25, 51, 76, 81, 92};
        int[] b = {12, 25, 50, 89, 102, 110, 118};

        int[] c = q10.mergeSorted(a, b);
        int[] expected = {3, 12, 14, 21, 22, 25, 25, 50, 51, 76, 81, 89, 92, 102, 110, 118};
        assertTrue("arrays are not equals", Arrays.equals(expected,c));
    }
    
}
