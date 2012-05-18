/*
 * $Id$
 *
 * Copyright (c) 2001-2008 Bridge Entertainment, Inc. (dba E-Poll Market Research)
 * All Rights Reserved.
 * 
 * This software is the confidential and proprietary information
 * of Bridge Entertainment, Inc. ("Confidential Information").
 */


package mm.chap4;

import junit.framework.TestCase;
import mm.ds.Graph;
import mm.ds.Vertex;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question4dot2Test extends TestCase {
    
    public void test1(){
        Question4dot2 obj = new Question4dot2();
        
        Graph g = graph1();
        assertTrue("path not found",obj.hasPath(g,new Vertex('A'), new Vertex('E')));
        System.out.println("A-->" + obj.pathAndClear());
        
        assertFalse("path found",obj.hasPath(g,new Vertex('A'), new Vertex('C')));

        g = cyclicGraph();
        assertTrue("path not found", obj.hasPath(g, new Vertex('A'), new Vertex('D')));
        System.out.println("A-->" + obj.pathAndClear());
        
        assertTrue("path not found", obj.hasPath(g, new Vertex('D'), new Vertex('A')));
        System.out.println("D-->" + obj.pathAndClear());
    }
    
    
    private Graph graph1(){
        Graph g = new Graph(7);
        
        char[] vertices = {'A','B', 'C', 'D', 'E', 'F', 'G'};
        for(char vertex : vertices){
            g.addVertex(vertex);
        }
        
        g.addDirectedEdge(0,1);
        g.addDirectedEdge(0,5);
        g.addDirectedEdge(1,6);
        g.addDirectedEdge(2,0);
        g.addDirectedEdge(2,3);
        g.addDirectedEdge(3,4);
        g.addDirectedEdge(4,1);
        g.addDirectedEdge(5,3);
        
        return g;
    }
    
    private Graph cyclicGraph(){
        Graph g = new Graph(4);

        char[] vertices = {'A', 'B', 'C', 'D'};
        for (char vertex : vertices) {
            g.addVertex(vertex);
        }

        g.addDirectedEdge(0, 1);
        g.addDirectedEdge(1, 2);
        g.addDirectedEdge(2, 3);
        g.addDirectedEdge(3, 0);

        return g;
    }
}
