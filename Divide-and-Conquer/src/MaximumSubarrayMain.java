public class MaximumSubarrayMain {
    public static void main(String[] args) {
        int A[] = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int[] result = MaximumSubarray.FindMaximumSubarray(A, 0, A.length-1);
        System.out.printf("The maximum subarray is from index %d to index %d, and the sum is: %d.", result[0]+1, result[1]+1, result[2]);
        System.out.println();
    }
}
