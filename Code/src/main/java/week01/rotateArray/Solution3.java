package week01.rotateArray;

/**
 * @author yangbaiyinnamula
 * 使用反转:这个方法神巧妙
 * 原始数组                  : 1 2 3 4 5 6 7
 * 反转所有数字后             : 7 6 5 4 3 2 1
 * 反转前 k 个数字后          : 5 6 7 4 3 2 1
 * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * <p>
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution3 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
