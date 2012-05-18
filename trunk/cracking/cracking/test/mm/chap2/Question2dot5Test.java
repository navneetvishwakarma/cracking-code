/*
 * $Id$
 *
 * Copyright (c) 2001-2008 Bridge Entertainment, Inc. (dba E-Poll Market Research)
 * All Rights Reserved.
 * 
 * This software is the confidential and proprietary information
 * of Bridge Entertainment, Inc. ("Confidential Information").
 */


package mm.chap2;

import junit.framework.TestCase;
import mm.ds.LinkedList;
import mm.ds.Node;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question2dot5Test extends TestCase {
    
    public void testFindStartOfLoop(){
        Question2dot5 obj = new Question2dot5();

        Node head = createCircularList1();
        Node loopStartNode = obj.findStartOfLoop(head);
        assertEquals("nodes dont match",'C',loopStartNode.data);
        
        head = createCircularList2();
        loopStartNode = obj.findStartOfLoop(head);
        assertEquals("nodes dont match",'B',loopStartNode.data);
        
        head = createCircularList3();
        loopStartNode = obj.findStartOfLoop(head);
        assertEquals("nodes dont match",'D',loopStartNode.data);
        
        head = createNonCircularList();
        loopStartNode = obj.findStartOfLoop(head);
        assertNull("returned node is not null",loopStartNode);
        
    }
    
    
    public void testWithCircularListSizeOne(){
        LinkedList list = new LinkedList();
        Node a = new Node('A');
        list.append(a);
        
        a.next = a;
        
        Question2dot5 obj = new Question2dot5();
        Node loopStartNode = obj.findStartOfLoop(a);
        assertNotNull("loopstartnode is null",loopStartNode);
        System.out.println("loopStartNode: " + loopStartNode.data);
        assertEquals("nodes dont match",'A',loopStartNode.data);
    }
    
    
    private Node createCircularList1(){
        LinkedList lnkdList = new LinkedList();
        
        Node a = new Node('A');
        lnkdList.append(a);

        Node b = new Node('B');
        lnkdList.append(b);

        Node c = new Node('C');
        lnkdList.append(c);

        Node d = new Node('D');
        lnkdList.append(d);

        Node e = new Node('E');
        lnkdList.append(e);
        
        e.next = c;
        
        return a;

    }

    private Node createCircularList2(){
        LinkedList lnkdList = new LinkedList();
        
        Node a = new Node('A');
        lnkdList.append(a);

        Node b = new Node('B');
        lnkdList.append(b);

        Node c = new Node('C');
        lnkdList.append(c);

        Node d = new Node('D');
        lnkdList.append(d);

        d.next = b;
        
        return a;

    }

    private Node createNonCircularList(){
        LinkedList lnkdList = new LinkedList();
        
        Node a = new Node('A');
        lnkdList.append(a);

        Node b = new Node('B');
        lnkdList.append(b);

        Node c = new Node('C');
        lnkdList.append(c);

        Node d = new Node('D');
        lnkdList.append(d);

        return a;
    }

    private Node createCircularList3(){
        LinkedList lnkdList = new LinkedList();
        
        Node a = new Node('A');
        lnkdList.append(a);

        Node b = new Node('B');
        lnkdList.append(b);

        Node c = new Node('C');
        lnkdList.append(c);

        Node d = new Node('D');
        lnkdList.append(d);

        Node e = new Node('E');
        lnkdList.append(e);

        Node f = new Node('F');
        lnkdList.append(f);

        Node g = new Node('G');
        lnkdList.append(g);

        Node h = new Node('H');
        lnkdList.append(h);

        Node i = new Node('I');
        lnkdList.append(i);

        Node j = new Node('J');
        lnkdList.append(j);

        j.next = d;
        
        return a;

    }
}
