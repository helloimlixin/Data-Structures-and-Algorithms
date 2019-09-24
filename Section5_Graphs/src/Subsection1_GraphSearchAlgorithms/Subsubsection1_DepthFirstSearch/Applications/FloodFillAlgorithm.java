package Subsection1_GraphSearchAlgorithms.Subsubsection1_DepthFirstSearch.Applications;

import java.util.Arrays;

/**
 * <h1>Class for Flood Fill Algorithm</h1>
 * Flood fill algorithm helps in visiting each and every point in a given area. It determines the area connected to a
 * given cell in a multi-dimensional array. It can be simply modeled as a graph traversal problem and solved using DFS.
 * Specifically, the given area can be represented as a matrix and considering every cell of that matrix as a vertex
 * that is connected to points near it (it can be above, below, right, left, and diagonal, in total 8 possible positions).
 *
 * @author xinli thanks to <a href="https://www.techiedelight.com/flood-fill-algorithm/">this post</a>.
 */
public class FloodFillAlgorithm {
    // Static variables for eight basic directions.
    private static final int[] vertical = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] horizontal = {-1, 0, 1, -1, 1, -1, 0, 1};

    /**
     * <h2>Main method for Flood Fill Algorithm using DFS</h2>
     * @param matrix image matrix
     * @param dim dimension of the matrix
     * @param x starting vertex x coordinate
     * @param y starting vertex y coordinate
     * @param replacement color for replacement
     */
    public static void floodFill(char[][] matrix, int[] dim, int x, int y, char replacement) {
        char targetColor = matrix[x][y];
        matrix[x][y] = replacement;
        for (int i = 0; i < vertical.length; i++) {
            if (validateVertex(matrix, dim, x + vertical[i], y + horizontal[i], targetColor)) {
                floodFill(matrix, dim, x + vertical[i], y + horizontal[i], replacement);
            }
        }
    }

    /**
     * <h2>Utility method to print a char matrix</h2>
     * @param matrix matrix to print
     */
    public static void printMatrixUtil(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    /**
     * <h2>Check if vertex is valid (within the boundaries or not visited)</h2>
     * @param matrix char matrix representing input image
     * @param dim dimension of the matrix
     * @param x starting vertex x coordinate
     * @param y starting vertex y coordinate
     * @param targetColor color to replace
     * @return a boolean value representing validation result, <code>true</code> if the vertex is valid, <code>false</code> otherwise
     */
    public static boolean validateVertex(char[][] matrix, int[] dim, int x, int y, char targetColor) {
        return (x < dim[0] && x >= 0 && y < dim[1] && y >= 0 && matrix[x][y] == targetColor);
    }

    /**
     * Driver method
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Matrix showing portion of the screen having different colors.
        char[][] matrix = {
                "YYYGGGGGGG".toCharArray(),
                "YYYYYYGXXX".toCharArray(),
                "GGGGGGGXXX".toCharArray(),
                "WWWWWGGGGX".toCharArray(),
                "WRRRRRGXXX".toCharArray(),
                "WWWRRGGXXX".toCharArray(),
                "WBWRRRRRRX".toCharArray(),
                "WBBBBRRXXX".toCharArray(),
                "WBBXBBBBXX".toCharArray(),
                "WBBXXXXXXX".toCharArray()
        };
        System.out.println("Original matrix:");
        printMatrixUtil(matrix);
        System.out.println("==============================");
        // Dimensions of input matrix.
        int M = matrix.length, N = matrix[0].length;
        // Start node.
        int x = 3, y = 9; // target color 'X'.
        // Replacement color
        char replacement = 'C';
        // Replace target color with replacement color using DFS.
        floodFill(matrix, new int[]{M, N}, x, y, replacement);
        System.out.println("Processed matrix:");
        printMatrixUtil(matrix);
        System.out.println("==============================");
    }
}
