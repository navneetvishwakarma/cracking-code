/*
 * $Id$
 *
 * Copyright (c) 2001-2008 Bridge Entertainment, Inc. (dba E-Poll Market Research)
 * All Rights Reserved.
 * 
 * This software is the confidential and proprietary information
 * of Bridge Entertainment, Inc. ("Confidential Information").
 */


package cracking.src.mm;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Node {
    char data;
    Node next;

    public Node(char data) {
        this.data = data;
    }

    public char data() {
        return data;
    }

    public Node next() {
        return next;
    }
}
