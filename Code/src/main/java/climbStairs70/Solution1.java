package climbStairs70;

/**
 * @author yangbaiyinnamula
 * 方法：动态规划,使用一个数组来每个台阶数量对应的走法数量
 * 楼梯数：走法数
 * 1：1
 * 2：2
 * 3：3
 * i: k(i-1) + k(i-2)
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 */
public class Solution1 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] counts = new int[n + 1];
        counts[1] = 1;
        counts[2] = 2;
        for (int i = 3; i <= n; i++) {
            counts[i] = counts[i - 1] + counts[i - 2];
        }

        return counts[n];
    }
}

