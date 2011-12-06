/*
 * $Id$
 *
 * Copyright (c) 2001-2008 Bridge Entertainment, Inc. (dba E-Poll Market Research)
 * All Rights Reserved.
 * 
 * This software is the confidential and proprietary information
 * of Bridge Entertainment, Inc. ("Confidential Information").
 */


package mm;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class LinkedList {
    public Node head;
    private Node tail;

    public LinkedList() {
    }
    
    public LinkedList append(Node n){
        if(n == null)  return this;
        
        if(head == null){
            head = tail = n;
            return this;
        }
        
        tail.next = n;
        tail = n; 
        return this;
    }
    
    public void appendDLL(Node n){
        if(n == null)  return;
        
        if(head == null){
            head = tail = n;
            return;
        }
        
        tail.next = n;
        n.prev = tail;
        tail = n; 
    }
    
    public Node head(){
        return head;
    }
    
    public Node tail(){
        return tail;
    }

    public int count(){
        int count = 0;
        Node c = head;
        while(c != null){
            c = c.next();
            count++;
        }
        return count;
    }
    
    @Override
    public String toString(){
        StringBuilder sbuf = new StringBuilder();
        Node current = head;
        while(current != null){
            sbuf.append(current.getiData()).append("-->");
            current = current.next;
        }
        return sbuf.toString();
    }
}
