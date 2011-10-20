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
public class Node {
    public char data;
    public int iData;
    public Node next;

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
}
