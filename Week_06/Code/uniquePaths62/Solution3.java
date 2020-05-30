package uniquePaths62;

import java.util.Arrays;

/**
 * 解题思路：动态规划
 * 时间复杂度：O(m * n)
 * 空间复杂度：O(n)
 */
public class Solution3 {
    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j-1];
            }
        }
        return cur[n-1];
    }
}
