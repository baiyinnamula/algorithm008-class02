package week01.subtractProductAndSum;

/**
 * @author yangbaiyinnamula
 * 1281. 整数的各位积和之差
 * 时间复杂度：O(logn)
 * 空间复杂度：O(1)
 * 提示：1 <= n <= 10^5：所以不用考虑超出整数范围的情况
 */
public class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n > 0) {
            int mod = n % 10;
            product *= mod;
            sum += mod;
            n /= 10;
        }

        return product - sum;
    }
}
