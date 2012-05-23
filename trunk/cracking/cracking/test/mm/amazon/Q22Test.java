package mm.amazon;


import junit.framework.TestCase;

import java.util.*;

/**
 * Put class JavaDoc here
 */
public class Q22Test extends TestCase {
    
    Q22 testObj = new Q22();
    
    public void testGenPalindromeEvenLen(){
        char[] chars = new char[]{'a','e','i','o','u'};
        List<String> output = testObj.genPalindromes(chars, 0, 4);
        assertEquals("size does not match",25,output.size());
        System.out.println(output);
    }

    public void testGenPalindromeOddLen(){
        char[] chars = new char[]{'a','e','i','o','u'};
        List<String> output = testObj.genPalindromes(chars, 0, 3);
        assertEquals("size does not match",25,output.size());
        System.out.println(output);
    }
}
