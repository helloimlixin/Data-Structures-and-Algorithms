package Subsection1_GraphSearchAlgorithms.DepthFirstSearch;

import Subsection1_GraphSearchAlgorithms.Graph;

/**
 * <h1>Class for finding paths between vertices using DFS.</h1>
 *
 * @author xinli
 * Credits to princeton algorithm course on coursera.
 */
public class DepthFirstPaths {
    private boolean[] visited;
    private int[] edgeTo; // edgeTo[v] = last edge on s-v path
    private final int src; // source vertex

    /**
     * Computes a path between <code>src</code> and every other vertex in <code>graph</code>.
     * @param graph the target graph
     * @param src source vertex
     */
    public DepthFirstPaths(Graph graph, int src) {
        this.src = src;
        edgeTo = new int[graph.V];
        visited = new boolean[graph.V];
        dfs(graph, src);
    }

    /**
     * Recursive method for DFS from source vertex.
     * @param graph target graph
     * @param src source vertex
     */
    private void dfs(Graph graph, int src) {
        visited[src] = true;
        for (int v: graph.neighbors(src)) {
            edgeTo[v] = src;
            dfs(graph, v);
        }
    }
}
