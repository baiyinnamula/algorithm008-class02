package countBits338;

/**
 * 解题思路：动态规划+最后设置位
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution4 {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[(i & (i - 1))] + 1;
        }
        return ans;
    }
}
