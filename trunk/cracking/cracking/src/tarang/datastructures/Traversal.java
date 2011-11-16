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
        Map<TNode, TNode> previous = new HashMap<TNode, TNode>();
        TNode root = graph.getRoot();
        previous.put(root, null);
        dfsVisit(root, graph, previous);
    }

    private static void dfsVisit(TNode node, TGraph graph, Map<TNode, TNode> previous) {
        System.out.println("Visiting -> " + node + " ");
        if (graph.getEdges().get(node) != null) {   // if no edge to any other node then done with this one
            for (TNode neighbor : graph.getEdges().get(node)) {
                if (neighbor.isVisited()) {
                    // skip this
                    continue;
                }
                previous.put(neighbor, node);
                dfsVisit(neighbor, graph, previous);
            }
        }
        node.setVisited(true);
        if(previous.get(node) != null) {
            // back track
            dfsVisit(previous.get(node), graph, previous);
        } else {
            System.out.println("Root -> " + node + " ");
        }
    }

    // O(V + E)
    public static void breadthFirstSearch(TGraph graph) {
        List<TNode> unexplored = new java.util.LinkedList<TNode>();
        unexplored.add(graph.getRoot());

        while (unexplored.size() > 0) {
            TNode curr = unexplored.remove(0);
            System.out.println("Explore -> " + curr + " ");
            if (graph.getEdges().get(curr) != null) {
                for (TNode neighbor : graph.getEdges().get(curr)) {
                    if (!neighbor.isVisited()) {
                        unexplored.add(neighbor);
                    }
                }
            }
            curr.setVisited(true);
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

        //Traversal.depthFirstSearch(graph);
        Traversal.breadthFirstSearch(graph);
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
}

class TNode {
    private String name;
    private boolean visited;

    TNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
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
