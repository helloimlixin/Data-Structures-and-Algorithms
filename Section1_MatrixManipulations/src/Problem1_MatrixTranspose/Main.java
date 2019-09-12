package Problem1_MatrixTranspose;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        System.out.println("Original Matrix:");
        printMatrix(matrix);
        System.out.println("===================");
        System.out.println("Matrix after transpose:");
//        printMatrix(StraightForwardTranspose.transpose(matrix));
        printMatrix(InplaceTranspose.transpose(matrix));
    }
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i : row) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
