package maxProfit122;

/**
 * 解题思路：峰谷法
 *
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        int valley;
        int peak;
        int i = 0;
        int maxProfit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] > prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            maxProfit += peak - valley;
        }

        return maxProfit;
    }
}
