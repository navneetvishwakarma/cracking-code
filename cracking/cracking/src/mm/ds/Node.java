/*
 * $Id$
 *
 * Copyright (c) 2001-2008 Bridge Entertainment, Inc. (dba E-Poll Market Research)
 * All Rights Reserved.
 * 
 * This software is the confidential and proprietary information
 * of Bridge Entertainment, Inc. ("Confidential Information").
 */


package mm.ds;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Node {
    public char data;
    public int iData;
    public Node next;
    public Node prev;

    public Node(char data) {
        this.data = data;
    }

    public Node(int iData) {
        this.iData = iData;
    }

    public char data() {
        return data;
    }

    public Node next() {
        return next;
    }

    public int getiData() {
        return iData;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + iData;
        hash = 31 * hash + data;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        
        if(!(obj instanceof Node)) return false;
        
        Node n = (Node)obj;
        return (this.data == n.data && this.iData == n.iData);
    }
}
