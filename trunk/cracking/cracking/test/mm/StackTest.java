package mm;

import junit.framework.TestCase;
import mm.ds.Stack;

import java.util.EmptyStackException;



/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class StackTest extends TestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    public void testPush(){
        int[] itemsToBePushed = {5,3,2};
        int itemCount = itemsToBePushed.length;

        Stack s = pushData(itemsToBePushed, itemCount);

        StringBuffer expectedDisplayString = new StringBuffer();
        for (int i = itemsToBePushed.length - 1; i >= 0; i--) {
            expectedDisplayString.append(itemsToBePushed[i]).append("\n");
        }

        assertEquals("expected displayString does not match",expectedDisplayString.toString(),s.toString());
    }
    
    
    public void testPop(){
        int[] itemsToBePushed = {5, 3, 2};
        int itemCount = itemsToBePushed.length;

        Stack s = pushData(itemsToBePushed, itemCount);

        for (int i = itemsToBePushed.length - 1; i >= 0; i--) {
            assertEquals("popped wrong element",itemsToBePushed[i],s.pop());
        }
        
        assertEquals("incorrect count",0,s.count());
    }

    private Stack pushData(int[] itemsToBePushed, int itemCount) {
        Stack s = new Stack(itemCount);
        for (int item : itemsToBePushed) {
            s.push(item);
        }
        return s;
    }


    public void testUnderflow(){
        Stack stack = new Stack(3);
        stack.push(3);
        stack.push(2);
        stack.push(1);


        stack.pop();stack.pop();stack.pop();
        try {
            stack.pop();
            fail("empty stack error");
        } catch (EmptyStackException e) {
            
        }
    }
    
    public void testPeek(){
        Stack stack = new Stack(3);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        
        assertEquals("peek did not return correct",1,stack.peek());
    }
}
