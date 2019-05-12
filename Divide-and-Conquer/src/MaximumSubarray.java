/**
 * <h1>MaximumSubarray</h1>
 *
 * @author xinli
 */
public class MaximumSubarray {
    public static int[] FindMaxCrossingSubarray(int A[], int low, int mid, int high) {
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

    public static int[] FindMaximumSubarray(int[] A, int low, int high) {
        if (high == low) {
            return new int[] {low, high, A[low]};
        } else {
            int mid = (low + high)/2;
            int[] left = FindMaximumSubarray(A, low, mid);
            int[] right = FindMaximumSubarray(A, mid+1, high);
            int[] cross = FindMaxCrossingSubarray(A, low, mid, high);
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
