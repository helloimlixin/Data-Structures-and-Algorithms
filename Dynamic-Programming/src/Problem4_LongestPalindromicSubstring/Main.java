package Problem4_LongestPalindromicSubstring;

public class Main {
    public static void main(String[] args) {
        String smallTest = "accca";
        String testStr = "asdfghjkllkjhgfasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqasdfghjkllkjhgasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqasdfghjkllasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqewqasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqdsazxcvbnmmnbvcxzqwertyuasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewqasdfghjkllkjhgfdsazxcvbnmmnbvcxzqwertyuioppoiuytrewqqwertyuioplkjhgfdsazxcvbnmmnbvcxzasdfghjklpoiuytrewq";
        System.out.println("Dynamic Programming Approach");
        long dpStart = System.nanoTime();
        String dpResult = DynamicProgamming.longestPalindrome(testStr);
        long dpEnd = System.nanoTime();
        System.out.println("Elapsed time: " + (dpEnd - dpStart));
        System.out.println("Result: " + dpResult);
        System.out.println("======================");
        System.out.println("Expand Around Center Approach");
        long expandStart = System.nanoTime();
        String expandResult = ExpandAroundCenter.longestPalindrome(testStr);
        long expandEnd = System.nanoTime();
        System.out.println("Elapsed time: " + (expandEnd - expandStart));
        System.out.println("Result: " + expandResult);
        System.out.println("======================");
        System.out.println("Manacher's Algorithm");
        long manacherStart = System.nanoTime();
        String manacherResult = ManacherAlgorithm.longestPalindrome(testStr);
        long manacherEnd = System.nanoTime();
        System.out.println("Elapsed time: " + (manacherEnd - manacherStart));
        System.out.println("Result: " + manacherResult);
    }
}
