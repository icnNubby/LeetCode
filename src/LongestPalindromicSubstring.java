/**
 * <a href = "https://leetcode.com/problems/longest-palindromic-substring/">Problem here.</a>
 * Created by NubbY
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
        System.out.println(test.longestPalindrome("babad"));
        System.out.println(test.longestPalindrome("cbbd"));
        System.out.println(test.longestPalindrome("cadssaababababaaaaaabbbbd"));

    }

    private String biggestOddPalindrome(String s, int position) {
        int expand = 1;
        while (position - expand >= 0 && position + expand < s.length() &&
                s.charAt(position - expand) == s.charAt(position + expand)) {
            expand++;
        }
        expand--;
        return s.substring(position - expand, position + expand + 1);
    }

    private String biggestEvenPalindrome(String s, int left, int right) {
        if (s.charAt(left) != s.charAt(right)) {
            return "";
        }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        left++;
        right--;
        return s.substring(left, right + 1);
    }

    public String longestPalindrome(String s) {
        String out = "";
        for (int i = 0; i < s.length(); i++) {
            String biggestOdd = biggestOddPalindrome(s, i);
            String biggestEven = "";
            if (i > 0) {
                biggestEven = biggestEvenPalindrome(s, i - 1, i);
            }
            if (biggestEven.length() > biggestOdd.length() && biggestEven.length() > out.length()) {
                out = biggestEven;
            } else if (biggestOdd.length() > biggestEven.length() && biggestOdd.length() > out.length()) {
                out = biggestOdd;
            }
        }
        return out;
    }
}
