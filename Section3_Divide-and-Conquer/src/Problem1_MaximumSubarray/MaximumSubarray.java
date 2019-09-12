package Problem1_MaximumSubarray;

/**
 * <h1>MaximumSubarray.MaximumSubarray</h1>
 *
 * @author xinli
 */
class MaximumSubarray {

    /**
     * <h2>Brute Force Solution</h2>
     * <p>
     *     This method implements a Brute-Force Solution to the Maximum Subarray Problem. The idea of this solution is essentially traverse all possible pair of date pairs in which
     *     the buy date precedes the sell date and find the pair the has the maximum sum of changes (given by an array of daily stock price changes).
     * </p>
     * @param A input array of changes in stock prices on a daily basis
     * @param low optimal low price index for buying stocks
     * @param high optimal high price index for selling stocks
     * @return new int[] {low, high, max_diff} an integer array of the low and high indices along with the maximum difference from stock exchange (buy low, sell high)
     */
    int[] bruteForce(int[] A, int low, int high) {
        // Variable initializations.
        int size_A = A.length;
        int max_diff = Integer.MIN_VALUE;

        // Loop through all the possible buy date.
        for (int i = 0; i < size_A - 1; i++) {
            // Initialize a subarray sum for each buy date.
            int sum = A[i];
            // Compute the maximum differences for all possible sell dates and save the indices of optimal buy and sell dates.
            for (int j = i + 1; j < size_A; j++) {
                sum += A[j];
                if (sum > max_diff) {
                    max_diff = sum;
                    low = i;
                    high = j;
                }
            }
        }
        return new int[] {low, high, max_diff};
    }

    /**
     * <h2>Find the maximum subarray crossing the midpoint.</h2>
     * <p>
     *     This method takes as input the array A and the indices low, mid, and high and returns a tuple containing indices demarcating a maximum subarray that crosses the midpoint, along with the sum of the values
     *     in a maximum subarray.
     * </p>
     * @param A input array
     * @param low optimal low price index for buying stocks when the subarray crosses the midpoint
     * @param mid midpoint that the subarray is required to cross
     * @param high optimal high price index for selling stocks
     * @return new int[] {low, high, max_diff} an integer array of the low and high indices along with the maximum difference from stock exchange (buy low, sell high)
     */
    private int[] findMaxCrossingSubarray(int[] A, int low, int mid, int high) {
        int left_sum = Integer.MIN_VALUE;
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        for (int i = mid; i > low; i--) {
            sum += A[i];
            if (sum > left_sum) {
                left_sum = sum;
                max_left = i;
            }
        }
        int right_sum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid+1; i < high; i++) {
            sum += A[i];
            if (sum > right_sum) {
                right_sum = sum;
                max_right = i;
            }
        }

        return new int[] {max_left, max_right, left_sum+right_sum};
    }

    /**
     *
     * @param A input array of changes in stock prices on a daily basis
     * @param low optimal low price index for buying stocks
     * @param high optimal high price index for selling stocks
     * @return new int[] {low, high, max_diff} an integer array of the low and high indices along with the maximum difference from stock exchange (buy low, sell high)
     */
    int[] findMaximumSubarray(int[] A, int low, int high) {
        if (high == low) {
            return new int[] {low, high, A[low]};
        } else {
            int mid = (low + high)/2;
            int[] left = findMaximumSubarray(A, low, mid);
            int[] right = findMaximumSubarray(A, mid+1, high);
            int[] cross = findMaxCrossingSubarray(A, low, mid, high);
            int left_sum = left[2];
            int right_sum = right[2];
            int cross_sum = cross[2];

            if (left_sum >= right_sum && left_sum >= cross_sum)
                return left;
            else if (right_sum >= left_sum && right_sum >= cross_sum)
                return right;
            else
                return cross;
        }
    }
}
