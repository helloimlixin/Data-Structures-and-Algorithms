package GraphSearchAlgorithms;

import java.util.LinkedList;

/**
 * <h1>Graph Class Using Adjacency List Representation</h1>
 *
 * @author xinli, based on the Princeton Algorithms Coursera Course
 */
public class Graph {
    private final int V; // number of vertices
    private LinkedList<Integer>[] adjacencyLists; // adjacency lists
    /**
     * <h2>Class constructor with given number of vertices.</h2>
     * The graph will be constructed by creating an adjacency list for each node
     * @param V number of vertices
     */
    @SuppressWarnings("unchecked")
    public Graph(int V) {
        this.V = V;
        adjacencyLists = new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adjacencyLists[v] = new LinkedList<>();
        }
    }
    /**
     * <h2>Method for adding an edge to the undirected graph.</h2>
     * The edges are added symmetrically for undirected graphs.
     * @param v1 one node of the edge
     * @param v2 the other node of the edge
     */
    public void addEdge(int v1, int v2) {
        adjacencyLists[v1].add(v2);
        adjacencyLists[v2].add(v1);
    }
    /**
     * <h2>Method for getting the adjacent vertices for a vertex.</h2>
     * @param v target vertex
     * @return adjacency list for vertex v
     */
    public LinkedList<Integer> neighbors(int v) {
        return adjacencyLists[v];
    }
}
