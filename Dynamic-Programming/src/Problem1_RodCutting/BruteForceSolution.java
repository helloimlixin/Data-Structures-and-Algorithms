package Problem1_RodCutting;

/**
 * Brute Force Solution for Rod Cutting Problem.
 *
 * @author xinli
 */
class BruteForceSolution {
    /**
     * Main method for the Brute Force approach for the Rod Cutting Problem, here we are taking
     * a recursive approach, keep moving the left end of the rod while trying to figure out the
     * maximum profit possible to cut the rest of the rod while keeping the right portion of the
     * rod fixed each iteration. Since for a rod of length n, there are a total of n - 1 slots to
     * decide whether to make a cut, we have the running time of the algorithm is O(2^(n-1)).
     * @param prices price value for every length of the rod
     * @param length total length of the rod
     * @return an integer value of the maximum profit from cutting the rod
     */
    static int maxProfit(int[] prices, int length) {
        // If the length is 0, then there's nothing to sell.
        if (length == 0) return 0;
        int maxProfit = Integer.MIN_VALUE;
        // Loop through all the possible positions to make the cut.
        for (int i = 0; i < length; i++) {
            int profit = prices[i] + maxProfit(prices, length - (i + 1));
            if (profit > maxProfit) maxProfit = profit;
        }
        return  maxProfit;
    }
}
