package Problem4_LongestPalindromicSubstring;

public class Main {
    public static void main(String[] args) {
        String testStr = "asdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewq";
        System.out.println("Dynamic Programming Approach");
        long dpStart = System.nanoTime();
        System.out.println(DynamicProgamming.longestPalindrome(testStr));
        long dpEnd = System.nanoTime();
        System.out.println("Elapsed time: " + (dpEnd - dpStart));
        System.out.println("======================");
        System.out.println("Expand Around Center Approach");
        long expandStart = System.nanoTime();
        System.out.println(ExpandAroundCenter.longestPalindrome(testStr));
        long expandEnd = System.nanoTime();
        System.out.println("Elapsed time: " + (expandEnd - expandStart));
        System.out.println("======================");
        System.out.println("Manacher's Algorithm");
        long manacherStart = System.nanoTime();
        System.out.println(ManacherAlgorithm.longestPalindrome(testStr));
        long manacherEnd = System.nanoTime();
        System.out.println("Elapsed time: " + (manacherEnd - manacherStart));
        System.out.println("======================");
    }
}
