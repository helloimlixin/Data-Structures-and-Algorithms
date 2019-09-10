package Problem4_LongestPalindromicSubstring;

import java.util.Arrays;

/**
 * <h1>Class for Manacher's Algorithm</h1>
 * <p>
 *     This algorithm can be thought as an optimization over the `ExpandAroundCenter` algorithm, where
 *     we avoid checking the same palindrome over and over again as we do in the `ExpandAroundCenter` algorithm.
 * </p>
 * <h2>Complexity Analysis</h2>
 * - Time Complexity: O(n).
 * - Space Complexity: O(1).
 * @author xinli
 */
class ManacherAlgorithm {
    /**
     * <h2>Main method for finding the longest palindromic substring.</h2>
     * <p>
     *     This method uses the concepts of mirror line and by expanding the right and left boundaries
     *     to find the length of the longest palindromic substring and store the length in an array.
     * </p>
     * @param s input string
     * @return the longest palindromic substring
     */
    static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        // Prepocess the string s by inserting '#' characters between each character in s, including
        // the outer boundaries. The processed result is in the format of a char array for faster
        // manipulations.
        char[] originalStr = s.toCharArray();
        char[] processedStr = preProcessing(originalStr);
        int N = processedStr.length;
        // Create an array to store the lengths of the palindrome for each center point in s (initially
        // all 0's).
        int[] p = new int[N];
        // Define two pointers to track.
        int center = 0; // mirror line
        int right = 0; // right bound
        // Loop through the processed string skipping the boundaries.
        for (int i = 1; i < N - 1; i++) {
            // The mirror index on the left of the mirror line.
            int mirror = center - (i - center);
            // When the cursor is within the current palindromic boundaries, make sure the expansion
            // does not overreach the current right boundary.
            if (right > i) {
                p[i] = Math.min(right  - i, p[mirror]);
            }
            // Expand while the palindrome condition matches.
            while (processedStr[i + (1 + p[i])] == processedStr[i - (1 + p[i])]) {
                p[i]++;
            }
            // If the expansion goes beyond the right bound, update the center and the right bound
            // correspondingly.
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
        // Find the longest palindrome.
        int maxLen = 0;
        int centerIdx = 0;
        for (int i = 1; i < N - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIdx = i;
            }
        }
        // We can use String.substring method here, but still the array operation is slightly faster.
        return new String(Arrays.copyOfRange(originalStr, (centerIdx - 1 - maxLen) / 2, (centerIdx - 1 + maxLen) / 2));
    }

    /**
     * <h2>Helper class for preprocessing.</h2>
     * <p>
     *     Preprocess string str into a char array.
     *     For example, if `s = "abaabac"`, then the resulting char array `chars = "$#a#b#a#a#b#a#c#@"`,
     *     where "#" are interleaved symbol to avoid even/odd-Length palindromes uniformly, while "$" and "@" are
     *     prepended and appended to each end to avoid bounds checking (they must be different!).
     * </p>
     * @param str input string to be processed
     * @return processed string with "#"'s
     */
    private static char[] preProcessing(char[] str) {
        int n = str.length;
        // Here we use char arrays for speed.
        char[] chars = new char[2 * n + 3];
        chars[0] = '$';
        chars[2 * n + 2] = '@';
        for (int i = 0; i < n; i++) {
            chars[2 * i + 1] = '#';
            chars[2 * i + 2] = str[i];
        }
        chars[n * 2 + 1] = '#';
        return chars;
    }
}