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

import junit.framework.TestCase;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class GraphTest extends TestCase {

    public void testInsert(){
        int size = 5;
        Graph g = initGraph2(size);
        assertNotNull("graph is null",g);
        
        int vertexCount = g.vertexCount();
        assertEquals("no.of vertices dont match",size,vertexCount);
    }
    
    
    public void testDFS(){
        int size = 5;
        Graph g = initGraph2(size);
        g.dfs();
    }
    
    private Graph initGraph1(int size){
        Graph g = new Graph(size);
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        
        return g;
    }


    private Graph initGraph2(int size) {
        Graph g = new Graph(9);
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');
        g.addVertex('G');
        g.addVertex('H');
        g.addVertex('I');
        
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(0,4);
        g.addEdge(1,5);
        g.addEdge(5,7);
        g.addEdge(3,6);
        g.addEdge(6,8);
        
        return g;
    }
}
