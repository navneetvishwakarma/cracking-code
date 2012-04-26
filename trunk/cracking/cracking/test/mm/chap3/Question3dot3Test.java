package mm.chap3;


import junit.framework.TestCase;

/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question3dot3Test extends TestCase {
    
    public void testPush() throws Exception {
        Question3dot3 stack = getStack();
        assertEquals("size does not match",4,stack.size());
    }
    
    public void testPop() throws Exception {
        Question3dot3 stack = getStack();
        assertEquals("popped element did not match",40,stack.pop());
        assertEquals("popped element did not match",30,stack.pop());
        assertEquals("size does not match",2,stack.size());
    }
    
    public void testUnderflow() throws Exception {
        Question3dot3 stack = getStack();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        
        assertEquals("size does not match",0,stack.size());

        try {
            stack.pop();
            fail("stackunderflow exception was not thrown");
        } catch (Exception e) {
            //empty
        }
    }

    private Question3dot3 getStack() {
        Question3dot3 stack = new Question3dot3();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        return stack;
    }
}
