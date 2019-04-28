/**
 * <a href = "https://leetcode.com/problems/maximal-square/">Problem here.</a>
 * Created by NubbY
 */
public class MaximalSquare {
    public static void main(String[] args) {
        MaximalSquare test = new MaximalSquare();
        char[][] testArr = new char[][]
                {{1, 0, 0, 0, 0},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 1, 1},
                        {1, 0, 1, 1, 1}};
        System.out.println(test.maximalSquare(testArr));
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int[][] dp = new int[matrix.length][matrix[0].length];

        //initialising starting edges
        dp[0][0] = (matrix[0][0] == '0') ? 0 : 1;
        int max = dp[0][0];

        for (int i = 1; i < matrix.length; i++) {
            dp[i][0] = (matrix[i][0] == '0') ? 0 : 1;
            max = Math.max(dp[i][0], max);
        }
        for (int i = 1; i < matrix[0].length; i++) {
            dp[0][i] = (matrix[0][i] == '0') ? 0 : 1;
            max = Math.max(dp[0][i], max);
        }


        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {

                dp[i][j] = (matrix[i][j] != '0') ? Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1 : 0;
                max = Math.max(dp[i][j], max);
            }
        }

        return max * max;
    }
}
