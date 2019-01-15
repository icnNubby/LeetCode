/**
 * <a href = "https://leetcode.com/problems/valid-palindrome">Problem here.</a>
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome test = new ValidPalindrome();
        System.out.println(test.isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (!Character.isLetterOrDigit(s.charAt(l)) && l < s.length() - 1) l++;
            while (!Character.isLetterOrDigit(s.charAt(r)) && r > 0) r--;
            if (l >= r) return true;
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
            l++;
            r--;
        }
        return true;
    }
}
