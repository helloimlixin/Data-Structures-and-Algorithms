package Problem2_MaximumSizeSquareSubMatrix;

import static Problem2_MaximumSizeSquareSubMatrix.PrintMatrixUtil.printMatrix;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };
        System.out.println("Original Matrix:");
        printMatrix(matrix);
        System.out.println("=================");
        System.out.println("Size of the maximum all 1 submatrix: " + BruteForceSolution.maxSubSquare(matrix));
    }
}
