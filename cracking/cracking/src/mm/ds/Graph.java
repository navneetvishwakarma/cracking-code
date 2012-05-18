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
public class Graph {
    private int maxSize;
    private Vertex[] vertices;
    private int[][] adjMat;
    private int count;
    
    public Graph(int size){
        this.maxSize = size;
        vertices = new Vertex[size];
        adjMat = new int[size][size];
        count = 0;
    }
    
    
    public void addVertex(char data){
        vertices[count++] = new Vertex(data);
    }
    
    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }
    
    public void addDirectedEdge(int start, int end){
        adjMat[start][end] = 1;
    }
    
    //recursive dfs
    public void dfs(){
        ((Vertex)vertices[0]).setVisited(true);
        recursiveDFS(vertices[0]);
    }
    
    //this function prints the current vertex, marks it visited
    //and calls self for each of this vertex's non-visited neighbor
    private void recursiveDFS(Vertex v){
        System.out.println(v.getData());
        v.setVisited(true);
        for(Vertex neighbor : getNeighbors(v)){
            if(!neighbor.isVisited()){
                recursiveDFS(neighbor);
            }
        }
        
    }

    //goes through the adjMat for this Vertex and returns vertices that are marked with "1" 
    public Vertex[] getNeighbors(Vertex v){
        int vertexIndex = findIndexForVertex(v);
        Vertex[] neighbors = new Vertex[maxSize];
        int n=0;
        for(int j=0;j<maxSize;j++){
            if(adjMat[vertexIndex][j] == 1){
                neighbors[n++] = vertices[j];
            }
        }
        
        //for convenience, return an array the size of no.of neighbors;
        Vertex[] trimmedNeighbor = new Vertex[n];
        for(int j=0; j<n;j++){
            trimmedNeighbor[j] = neighbors[j];
        }
        return trimmedNeighbor;
    }
    
    private int findIndexForVertex(Vertex v){
        for(int i=0;i <vertices.length; i++){
            Vertex vertex = vertices[i];
            if(vertex.getData() == v.getData()){
                return i;
            }
        }
        return -1;
    }
    
    public int vertexCount(){
        return count;
    }
    

    //the function basically looks for a node that has no outgoing edges (no successor). If it finds such a node it deletes
    //it from the Graph. A non-cyclic graph will have all its node deleted. On the other hand, a non-cyclic graph will have
    //vertices pointing to each other (and thus the getNoSuccessorVertex() method will return null).
    public boolean isCyclic(){
        while(vertexCount() > 0){
            Vertex v = getNoSuccessorVertex();
            if(v == null) return true;
            else deleteVertex(v);
        }
        return false;
    }
    
    private Vertex getNoSuccessorVertex(){
        for(int i=0; i<adjMat.length; i++){
            if(vertices[i].isDeleted()) continue;
            boolean flag = true;
            for(int j=0; j<adjMat[0].length; j++){
                if(vertices[j].isDeleted()) continue;
                if(adjMat[i][j] == 1) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                return vertices[i];
            }
        }
        return null;
    }
    
    public void deleteVertex(Vertex v){
        v.setDeleted(true);
        --count;
    }
}
