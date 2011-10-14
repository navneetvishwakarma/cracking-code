package tarang.chap4;

import tarang.datastructures.GNode;
import tarang.datastructures.Graph;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes
 *
 * @author tdesai
 */
public class Question2 {

    // perform a depth first or breath first search and see if you hit a node - O(|V| + |E|)
    public static boolean reachable(Graph graph, GNode src, GNode dest) {
        if(src.equals(dest)) {
            return true;
        }
        // conduct a BFS or DFS and check to see if dest is reachable from src. here we do a BFS
        for (GNode node : graph.getNodes().values()) {
            node.setDiscovered(false);
        }
        Queue<GNode> queue = new LinkedList<GNode>();
        src.setDiscovered(true);
        queue.add(src);
        GNode node;
        while (!queue.isEmpty()) {
            node = queue.remove();
            for (GNode adj : node.getAdj()) {
                if(adj == null) {   // adjacent could be null
                    continue;
                }
                if(adj.equals(dest)) {
                    return true;
                }
                if (!adj.isDiscovered()) {
                    adj.setDiscovered(true);
                    queue.add(adj);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // create a graph
        int[][] adjacency_matrix = {
                        // 1  2  3  4  5  6
                 /* 1 */  {1, 1, 0, 0, 1, 0},
                 /* 2 */  {1, 0, 0, 0, 1, 0},
                 /* 3 */  {0, 0, 0, 0, 0, 0},
                 /* 4 */  {0, 0, 0, 0, 1, 1},
                 /* 5 */  {1, 1, 0, 1, 0, 0},
                 /* 6 */  {0, 0, 0, 1, 0, 0}
        };

        Graph graph = new Graph(adjacency_matrix);
        GNode src = graph.getNodes().get(2);
        GNode dest = graph.getNodes().get(3);

        System.out.println("2 -> 3 : " + Question2.reachable(graph, src, dest));



    }
}
