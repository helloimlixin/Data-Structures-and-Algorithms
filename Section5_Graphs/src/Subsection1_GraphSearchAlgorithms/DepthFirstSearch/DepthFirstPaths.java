package Subsection1_GraphSearchAlgorithms.DepthFirstSearch;

import Subsection1_GraphSearchAlgorithms.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    private void dfs(Graph graph, int v) {
        visited[v] = true;
        for (int w: graph.neighbors(v)) {
            if (!visited[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    /**
     * Check if there's a path between source vertex <code>s</code> and vertex <code>v</code>.
     * @param v vertex to check
     * @return <code>true</code> if there's a path, <code>false</code> otherwise.
     */
    public boolean hasPathTo(int v) {
        return visited[v];
    }
    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int i = v; i != src; i = edgeTo[i]) {
            path.add(i);
        }
        path.add(src);
        return path;
    }
}
