package Subsection1_GraphSearchAlgorithms;

public class GraphClient {
    /**
     * Compute the degree of a given node in the graph.
     * @param G current graph object
     * @param v query node
     * @return an integer representing the degree of current node v
     */
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int neighbor: G.neighbors(v))
            degree++;
        return degree;
    }

    /**
     * Compute the maximum degree in the graph
     * @param G current graph object
     * @return an integer representing the maximum degree in graph G
     */
    public static int maxDegree(Graph G) {
        int maxDegree = 0;
        for (int v = 0; v < G.V; v++) {
            if (degree(G, v) > maxDegree)
                maxDegree = degree(G, v);
        }
        return maxDegree;
    }

    /**
     * Compute the average degree.
     * @param G current graph object
     * @return an integer representing the average degree in graph G
     */
    public static double averageDegree(Graph G) {
        return 2.0 * G.E / G.V;
    }

    /**
     * Count the number of self loops.
     * @param G current graph object
     * @return an integer representing the number of self loops in graph G
     */
    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v1 = 0; v1 < G.V; v1++)
            for (int v2 : G.adjacencyLists[v1])
                if (v1 == v2) count++;
        return count / 2; // we are counting each edge twice
    }
}
