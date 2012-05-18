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
public class Vertex {
    private char data;
    private boolean visited;
    private boolean deleted;
    
    public Vertex(char data){
        this.data = data;
        this.visited = false;
    }

    public char getData() {
        return data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
