package maxProduct152;

/**
 * 解题思路：动态规划
 * 时间复杂度： O(n)
 * 时间复杂度： O(1)
 */
public class Solution1 {
    public int maxProduct(int[] nums) {
        int curMax = nums[0];
        int curMin = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int preMax = curMax;
            int preMin = curMin;
            curMax = Math.max(preMax * nums[i], Math.max(nums[i], preMin * nums[i]));
            curMin = Math.min(preMin * nums[i], Math.min(nums[i], preMax * nums[i]));
            ans = Math.max(ans, curMax);
        }

        return ans;
    }
}
