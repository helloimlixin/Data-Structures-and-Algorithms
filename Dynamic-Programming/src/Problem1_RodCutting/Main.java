package Problem1_RodCutting;

public class Main {
    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20, 20, 20, 22, 24, 28, 32, 34, 34, 35, 39};
        int length = prices.length;

        // Test the running time for the Brute-Force Solution.
        long bruteForceStartTime = System.nanoTime();
        System.out.println("Max profit: " + BruteForceSolution.maxProfit(prices, length));
        long bruteForceEndTime = System.nanoTime();
        System.out.println("Running time for the Brute Force Solution in milliseconds: " + (bruteForceEndTime - bruteForceStartTime));

        System.out.println("=========================");

        // Test the running time for the Dynamic Programming Solution.
        long DPSolutionStartTime = System.nanoTime();
        System.out.println("Max profit: " + DynamicProgrammingSolution.maxProfit(prices, length));
        long DPSolutionEndTime = System.nanoTime();
        System.out.println("Running time for the Dynamic Programming Solution in milliseconds: " + (DPSolutionEndTime - DPSolutionStartTime));
    }
}
