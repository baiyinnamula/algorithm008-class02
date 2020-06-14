package countBits338;

/**
 * 解题思路：pop count
 * 时间复杂度：O(nk) 对于每个整数 xx，我们需要 O(k)O(k) 次操作，其中 kk 是 xx 的位数。
 * 空间复杂度：O(n)
 */
public class Solution1 {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            ans[i] = popcount(i);
        }

        return ans;
    }

    public int popcount(int x) {
        int count = 0;
        for (count = 0; x != 0; count++) {
            x &= x - 1;
        }
        return count;
    }

}
