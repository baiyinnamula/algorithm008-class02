package relativeSortArray1122;

/**
 * 解题思路：计数排序+ 数组
 */
public class Solution1 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        //记录每个元素出现次数
        for (int n : arr1) {
            bucket[n]++;
        }
        int count = 0;
        //排序arr2 里的元素部分
        for (int i : arr2) {
            while (bucket[i]-- > 0) {
                arr1[count++] = i;
            }
        }
        //排序剩余元素部分
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                arr1[count++] = i;
            }
        }

        return arr1;
    }
}
