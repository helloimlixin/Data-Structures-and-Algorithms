package Problem3_KadaneAlgorithm;

class KadaneAlgorithm {
    static int maximumContiguousSubarray(int[] array) {
        int maxSum = array[0];
        int maxCurrent = array[0];
        for (int i = 1; i < array.length - 1; i++) {
            maxCurrent = Math.max(array[i], array[i] + maxCurrent);
            if (maxCurrent > maxSum) maxSum = maxCurrent;
        }
        return maxSum;
    }
}
