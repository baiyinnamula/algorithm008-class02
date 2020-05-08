package majorityElement169;

import java.util.Arrays;

/**
 * 时间复杂度：O(NlogN)
 * 空间复杂度：O(NlogN)
 */
public class Solution2 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
