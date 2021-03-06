package moveZeroes283;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 解题思路
 * 分2步处理
 * 第一步：把所有的非0值，都往前挪动
 * 第二步：把数组剩余部分都赋0值。
 * 优点：不用添加，删除或移动数组元素，执行效率较高
 * 缺点：有些反直觉
 */
public class Solution {

    @Test
    public void test1() {
        int[] nums = {0, 1, 0, 3, 12};
        int[] expected = {1, 3, 13, 0, 0};

        Solution solution = new Solution();
        solution.moveZeroes(nums);
    }

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }
}