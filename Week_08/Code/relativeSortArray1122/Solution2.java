package relativeSortArray1122;

import java.util.Map;
import java.util.TreeMap;

/**
 * 解题思路：计数排序+ map
 */
public class Solution2 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> bucket = new TreeMap<>();
        //记录每个元素出现次数
        for (int n : arr1) {
            bucket.put(n, bucket.getOrDefault(n, 0) + 1);
        }
        int count = 0;
        //排序arr2 里的元素部分
        for (int i : arr2) {
            for (int j = 0; j < bucket.get(i); j++) {
                arr1[count++] = i;
            }
            bucket.remove(i);
        }
        //排序剩余元素部分
        for (int i : bucket.keySet()) {
            for (int j = 0; j < bucket.get(i); j++) {
                arr1[count++] = i;
            }
        }
        return arr1;
    }
}
