import java.util.Arrays;

/**
 * <a href = "https://leetcode.com/problems/coin-change/">Problem here.</a>
 * Created by NubbY
 */
public class CoinChange {
    public static void main(String[] args) {
        CoinChange test = new CoinChange();
        int[] testArr = {1, 2, 5};
        System.out.println("3 =? " + test.coinChange(testArr, 11));
        int[] testArr2 = {3};
        System.out.println("-1 =? " + test.coinChange(testArr2, 2));
        int[] testArr3 = {3, 4, 5};
        System.out.println("4 =? " + test.coinChange(testArr3, 16));
        int[] testArr4 = {1, 100};
        System.out.println("2 =? " + test.coinChange(testArr4, 101));
        int[] testArr5 = {2147483647};
        System.out.println("2 =? " + test.coinChange(testArr5, 2));

    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[amount] = 0;
        for (int i = amount - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = amount - 1; i >= 0; i--) {
            int step = 0;
            int currmin = dp[i];
            for (int j = 0; j < coins.length; j++) {
                step = coins[j];
                if ((step <= amount) && ((step + i) <= amount) && (dp[i + step] != Integer.MAX_VALUE)) {
                    currmin = Math.min(dp[i + step] + 1, currmin);
                }
            }
            dp[i] = currmin;
        }
        System.out.println(Arrays.toString(dp));
        if (dp[0] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[0];
        }
    }
}
