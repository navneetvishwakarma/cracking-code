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

import mm.ds.Node;


/**
 * Given a circular linked list, implement an algorithm which returns node at the begin- ning of the loop
 *
 * @author mmathuria
 */
public class Question2dot5 {
    
    public Node findStartOfLoop(Node head){
        
        Node fast = head;
        Node slow = head;
        
        //find Meeting Node
        do {
            fast = fast.next();
            fast = fast.next();
            slow = slow.next();
            
            //not a circular loop
            if(fast == null || slow == null){
                return null;
            }
            
        } while (fast != slow);

        
        
        //find circle length
        int count = 0;
        do {
            fast = fast.next();
            fast = fast.next();
            slow = slow.next();
            count++;
        } while (fast != slow);
        int circleLength = count;

        
        fast = slow = head;
        
        //move fast equal to circle length
        int i = 0;
        while (i++ < circleLength) {
            fast = fast.next();
        }

        //now..get the start of the loop
        while(fast != slow){
            fast = fast.next();
            slow = slow.next();
        }
        
        return fast;
    }

    public Node findStartOfLoop2(Node head) {

        Node fast = head;
        Node slow = head;

        findMeetingNode(fast, slow);
        int circleLength = findCircleLength(fast, slow);

        fast = slow = head;
        movePtrCircleLength(fast, circleLength);

        while (fast != slow) {
            fast = fast.next();
            slow = slow.next();
        }

        return fast;
    }

    private Node findMeetingNode(Node fast, Node slow){
        do{
            fast = fast.next();
            fast = fast.next();
            slow = slow.next();
        }while(fast != slow);
        
        return fast;
    }
    
    private int findCircleLength(Node fast, Node slow){
        int count = 0;
        do {
            fast = fast.next();
            fast = fast.next();
            slow = slow.next();
            count++;
        } while (fast != slow);
        return count;
    }
    
    private void movePtrCircleLength(Node fast, int circleLength){
        int i=0;
        while(i < circleLength){
            fast = fast.next();
        }
    }
}
