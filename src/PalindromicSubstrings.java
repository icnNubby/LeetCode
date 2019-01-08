/**
 * <a href = "https://leetcode.com/problems/palindromic-substrings/">Problem here.</a>
 */
public class PalindromicSubstrings {
    public static void main(String[] args) {
        PalindromicSubstrings test = new PalindromicSubstrings();
        System.out.println(test.countSubstrings("aaa"));
    }

    private boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        int i = -1;
        while (++i <= (s.length() - 1) / 2) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }

    private int countPalindromesAroundMiddle(String s, int middle) {
        int i = 0;
        int count = 0;
        while (middle - i >= 0 && middle + i < s.length()) {
            if (isPalindrome(s.substring(middle - i, middle + i + 1))) count++;
            if (middle < s.length() - 1 && s.charAt(middle) == s.charAt(middle + 1)) {
                if (middle + i + 1 < s.length() && isPalindrome(s.substring(middle - i, middle + i + 2))) count++;
            }
            i++;
        }
        return count;
    }

    public int countSubstrings(String s) {
        int totalCount = 0;
        for (int i = 0; i < s.length(); i++) totalCount += countPalindromesAroundMiddle(s, i);
        return totalCount;
    }
}
