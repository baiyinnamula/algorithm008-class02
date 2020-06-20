package maxProfit122;

/**
 * 解题思路：动态规划
 */
public class Solution3 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        // 0：持有现金
        // 1：持有股票
        int cash = 0;
        int hold = -prices[0];
        int preCash = cash;
        int preHold = hold;
        for (int i = 1; i < len; i++) {
            //第i天手上没有股票时状态：要么前一天没有股票，要么当天卖出
            cash = Math.max(preCash, preHold + prices[i]);
            //第i天手上有股票时状态：要么前一天就有股票，要么当天买入
            hold = Math.max(preHold, preCash - prices[i]);
            preCash = cash;
            preHold = hold;
        }
        return cash;
    }
}
