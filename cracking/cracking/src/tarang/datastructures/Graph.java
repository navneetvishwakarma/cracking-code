package tarang.datastructures;

import java.util.*;


/**
 * My very own graph
 *
 * @author tdesai
 */
public class Graph {

    private Map<Integer, GNode> nodes;

    public Graph(int[][] adj_matrix) {
        if(adj_matrix == null || adj_matrix.length == 0) {
            throw new IllegalArgumentException("adj matrix is null or empty");
        }
        nodes = new HashMap<Integer, GNode>();
        // create a graph with the an adjacency list
        GNode node1;
        GNode node2;
        for(int i = 0; i < adj_matrix.length; i++) {
            int key1 = i+1;
            node1 = nodes.get(key1);
            if(node1 == null) {
                node1 = new GNode(key1);
                nodes.put(key1, node1);
            }
            for(int j = 0; j < adj_matrix[i].length; j++) {
                int key2 = j+1;
                node2 = nodes.get(key2);
                if (node2 == null) {
                    node2 = new GNode(key2);
                    nodes.put(key2, node2);
                }
                if(adj_matrix[i][j] == 1) {
                    node1.connect(node2);
                }
            }
        }
    }

    public Map<Integer, GNode> getNodes() {
        return nodes;
    }
}
