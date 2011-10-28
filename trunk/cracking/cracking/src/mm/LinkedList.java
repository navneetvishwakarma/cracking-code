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
    private Node head;
    private Node tail;

    public LinkedList() {
    }
    
    public void append(Node n){
        if(n == null)  return;
        
        if(head == null){
            head = tail = n;
            return;
        }
        
        tail.next = n;
        tail = n; 
    }
    
    public Node head(){
        return head;
    }
    
    public Node tail(){
        return tail;
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