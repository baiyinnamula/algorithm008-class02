package mergeTwoArray88;

/**
 * @author yangbaiyinnamula
 * 时间复杂度：O(m + n)
 * 空间复杂度：O(m)
 * 设计思路：双指针，从前往后
 */

public class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];

        int p1 = 0;
        int p2 = 0;
        int p = 0;

        for (int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }

        while (p1 < m && p2 < n) {
            nums1[p++] = nums1Copy[p1] <= nums2[p2] ? nums1Copy[p1++] : nums2[p2++];
        }
        if (p1 < m) {
            System.arraycopy(nums1Copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }
}