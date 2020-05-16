package maxProfit122;

/**
 * 解题思路：峰谷法（贪婪算法）
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        int valley = prices[0];
        int peak = valley;
        int max = 0;
        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] < prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            max += peak - valley;
        }

        return max;
    }
}
