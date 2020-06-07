package intersect350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解题思路：使用哈希表
 * 时间复杂度：O(n + m),n,m 分别是两个数组的长度
 * 空间复杂度O（min(n,m)）
 */
public class Solution1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                map.put(i, map.get(i) - 1);
                list.add(i);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 2, 1};
        int[] num2 = new int[]{2, 2};
        new Solution1().intersect(num1, num2);
    }
}
