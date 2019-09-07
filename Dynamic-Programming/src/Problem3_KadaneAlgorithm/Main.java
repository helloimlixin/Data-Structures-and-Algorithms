package Problem3_KadaneAlgorithm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("The maximum sum of a contiguous subarray is: " + KadaneAlgorithm.maximumContiguousSubarray(array));
    }
}
