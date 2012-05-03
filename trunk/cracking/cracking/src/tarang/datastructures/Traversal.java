/*
 * $Id$
 *
 * Copyright (c) 2001-2008 Bridge Entertainment, Inc. (dba E-Poll Market Research)
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information
 * of Bridge Entertainment, Inc. ("Confidential Information").
 */


package tarang.datastructures;

import java.util.*;


/**
 * BFS and DFS impls on a graph
 *
 * @author tdesai
 */
public class Traversal {

    // O(V + E)
    public static void depthFirstSearch(TGraph graph) {
        // keep visiting childern until dead end, then backtrack to the previous
        Map<TNode, TNode> parent = new HashMap<TNode, TNode>();
        for(TNode vertex : graph.getVertices()) {
            parent.put(vertex, null);
            if(!vertex.isDiscovered()) {
                dfsVisit(vertex, graph, parent);
            }
        }
    }

    private static void dfsVisit(TNode node, TGraph graph, Map<TNode, TNode> parent) {
        System.out.println("Visiting -> " + node + " ");
        node.setDiscovered(true);
        if (graph.getEdges().get(node) != null) {   // if no edge to any other node then done with this one
            for (TNode neighbor : graph.getEdges().get(node)) {
                if (!neighbor.isDiscovered()) {
                    parent.put(neighbor, node);
                    dfsVisit(neighbor, graph, parent);
                }
            }
        }
    }

    // O(V + E)
    public static void breadthFirstSearch(TGraph graph) {
        List<TNode> unexplored = new ArrayList<TNode>();
        unexplored.add(graph.getRoot());
        graph.getRoot().setDiscovered(true);

        while (unexplored.size() > 0) {
            TNode curr = unexplored.remove(0);
            System.out.println("Explore -> " + curr + " ");
            if (graph.getEdges().get(curr) != null) {
                for (TNode neighbor : graph.getEdges().get(curr)) {
                    if (!neighbor.isDiscovered()) {
                        unexplored.add(neighbor);
                        neighbor.setDiscovered(true);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TNode a = new TNode("A");
        TNode b = new TNode("B");
        TNode c = new TNode("C");
        TNode d = new TNode("D");
        TNode e = new TNode("E");
        TNode f = new TNode("F");
        TNode g = new TNode("G");
        TNode h = new TNode("H");
        TNode i = new TNode("I");

        TGraph graph = new TGraph(a);
        graph.addEdge(a, b);
        graph.addEdge(a, c);
        graph.addEdge(b, d);
        graph.addEdge(b, h);
        graph.addEdge(b, i);
        graph.addEdge(c, d);
        graph.addEdge(c, f);
        graph.addEdge(d, e);
        graph.addEdge(e, g);

        Traversal.depthFirstSearch(graph);
        //Traversal.breadthFirstSearch(graph);
    }
}

class TGraph {
    private Map<TNode, List<TNode>> edges = new HashMap<TNode, List<TNode>>();
    private TNode root;

    TGraph(TNode root) {
        this.root = root;
        edges.put(root, new ArrayList<TNode>());
    }

    public void addEdge(TNode src, TNode dest) {
        if (!edges.containsKey(src)) {
            edges.put(src, new ArrayList<TNode>());
        }
        edges.get(src).add(dest);
    }

    public TNode getRoot() {
        return root;
    }

    public Map<TNode, List<TNode>> getEdges() {
        return edges;
    }

    public Set<TNode> getVertices() {
        return getEdges().keySet();
    }
}

class TNode {
    private String name;
    private boolean discovered = false;

    TNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TNode)) {
            return false;
        }

        TNode node = (TNode) o;

        if (name != null ? !name.equals(node.name) : node.name != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
