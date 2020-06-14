package getLeastNumbers40;

import java.util.PriorityQueue;

/**
 * 解题思路：堆
 * 时间复杂度：O(n logk)
 * 空间复杂度：O(n)
 */
public class Solution1 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n : arr) {
            queue.add(n);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}
