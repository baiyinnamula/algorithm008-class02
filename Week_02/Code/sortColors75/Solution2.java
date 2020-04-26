package sortColors75;

/**
 * 解题思路：使用3指针
 * 时间复杂度：O(N)
 * 空间复杂度：O(1)
 */
public class Solution2 {
    public void sortColors(int[] nums) {
        //已找到的0的最右边界
        int p0 = 0;
        //当前遍历位置
        int current = 0;
        //已找到2的最左边界
        int p2 = nums.length - 1;
        while (current <= p2) {
            if (nums[current] == 0) {
                //p0 current 交换值，并且都右移
                nums[current++] = nums[p0];
                nums[p0++] = 0;
            } else if (nums[current] == 2) {
                //p2 current 交换值，只有P2 左移
                nums[current] = nums[p2];
                nums[p2--] = 2;
            } else {
                //遍历下一个元素
                current++;
            }
        }
    }
}
