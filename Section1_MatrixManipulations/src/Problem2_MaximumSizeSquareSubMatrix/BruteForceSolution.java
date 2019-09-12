package Problem2_MaximumSizeSquareSubMatrix;

class BruteForceSolution {
    static int maxSubSquare(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int N = Math.min(m, n);
        int maxArea = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < m - i + 1; j++) {
                for (int k = 0; k < n - i + 1; k++) {
                    int[] nums = new int[i * i];
                    int index = 0;
                    for (int row = j; row < j + i; row++) {
                        for (int col = k; col < k + i; col++) {
                            nums[index++] = matrix[row][col];
                        }
                    }
                    if (!containsZero(nums) && (i * i > maxArea)) {
                        maxArea = i * i;
                    }
                }
            }
        }
        return maxArea;
    }

    private static boolean containsZero(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) return true;
        }
        return false;
    }
}
