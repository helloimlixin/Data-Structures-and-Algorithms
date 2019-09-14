package Subsection1_GraphSearchAlgorithms.DepthFirstSearch;

import Subsection1_GraphSearchAlgorithms.Graph;

import java.util.LinkedList;

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
        this.visited = new boolean[graph.V];
        this.graph = graph;
        this.src = src;
    }

    void traverse() {
        System.out.println("Performing Depth-First Search Graph Traversal...");
        dfs(graph, src);
        System.out.println("Graph traversal completed.");
    }

    private void dfs(Graph graph, int src) {
        if (visited[src]) {
            LinkedList<Integer> neighbors = graph.neighbors(src);
            for (int i = 0; i < neighbors.size(); i++) {
                int v = neighbors.get(i);
                return dfs(graph, v);
            }
        } else {
            System.out.printf("Vertex %d visited.\n", src);
            visited[src] = true;
        }
    }
}
