package maxSubArray53;

/**
 * 解题思路：贪心算法
 * 时间复杂度；O（n)
 * 空间复杂度；O（1)
 */
public class Solution1 {
    public int maxSubArray(int[] nums) {
        //[-2,1,-3,4,-1,2,1,-5,4]
        //[-2,1,-2,4, 3,5,6, 1,5]
        //最大子序和
        int ans = nums[0];
        //前一个元素位置最大子序和
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}
