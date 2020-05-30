package maxSubArray53;

/**
 * 解题思路：动态规划
 * 时间复杂度；O（n)
 * 空间复杂度；O（1)
 */
public class Solution2 {
    public int maxSubArray(int[] nums) {
        //[-2,1,-3,4,-1,2,1,-5,4]
        //[-2,1,-2,4, 3,5,6, 1,5]
        //最大子序和
        int maxSum = nums[0];
        //前一个元素最大子序和
        int currentSum = maxSum;
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(currentSum + nums[i],nums[i]);
            maxSum = Math.max(currentSum,maxSum);
        }
        return maxSum;
    }
}
