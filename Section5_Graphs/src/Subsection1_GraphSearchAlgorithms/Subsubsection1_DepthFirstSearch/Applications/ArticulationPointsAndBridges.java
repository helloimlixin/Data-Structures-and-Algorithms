package Subsection1_GraphSearchAlgorithms.Subsubsection1_DepthFirstSearch.Applications;

/**
 * <h1>Articulation Points and Bridges</h1>
 * In a graph, a vertex is called an articulation point if removing it and all the edges associated with it results in the increase of the number of
 * connected components in the graph. Articulation Points represents vulnerabilities in a network.
 * @author xinli
 */
public class ArticulationPointsAndBridges {
    /**
     * In order to find all the articulation points in a given graph, the brute force approach is to check for every vertex if it is an articulation point
     * or not, by removing it and then counting the number of connected components in the graph. If the number of components increases then the vertex
     * under consideration is an articulation point otherwise not.
     * @param adjacencyMatrix adjacency matrix representation of a graph
     * @param V number of vertices in a graph
     */
    public static void bruteForce(int[][] adjacencyMatrix, int V) {

    }
    public static void main(String[] args) {

    }
}
