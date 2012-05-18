package mm.chap2;

import junit.framework.TestCase;
import mm.ds.LinkedList;
import mm.ds.Node;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question2dot1Test extends TestCase {
    
    public void testRemoveDups(){
        LinkedList list = list1();

        Question2dot1 q2dot1 = new Question2dot1();
        LinkedList outputList = q2dot1.removeDupsNoMem(list);
        assertEquals("list size does not match",4,list.count());
        System.out.println(outputList);

        list = list2();
        outputList = q2dot1.removeDupsNoMem(list);
        assertEquals("list size does not match",4,list.count());
        System.out.println(outputList);

        list = list3();
        outputList = q2dot1.removeDupsNoMem(list);
        assertEquals("list size does not match",4,list.count());
        System.out.println(outputList);

        list = list4();
        outputList = q2dot1.removeDupsNoMem(list);
        assertEquals("list size does not match",1,list.count());
        System.out.println(outputList);

        list = list5();
        outputList = q2dot1.removeDupsNoMem(list);
        assertEquals("list size does not match",3,list.count());
        System.out.println(outputList);
    }

    private LinkedList list1() {
        LinkedList list = new LinkedList();
        list.append(new Node(1));
        list.append(new Node(1));
        list.append(new Node(2));
        list.append(new Node(2));
        list.append(new Node(2));
        list.append(new Node(3));
        list.append(new Node(2));
        list.append(new Node(4));
        list.append(new Node(4));
        return list;
    }

    private LinkedList list2() {
        LinkedList list = new LinkedList();
        list.append(new Node(1));
        list.append(new Node(2));
        list.append(new Node(2));
        list.append(new Node(2));
        list.append(new Node(3));
        list.append(new Node(2));
        list.append(new Node(4));
        return list;
    }

    private LinkedList list3() {
        LinkedList list = new LinkedList();
        list.append(new Node(1));
        list.append(new Node(2));
        list.append(new Node(3));
        list.append(new Node(4));
        return list;
    }

    private LinkedList list4() {
        LinkedList list = new LinkedList();
        list.append(new Node(1));
        list.append(new Node(1));
        return list;
    }

    private LinkedList list5() {
        LinkedList list = new LinkedList();
        list.append(new Node(1));
        list.append(new Node(2));
        list.append(new Node(3));
        list.append(new Node(2));
        list.append(new Node(2));
        return list;
    }
}
