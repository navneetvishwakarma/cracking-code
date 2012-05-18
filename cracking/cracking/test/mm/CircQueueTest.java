package mm;

import junit.framework.TestCase;
import mm.ds.CircQueue;

import java.util.NoSuchElementException;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class CircQueueTest extends TestCase {
    public void test1() {
        int[] items = {1, 2, 3, 4, 5};
        int itemLength = items.length;

        CircQueue cq = new CircQueue(itemLength);
        //CircQueue2 cq = new CircQueue2(itemLength);

        assertTrue("Queue not empty", cq.isEmpty());

        //full
        for (int item : items) {
            cq.insert(item);
        }
        assertTrue("Queue not full", cq.isFull());

        //empty
        for (int i = 0; i < itemLength; i++) {
            cq.remove();
        }
        assertTrue("Queue not empty", cq.isEmpty());
    }

    public void test2() {
        CircQueue cq = new CircQueue(5);
        //CircQueue2 cq = new CircQueue2(5);

        //add 3
        cq.insert(5);
        cq.insert(4);
        cq.insert(3);
        assertFalse("Queue shows full", cq.isFull());

        //remove 3
        cq.remove();
        cq.remove();
        cq.remove();
        assertTrue("Queue not empty", cq.isEmpty());

        //add 3 - wrap around
        cq.insert(5);
        cq.insert(3);
        cq.insert(4);
        assertEquals("Size does not match", 3, cq.count());

        //remove 3 - empty
        cq.remove();
        cq.remove();
        cq.remove();
        assertTrue("Queue not empty", cq.isEmpty());

        //remove - underflow
        try {
            cq.remove();
            fail("Queue did not underflow");
        } catch (NoSuchElementException e) {

        }

        //add 5 -- full
        cq.insert(5);
        cq.insert(4);
        cq.insert(3);
        cq.insert(6);
        cq.insert(7);
        assertTrue("Queue not full", cq.isFull());

        //insert, overflow
        try {
            cq.insert(8);
            fail("Queue did not overflow");
        } catch (IllegalStateException e) {

        }
    }
}
