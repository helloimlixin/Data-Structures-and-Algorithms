package Problem1_RodCutting;

/**
 * Dynamic Programming Approach to the Rod Cutting Problem.
 *
 * @author xinli
 */
class DynamicProgrammingSolution {
    /**
     * Main method of the dynamic programming solution, the gist of this algorithm is
     * to memorize the max profit from cutting a rod of length i so that this piece of
     * information can later be used when needed. This saves from carrying out the same
     * calculation over and over again, and since there are two loops in the algorithm,
     * one loop is to loop through all the possible lengths of the rod, and the other is
     * to loop through the rest of the rod every iteration trying to find the maximum value.
     * So the runtime of this algorithm is O(n^2).
     * @param prices price value for every length of the rod
     * @param length total length of the rod
     * @return an integer value of the maximum profit from cutting the rod
     */
    static int maxProfit(int[] prices, int length) {
        // Declare an array to store the Look-Up Table values for rod cutting profits.
        int[] profits = new int[length + 1];
        // Base case: when the rod length is 0, there's nothing to sell. (can be omitted though)
        profits[0] = 0;

        // Consider rod of length i, fill out the Dynamic Programming table.
        for (int i = 1; i <= length; i++) {
            int maxProfit = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                int profit = prices[j] + profits[i - (j + 1)];
                if (profit > maxProfit) maxProfit = profit;
            }
            profits[i] = maxProfit;
        }
        return profits[length];
    }
}
