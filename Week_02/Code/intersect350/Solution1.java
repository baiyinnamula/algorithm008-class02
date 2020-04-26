package intersect350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        int[] origin = new int[Math.max(nums2.length, nums1.length)];
        int k = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (map.getOrDefault(nums2[i], 0) > 0) {
                origin[k++] = nums2[i];
                map.put(nums2[i], map.getOrDefault(nums2[i], 0) - 1);
            }
        }

        return Arrays.copyOf(origin, k);
    }
}
