package maxProfit121;

/**
 * 解题思路：动态规划
 * 时间复杂度：O(n),n 是数组长度或股票天数
 * 空间复杂度：O(1)
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        //由于第一天的最低股票价格就是当天的股票价格
        int minPrice = prices[0];
        //记录到当天为止能获取的最大利润
        int maxProfits = 0;
        for (int i = 1; i < prices.length; i++) {
            // 当天最大利润等于当天价格-到前一天为止最低股价：prices[i] - dp[i - 1]
            maxProfits = Math.max(maxProfits, prices[i] - minPrice);
            //记录到今天为止最低股价
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfits;
    }
}
