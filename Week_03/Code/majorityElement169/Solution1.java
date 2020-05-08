package majorityElement169;

import java.util.HashMap;
import java.util.Map;

/**
 * 时间复杂度:O(N)
 * 空间复杂度:O(N)
 */
public class Solution1 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0));
        }

        Map.Entry<Integer, Integer> majority = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (majority == null || majority.getValue() < entry.getValue()) {
                majority = entry;
            }
        }
        return majority.getKey();
    }
}
