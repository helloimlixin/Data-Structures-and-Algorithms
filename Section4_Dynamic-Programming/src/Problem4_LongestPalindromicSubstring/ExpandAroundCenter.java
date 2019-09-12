package Problem4_LongestPalindromicSubstring;

/**
 * <h1>Class for Expanding Around Center approach.</h1>
 *
 * @author xinli
 */
class ExpandAroundCenter {
    /**
     * <h2>Main method for <em>Expand Around Center Approach</em>.</h2>
     * Note that here there are two cases depending on the length of the palindrome:
     * <ol type="1">
     *     <li>The length of the palindrome is odd, the center would be the middle character.</li>
     *     <li>The length of the palindrome is even, the center would be the middle of the word (not lying on any character)!</li>
     * </ol>
     * <h2>Complexity Analysis</h2>
     * <ul>
     *     <li>Time Complexity: O(n^2).</li>
     *     <li>Space Complexity: O(1).</li>
     * </ul>
     * @param s input string to find the longest palindrome
     * @return the longest palindrome
     */
    static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int n = s.length();
        int palindromeLength = 0;
        String longestPalindrome = "";
        for (int i = 0; i < n; i++) {
            int[] oddLen = expandAroundCenter(s, i, i);
            int[] evenLen = expandAroundCenter(s, i, i + 1);
            if (oddLen[0] > evenLen[0] && oddLen[0] > palindromeLength) {
                palindromeLength = oddLen[0];
                longestPalindrome = s.substring(oddLen[1], oddLen[2]);
            }
            if (evenLen[0] > oddLen[0] && evenLen[0] > palindromeLength) {
                palindromeLength = evenLen[0];
                longestPalindrome = s.substring(evenLen[1], evenLen[2]);
            }
        }
        return longestPalindrome;
    }

    /**
     * <h2>Method to expand around the given center.</h2>
     * Use the <code>left</code> and <code>right</code> pointers to check if the palindrome exists and return the length of the longest palindrome found with given
     * center.
     * @param str input string
     * @param left left pointer
     * @param right right pointer
     * @return length of the resulting palindrome
     */
    private static int[] expandAroundCenter(String str, int left, int right) {
        int palindromeLen = 0;
        int start = left, end = right + 1;
        int len = 0;
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            // Update length if the expanded substring is a palindrome.
            len = right - left + 1;

            if (len > palindromeLen) {
                palindromeLen = len;
                start = left;
                end = right + 1;
            }
            left--;
            right++;
        }
        return new int[] {palindromeLen, start, end};
    }
}
