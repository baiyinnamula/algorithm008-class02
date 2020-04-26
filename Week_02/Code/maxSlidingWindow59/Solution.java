package maxSlidingWindow59;

import java.util.Arrays;

/**
 * @author yangbaiyinnamula
 * 时间复杂度：O((n−k+1)k)≈O(nk)
 */
public class Solution {
    public static void main(String[] args) {
        int[] ans = new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ans));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        //如果 k == 0 则直接返回 []
        if (k == 0) {
            return new int[0];
        }
        //定义遍历结果数组的指针，从0开始
        int n = 0;
        //结果数组的大小
        int ansLength = nums.length + 1 - k;
        //定义结果数组
        int[] ans = new int[ansLength];
        //滑动数组遍历
        for (int i = 0; i <= nums.length - k; i++) {
            int max = Integer.MIN_VALUE;
            //每次遍历从 i 到 i+k-1 的 k 个元素
            for (int j = i; j < i + k; j++) {
                max = max > nums[j] ? max : nums[j];
            }
            ans[n++] = max;
        }

        return ans;
    }
}
