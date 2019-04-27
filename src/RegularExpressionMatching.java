import java.util.Arrays;

/**
 * <a href = "https://leetcode.com/problems/regular-expression-matching/">Problem here.</a>
 * Created by NubbY
 */
public class RegularExpressionMatching {

    public static void main(String[] args) {
        RegularExpressionMatching test = new RegularExpressionMatching();
        System.out.println("True? = " + test.isMatch("aab", "c*a*b"));
        System.out.println("True? = " + test.isMatch("ab", ".*"));
        System.out.println("True? = " + test.isMatch("aa", "a*"));
        System.out.println("False? = " + test.isMatch("mississippi", "mis*is*p*."));
    }

    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*' && dp[0][j - 1]) {
                dp[0][j + 1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {

                if (s.charAt(i) == p.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }

                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }

                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i + 1][j - 1] || dp[i][j + 1]);
                    }
                }

            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[s.length()][p.length()];
    }
}
