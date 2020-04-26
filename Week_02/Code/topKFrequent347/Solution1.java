package topKFrequent347;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author yangbaiyinnamula
 * 解题思路：使用最小堆
 * 时间复杂度：O(Nlog(K))
 * 空间复杂度：O(N)
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] q = new int[]{1, 1, 1, 2, 2, 3, 4};
        System.out.println(Arrays.toString(new Solution1().topKFrequent(q, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int num : nums) {
            maps.put(num, maps.getOrDefault(num, 0) + 1);
        }

        System.out.println(maps);

        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> maps.get(n1) - maps.get(n2));
        for (int key : maps.keySet()) {
            heap.add(key);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] ans = new int[k];
        int i = k - 1;
        while (!heap.isEmpty()) {
            ans[i--] = heap.poll();

        }
        return ans;
    }
}
