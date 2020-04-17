package mergeTwoArray88;

/**
 * @author yangbaiyinnamula
 * 时间复杂度：O(m + n)
 * 空间复杂度：O(1)
 * 设计思路：双指针，从后往前
 * 由于两个数组都是有效数组，所以需要从后往前遍历两个数组，当前哪个数据元素较大，就把哪个元素插入到指定位置
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * p = 5
 * p1 = 2
 * p2 = 2
 * 第一轮之后
 * nums1 = [1,2,3,0,0,6]
 * p = 4
 * p1 = 2
 * p2 = 1
 * 第二轮之后
 * nums1 = [1,2,3,0,5,6]
 * p = 3
 * p1 = 2
 * p2 = 0
 * 第三轮之后
 * nums1 = [1,2,3,3,5,6]
 * p = 2
 * p1 = 1
 * p2 = 0
 * 第四轮之后
 * nums1 = [1,2,2,3,5,6]
 * p = 1
 * p1 = 1
 *
 */
public class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0)) {
            nums1[p--] = (nums1[p1] <= nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        if (p2 + 1 > 0) {
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }
}