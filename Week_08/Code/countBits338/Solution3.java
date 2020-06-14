package countBits338;

/**
 * 动态规划+最低有效位
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution3 {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
