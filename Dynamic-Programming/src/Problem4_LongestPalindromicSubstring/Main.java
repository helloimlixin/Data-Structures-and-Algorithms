package Problem4_LongestPalindromicSubstring;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a string: ");
        while (scan.hasNext()) {
            String s = scan.nextLine();
//            DynamicProgamming dynamicProgamming = new DynamicProgamming();
            System.out.println(ExpandAroundCenter.longestPalindrome(s));
        }
        scan.close();
    }
}
