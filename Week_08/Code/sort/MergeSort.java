package sort;

import java.util.Arrays;

/**
 * 算法描述
 * 1.把长度为n的输入序列分成两个长度为n/2的子序列；
 * 2.对这两个子序列分别采用归并排序；
 * 3.将两个排序好的子序列合并成一个最终的排序序列。
 */
public class MergeSort {
    public int[] sort(int[] nums) {
        int length = nums.length;
        if (length >= 2) {
            //将原先数组从中间分割为两个数组，并且分别排序
            int middle = length / 2;
            int[] left = sort(Arrays.copyOfRange(nums, 0, middle));
            int[] right = sort(Arrays.copyOfRange(nums, middle, length));
            //把排序好的两个子数组合并为一个数组
            return merge(left, right);
        } else {
            return Arrays.copyOf(nums, length);
        }
    }

    private int[] merge(int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int[] ans = new int[leftLength + rightLength];
        int i = 0;
        int j = 0;
        int k = 0;
        //合并和排序两个数组元素
        while (i < leftLength && j < rightLength) {
            if (left[i] < right[j]) {
                ans[k++] = left[i++];
            } else {
                ans[k++] = right[j++];
            }
        }
        //合并左子数组剩余部分
        while (i < leftLength) {
            ans[k++] = left[i++];
        }
        //合并右子数组剩余部分
        while (j < rightLength) {
            ans[k++] = right[j++];
        }
        return ans;
    }
}
