/**
 * <a href = "https://leetcode.com/problems/shortest-palindrome/">Problem here.</a>
 * Brutforce middlepoint approach.
 * Created by NubbY
 */
public class ShortestPalindrome {

    public static void main(String[] args) {

        String input = "abcd";
        ShortestPalindrome test = new ShortestPalindrome();
        System.out.println(test.shortestPalindrome(input));
    }

    public String shortestPalindrome(String s) {
        /*
            Two problems.
            1. if palindrome length is odd
            2.       -||-           is even
             (aAAabb)
             (aAaAabb)
             (abcd)
         */
        int bestIndex = 0;
        boolean foundOdd = false;
        for (int i = s.length() / 2; i >= 0; i--) {
            //searching for even palindrome
            boolean paliFound1 = true;
            for (int j = 0; j < i; j++) {
                if (i + j >= s.length()) {
                    paliFound1 = false;
                    break;
                }
                //i == 3: j == 0, 1, 2     0 1 2 == 3 4 5
                if (s.charAt(i - j - 1) != s.charAt(i + j)) {
                    paliFound1 = false;
                }
            }
            if (paliFound1) {
                bestIndex = i;
                foundOdd = false;
            }
            //searching for odd palindrome
            boolean paliFound2 = true;
            for (int j = 0; j <= i; j++) {
                if (i + j >= s.length()) {
                    paliFound2 = false;
                    break;
                }
                // i == 3: j == 0, 1, 2     0 1 2 == | == 4 5 6
                if (s.charAt(i - j) != s.charAt(i + j)) {
                    paliFound2 = false;
                }
            }
            if (paliFound2) {
                bestIndex = i;
                foundOdd = true;
            }

            if (paliFound1 || paliFound2) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        int addition = (foundOdd) ? bestIndex * 2 + 1 : bestIndex * 2;
        for (int i = s.length() - 1; i >= addition; i--) {
            sb.append(s.charAt(i));
        }
        sb.append(s);
        return sb.toString();
    }
}
