package Problem4_LongestPalindromicSubstring;

/**
 * <h1>Class for Manacher's Algorithm</h1>
 *
 * @author xinli
 */
class ManacherAlgorithm {
    /**
     * <h2>Main method for finding the longest palindromic substring.</h2>
     * @param s input string
     * @return the longest palindromic substring
     */
    static String longestPalindrome(String s) {
        char[] processedStr = preProcessing(s);
        int N = processedStr.length;
        // Create an array to store the palindrome numbers.
        int[] p = new int[N];
        int center = 0; // mirror line
        int right = 0; // right bound
        for (int i = 1; i < N - 1; i++) {
            // The mirror index on the left of the mirror line.
            int mirror = center - (i - center);
            if (right > i) {
                p[i] = Math.min(right  - i, p[mirror]);
            }
            while (processedStr[i + (1 + p[i])] == processedStr[i - (1 + p[i])]) {
                p[i]++;
            }
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
        int maxLen = 0;
        int centerIdx = 0;
        for (int i = 1; i < N - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIdx = i;
            }
        }
        return s.substring((centerIdx - 1 - maxLen) / 2, (centerIdx - 1 + maxLen) / 2);
    }

    /**
     * <h2>Helper class for preprocessing.</h2>
     * Preprocess string str into a char array.
     * For example, if `s = "abaabac"`, then the resulting char array `chars = "$#a#b#a#a#b#a#c#@"`,
     * where "#" are interleaved symbol to avoid even/odd-Length palindromes uniformly, while "$" and "@" are
     * prepended and appended to each end to avoid bounds checking (they must be different!).
     * @param str input string to be processed
     * @return processed string with "#"'s
     */
    private static char[] preProcessing(String str) {
        int n = str.length();
        // Here we use char arrays for speed.
        char[] chars = new char[2 * n + 3];
        chars[0] = '$';
        chars[2 * n + 2] = '@';
        for (int i = 0; i < n; i++) {
            chars[2 * i + 1] = '#';
            chars[2 * i + 2] = str.charAt(i);
        }
        chars[n * 2 + 1] = '#';
        return chars;
    }
}