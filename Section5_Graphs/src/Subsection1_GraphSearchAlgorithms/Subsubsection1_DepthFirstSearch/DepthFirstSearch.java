package Subsection1_GraphSearchAlgorithms.Subsubsection1_DepthFirstSearch;

import Subsection1_GraphSearchAlgorithms.Graph;

import java.util.Iterator;
import java.util.Stack;

/**
 * <h1>Class for Depth First Search</h1>
 *
 * @author xinli
 */
class DepthFirstSearch {
    private Graph graph;
    private int src;
    private boolean[] visited;

    /**
     * Class constructor.
     * @param graph graph to do DFS traversal
     * @param src source vertex for the traversal
     */
    DepthFirstSearch(Graph graph, int src) {
        System.out.println("Initializing Depth-First Search Procedure...");
        System.out.printf("Starting vertex: %d.\n", src);
        this.visited = new boolean[graph.V];
        this.graph = graph;
        this.src = src;
    }

    /**
     * Method for traversing the graph by calling the specific DFS implementation.
     */
    void traverse() {
        System.out.println("Performing Depth-First Search Graph Traversal...");
        dfsRecursive(graph, src);
//        dfsIterative(graph, src);
        System.out.println("Graph traversal completed.\n==========================");
    }

    /**
     * Recursive implementation for Depth-First Search from source vertex <code>src</code>.
     * <em>Complexity Analysis</em>
     * <ul>
     *     <li>Time Complexity: O(V + E)</li>
     *     <li>Space Complexity: O(V)</li>
     * </ul>
     * @param graph target graph
     * @param src initial source vertex
     */
    private void dfsRecursive(Graph graph, int src) {
        // Mark vertex src as visited.
        visited[src] = true;
        System.out.printf("Vertex %d visited.\n", src);
        // Recursively visit all unmarked vertices adjacent to v.
        for (int v : graph.neighbors(src)) {
            if (!visited[v]) {
                dfsRecursive(graph, v);
            }
        }
    }

    /**
     * Iterative implementation for Depth First Search using Stack.
     * <em>Complexity Analysis</em>
     * <ul>
     *     <li>Time Complexity: O(V + E)</li>
     *     <li>Space Complexity: O(V)</li>
     * </ul>
     * @param graph target graph
     * @param src source vertex
     */
    private void dfsIterative(Graph graph, int src) {
        Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[graph.V];
        for (int i = 0; i < graph.V; i++) {
            adj[i] = graph.neighbors(i).iterator();
        }
        // Initialize a stack data structure.
        Stack<Integer> stack = new Stack<>();
        // Push src vertex onto the stack
        stack.push(src);
        // Mark src as visited.
        visited[src] = true;
        System.out.printf("Vertex %d visited.\n", src);
        while (!stack.isEmpty()) {
            // Pop a vertex from the stack to visit next.
            int v = stack.peek();
            if (adj[v].hasNext()) {
                int w = adj[v].next();
                System.out.printf("Check %d\n", w);
                if (!visited[w]) {
                    visited[w] = true;
                    stack.push(w);
                    System.out.printf("Vertex %d visited.\n", w);
                } else {
                    System.out.println("Already visited.");
                }
            } else {
                stack.pop();
            }
        }
    }
}
