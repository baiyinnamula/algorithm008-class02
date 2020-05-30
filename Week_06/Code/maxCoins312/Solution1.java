package maxCoins312;

public class Solution1 {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] new_nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            new_nums[i + 1] = nums[i];
        }
        new_nums[0] = new_nums[n - 1] = 1;

        int[][] memo = new int[n][n];
        return dp(memo, new_nums, 0, n - 1);
    }

    private int dp(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) {
            return 0;
        }

        if (memo[left][right] > 0) {
            return memo[left][right];
        }
        int ans = 0;
        for (int i = left + 1; i < right; i++) {
            ans = Math.max(ans, nums[left] * nums[i] * nums[right]
                    + dp(memo, nums, left, i)
                    + dp(memo, nums, i, right));
        }
        memo[left][right] = ans;
        return ans;
    }
}
