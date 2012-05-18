package mm;

import junit.framework.TestCase;
import mm.ds.Heap;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class HeapTest extends TestCase {
    
    public void testInsert(){
        Heap heap = new Heap();
        
        heap.insert(13);
        heap.insert(18);
        heap.insert(13);
        
        heap.insert(14);
        heap.insert(13);
        heap.insert(16);
        heap.insert(14);
        
        heap.insert(21);
        heap.insert(13);

        System.out.println(heap.toString());
    }

    public void testInsert2(){
        Heap heap = new Heap();
        
        heap.insert2(100);
        heap.insert2(80);
        heap.insert2(90);
        
        heap.insert2(30);
        heap.insert2(60);
        heap.insert2(50);
        heap.insert2(70);
        
        heap.insert2(95);
        heap.insert2(105);

        System.out.println(heap.toString());
    }
    
    public void testRemove(){
        Heap heap = new Heap();
        
        heap.insert(100); heap.insert(90);heap.insert(80);heap.insert(30);heap.insert(60);heap.insert(50);
        
        heap.toString();
        heap.remove();
        System.out.println(heap.toString());
        heap.remove();
        System.out.println(heap.toString());
        heap.remove();
        System.out.println(heap.toString());
        heap.remove();
        System.out.println(heap.toString());
        heap.remove();
        System.out.println(heap.toString());
        heap.remove();
        System.out.println(heap.toString());
    }
}
