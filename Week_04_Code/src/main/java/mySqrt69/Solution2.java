package mySqrt69;

/**
 * 解题思路：牛顿迭代
 * 时间复杂度：O(logN)
 * 空间复杂度：O(1)
 */
public class Solution2 {
    public int mySqrt(int x) {
        long a = x;
        while (a * a > x) {
            a = (a + x / a) / 2;
        }

        return (int) a;
    }
}
