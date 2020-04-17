package removeDuplicates26;

/**
 * @author yangbaiyinnamula
 * @date 2020-04-14
 * 使用双指针
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[k]) {
                k++;
                nums[k] = nums[i];
            }
        }
        return k + 1;
    }
}
