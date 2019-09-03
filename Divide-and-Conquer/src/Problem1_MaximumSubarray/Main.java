package Problem1_MaximumSubarray;

public class Main {
    public static void main(String[] args) {
        int[] A = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        MaximumSubarray maximumSubarray = new MaximumSubarray();

        // Solve using Brute-Force Algorithm.
        long startTime = System.nanoTime();
        int[] result_bruteForce = maximumSubarray.bruteForce(A, 0, A.length-1);
        long endTime   = System.nanoTime();
        System.out.printf("The maximum subarray is from index %d to index %d, and the sum is: %d. (Brute-Force Solution)", result_bruteForce[0]+1, result_bruteForce[1]+1,
                result_bruteForce[2]);
        System.out.printf("\nThe run time for Brute-Force Solution: %d\n", endTime - startTime);

        System.out.println("==================================================================================================");

        // Solve using Divide-and-Conquer.
        startTime = System.nanoTime();
        int[] result = maximumSubarray.findMaximumSubarray(A, 0, A.length-1);
        endTime = System.nanoTime();
        System.out.printf("The maximum subarray is from index %d to index %d, and the sum is: %d. (Divide-and-Conquer Solution)", result[0]+1, result[1]+1, result[2]);
        System.out.printf("\nThe run time for Divide-and-Conquer Solution: %d", endTime - startTime);
    }
}
