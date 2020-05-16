package findContentChildren455;

import java.util.Arrays;

/**
 * 解题思路：使用贪心算法
 * 时间复杂度：O(nlogn): n 为 孩子数量和饼干数量里的较大的
 * 空间复杂度：O(1)
 */
public class Solution1 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; j < s.length && i <g.length; j++) {
            if (g[i] <= s[j]){
                i++;
            }
        }

        return i;
    }
}
