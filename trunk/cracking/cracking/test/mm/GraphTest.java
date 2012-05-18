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
import mm.ds.Graph;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class GraphTest extends TestCase {

    public void testInsert(){
        int size = 9;
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

    public void testIsNotCyclic() throws Exception {
        Graph g = new Graph(3);
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');

        g.addDirectedEdge(0,1);
        g.addDirectedEdge(1,2);
        
        assertFalse("assertion incorrect",g.isCyclic());
    }

    public void testIsCyclic() throws Exception {
        Graph g = new Graph(3);
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');

        g.addDirectedEdge(0,1);
        g.addDirectedEdge(1,2);
        g.addDirectedEdge(2,0);
        
        assertTrue("assertion incorrect",g.isCyclic());
    }


    public void testIsNotCyclic1() throws Exception {
        Graph g = new Graph(8);
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');
        g.addVertex('G');
        g.addVertex('H');
        
        g.addDirectedEdge(0,3);
        g.addDirectedEdge(0,4);
        g.addDirectedEdge(1,4);
        g.addDirectedEdge(2,5);
        g.addDirectedEdge(3,6);
        g.addDirectedEdge(4,6);
        g.addDirectedEdge(5,7);
        g.addDirectedEdge(6,7);
        
        assertFalse("assertion incorrect",g.isCyclic());
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
