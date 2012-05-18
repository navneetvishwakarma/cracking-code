package mm;

import junit.framework.TestCase;
import mm.ds.Queue;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class QueueTest extends TestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    
    public void testAllMethods(){
        int[] items = {3,6,9,8,1};
        int itemsLength = items.length;
        
        Queue queue = new Queue(itemsLength);
        
        assertTrue("Queue not empty",queue.isEmpty());
        for(int item : items){
            queue.insert(item);
        }
        assertTrue("Queue not full",queue.isFull());
        assertEquals("Count not valid",itemsLength,queue.count());

        for(int item: items){
            assertEquals("Element do not match",item,queue.remove());
        }
        assertEquals("Count not valid", 0, queue.count());
    }
    
    public void testInsRemoveOne(){
        Queue queue = new Queue(3);
        queue.insert(4);
        queue.remove();
        assertTrue("Queue not empty",queue.isEmpty());
    }
    
    public void test1(){
        Queue queue = new Queue(5);
        
        //add 2
        for(int i=1;i<=2;i++){
            queue.insert(i);
        }
        
        //remove 1
        queue.remove();
        
        assertEquals("Count does not match",1,queue.count());
        
        //add 2
        for(int i=1;i<=2;i++){
            queue.insert(i);
        }
        assertEquals("Count does not match",3,queue.count());
        
        
        //remove 3 = empty
        for(int i=1;i<=3;i++){
            queue.remove();
        }
        assertTrue("Queue not empty",queue.isEmpty());
    }
}
