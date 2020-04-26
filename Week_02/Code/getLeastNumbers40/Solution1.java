package getLeastNumbers40;

import java.util.Arrays;

/**
 * 面试题40. 最小的k个数
 * 解题思路：先排序原先数组，然后获取前k 个最小元素组成的数组
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 *
 */
public class Solution1 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }
}
