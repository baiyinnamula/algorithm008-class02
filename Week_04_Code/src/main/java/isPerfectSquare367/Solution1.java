package isPerfectSquare367;

/**
 * 解题思路：二分查找
 * 时间复杂度：O(logn)
 * 空间复杂度：O(1)
 */
public class Solution1 {
    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num / 2 + 1;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            if (square == num) {
                return true;
            }
            if (square > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
