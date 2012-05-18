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

import mm.ds.Graph;
import mm.ds.Vertex;


/**
 * Given a directed graph, design an algorithm to find out whether there is a route be- tween two nodes
 *
 * @author mmathuria
 */
public class Question4dot2 {
    private StringBuilder path = new StringBuilder();
    
    public boolean hasPath(Graph g, Vertex start, Vertex end){
        
        start.setVisited(true);
        
        Vertex[] neighbors = g.getNeighbors(start);
        if(isNeighbor(neighbors, end)){
            path.insert(0,end.getData());
            return true;
        }
        
        for(Vertex neighbor : neighbors){
            if((!neighbor.isVisited()) && hasPath(g, neighbor, end)){
                path.insert(0,neighbor.getData() + "-->");
                return true;
            }
        }
        return false;
    }

    private boolean isNeighbor(Vertex[] neighbors, Vertex end) {
        for(Vertex v : neighbors){
            if(v.getData() == end.getData()) return true;
        }
        return false;
    }

    public String pathAndClear(){
        String s =  path.toString();
        path.delete(0, path.length());
        return s;
    }    
}
