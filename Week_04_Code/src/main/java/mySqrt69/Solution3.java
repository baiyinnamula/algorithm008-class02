package mySqrt69;

/**
 * 解题思路：秀珍计算器算法
 * 时间复杂度：O(1)
 * 空间复杂度：O(1)
 */
public class Solution3 {
    public int mySqrt(int x) {
        if (x == 0) {
            return x;
        }

        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
}
