/**
 * <a href = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">Problem here.</a>
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock test = new BestTimeToBuyAndSellStock();
        int[] testArray = {7, 6, 4, 3, 1};
        System.out.println(test.maxProfit(testArray));
    }

    public int maxProfit(int[] prices) {
        int currentMinimum = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            currentMinimum = Math.min(currentMinimum, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - currentMinimum);
        }
        return maxProfit;
    }
}
