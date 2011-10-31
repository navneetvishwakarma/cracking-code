
package mm.chap9;

import junit.framework.TestCase;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question9dot5Test extends TestCase {
    
    public void test1(){
        Question9dot5 obj = new Question9dot5();
        
        String[] input = {"at","","","","ball","","","car","","","dad","",""};

        int index = obj.findIndex(input,"ball");
        assertEquals("incorrect position returned",4,index);
        System.out.println("index:\t" + index);

        index = obj.findIndex(input,"eballcar");
        assertEquals("incorrect position returned",-1,index);
        System.out.println("index:\t" + index);

        index = obj.findIndex(input, "car");
        assertEquals("incorrect position returned", 7, index);
        System.out.println("index:\t" + index);
    }
}
