package Problem4_LongestPalindromicSubstring;

/**
 * <h1>Class for Dynamic Programming approach.</h1>
 *
 * @author xinli
 */
class DynamicProgamming {
    /**
     * <h2>Main method for <em>Dynamic Programming Approach</em>.</h2>
     * There are two base cases:
     * <ol type="1">
     *     <li>A single character is a palindrome.</li>
     *     <li>Two identical characters is a palindrome.</li>
     * </ol>
     * <h2>Complexity Analysis</h2>
     * <ul>
     *     <li>Time Complexity: O(n^2).</li>
     *     <li>Space Complexity: O(n^2).</li>
     * </ul>
     * @param s input string to find the longest palindrome
     * @return the longest palindrome
     */
    static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int n = s.length();
        String longestPalindrome = "";
        int palindromeLen = 0;
        // Create a Dynamic Programming Table to store the results of palindrome check.
        boolean[][] isPalindrome = new boolean[n][n];
        // Initializations. (Base cases)
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
            if (isPalindrome[i][i]) {
                longestPalindrome = s.substring(i, i + 1);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));
            if (isPalindrome[i][j]) {
                longestPalindrome = s.substring(i, j + 1);
            }
        }
        // File up the Dynamic Programming Table.
        for (int k = 2; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                int j = i + k;
                isPalindrome[i][j] = (isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j));
                int len = j - i + 1;
                if (isPalindrome[i][j] && len > palindromeLen) {
                    longestPalindrome = s.substring(i, j + 1);
                    palindromeLen = len;
                }
            }
        }
        return longestPalindrome;
    }
}
