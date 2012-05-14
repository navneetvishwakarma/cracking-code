package mm.chap8;


import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question8dot4Test extends TestCase {
    
    Question8dot4 testObj = new Question8dot4();
    
    public void testGetPerms(){
        ArrayList<String> perms = testObj.getPerms2("abc");
        assertNotNull(perms);
        assertEquals("",6,perms.size());

        perms = testObj.getPerms2("abcd");
        assertNotNull(perms);
        assertEquals("",24,perms.size());

        perms = testObj.getPerms2("abcde");
        assertNotNull(perms);
        assertEquals("",120,perms.size());
    }
}
