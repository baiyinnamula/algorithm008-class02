package coinChange322;

/**
 * 解题思路：动态规划+自上而下
 * 时间复杂度：O(S *N):其中 S 是金额，N 是硬币面额数。
 * 空间复杂是：O(S):其中 S 是金额。
 */
public class Solution1 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    /**
     * @param coins  可选硬币
     * @param amount 总金额
     * @param count  动态数组：结构count[总金额] = 最少硬币数
     * @return
     */
    public int coinChange(int[] coins, int amount, int[] count) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        //如果已经找到了最少硬币数，则最直接返回
        if (count[amount - 1] != 0) {
            return count[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        //依次查找当前总金额减去硬币面值后的总金额对应的最少硬币数
        for (int coin : coins) {
            int res = coinChange(coins, amount - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount - 1];
    }
}
