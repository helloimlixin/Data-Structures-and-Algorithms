package Subsection1_GraphSearchAlgorithms.DepthFirstSearch;

import Subsection1_GraphSearchAlgorithms.Graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 2) {
            System.out.println("Please enter file name and source vertex:");
        } else {
            String filename = args[0]; // input file representing graph
            int src = Integer.parseInt(args[1]); // source vertex for graph traversal
            // Read the file into a graph object using scanner.
            Scanner in = new Scanner(new FileInputStream(filename));
            while (in.hasNext()) {
                System.out.println("======================================");
                System.out.println("Initializing graph creation procedure...");
                int V = Integer.parseInt(in.nextLine());
                Graph graph = new Graph(V);
                System.out.printf("Graph with %d vertices created.\n", V);
                int E = Integer.parseInt(in.nextLine());
                for (int i = 0; i < E; i++) {
                    String[] edgeVertices = in.nextLine().split(" ");
                    int start = Integer.parseInt(edgeVertices[0]);
                    int end = Integer.parseInt(edgeVertices[1]);
                    graph.addEdge(start, end);
                    System.out.printf("Edge %d - %d added.\n", start, end);
                }
                System.out.println("Graph creation procedure completed.");
                System.out.printf("Number of graph vertices: %d.\n", graph.V);
                System.out.printf("Number of graph edges: %d.\n", graph.E);
                System.out.println("======================================");
                DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, src);
                depthFirstSearch.traverse();
                DepthFirstPaths depthFirstPaths = new DepthFirstPaths(graph, src);
                for (int v = 0; v < graph.V; v++) {
                    if (depthFirstPaths.hasPathTo(v)) {
                        System.out.printf("%d to %d: ", src, v);
                        Stack<Integer> paths = depthFirstPaths.pathTo(v);
                        while (!paths.isEmpty()){
                            int i = paths.pop();
                            if (i == src)
                                System.out.print(i);
                            else
                                System.out.print(" -> " + i);
                        }
                        System.out.println();
                    } else {
                        System.out.printf("%d to %d: NOT CONNECTED!\n", src, v);
                    }
                }
            }
        }
    }
}
