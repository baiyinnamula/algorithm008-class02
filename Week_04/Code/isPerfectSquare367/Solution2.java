package isPerfectSquare367;

/**
 * 解题思路：牛顿迭代法
 * 时间复杂度：O(logn)
 * 空间复杂度：O(1)
 */
public class Solution2 {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return (x * x == num);
    }
}
