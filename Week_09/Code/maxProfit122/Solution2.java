package maxProfit122;

public class Solution2 {
    private int res;

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        this.res = 0;
        dfs(prices, 0, len, 0, res);
        return this.res;
    }

    /**
     * @param prices 股价数组
     * @param index  当前是第几天，从 0 开始
     * @param len    数组长度
     * @param status 0 表示不持有股票，1表示持有股票
     * @param profit 当前收益
     */
    private void dfs(int[] prices, int index, int len, int status, int profit) {
        if (index == len) {
            this.res = Math.max(this.res, profit);
        } else {
            dfs(prices, index + 1, len, status, profit);
            if (status == 0) {
                dfs(prices, index + 1, len, 1, profit - prices[index]);
            } else {
                dfs(prices, index + 1, len, 1, profit + prices[index]);
            }
        }
    }
}