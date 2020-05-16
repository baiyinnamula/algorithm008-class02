package mySqrt69;

/**
 * 解题思路：二分查找
 * 注意事项：取右中位数
 * 时间复杂度：O(logN)
 * 空间复杂度：O(1)
 */
public class Solution1 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long left = 1;
        long right = x / 2;

        while (left < right) {
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }
}
