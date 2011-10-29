
package mm.chap9;

import junit.framework.TestCase;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question9dot3Test extends TestCase {
    
    public void testFindIndex(){
        Question9dot3 obj = new Question9dot3();
        
        int[] a = {6,7,8,9,10,11,12,13,14,15,1,2,3,4,5};

        int index = obj.findIndex(a, 4);
        assertEquals("returned index is wrong",13,index);
        System.out.println("index=" + index);

        index = obj.findIndex(a, 8);
        assertEquals("returned index is wrong",2,index);
        System.out.println("index=" + index);

        index = obj.findIndex(a, 16);
        assertEquals("returned index is wrong",-1,index);
        System.out.println("index=" + index);
    }
}
