package Problem1_MatrixTranspose;

class StraightForwardTranspose {
    static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] matrix_T = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix_T[j][i] = matrix[i][j];
            }
        }
        return matrix_T;
    }
}
