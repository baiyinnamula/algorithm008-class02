package threeSum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 方法：先排序，再使用双指针
 *
 * @author yangbaiyinnamula
 *
 */
public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        //如果数组元素数量不到三个，则不符合题目要求
        if (nums == null || nums.length < 3) {
            return ans;
        }
        int lenght = nums.length;
        //先排序数组
        Arrays.sort(nums);

        for (int i = 0; i < lenght; i++) {
            //如果 nums[i] 大于0 则三数之和肯定大于 0
            if (nums[i] > 0) {
                break;
            }
            // 如果相邻的两个元素相等，则跳过后一个元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = lenght - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                //已经找到和等于0的i对应的另外两个数字
                if (sum == 0) {
                    //把找到的3个数添加到链表里
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 如果左边指针有相同元素，则向右移动
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 如果右边指针有相同元素，则向左移动
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    //继续寻找i 对应的另外两个数字
                    left++;
                    right--;
                }
                //说明左边数字小了，继续找更大的数字
                if (sum < 0) {
                    left++;
                }
                //说明右边数字大了，继续寻找更小的数字
                if (sum > 0){
                    right--;
                }
            }
        }
        return ans;
    }
}
