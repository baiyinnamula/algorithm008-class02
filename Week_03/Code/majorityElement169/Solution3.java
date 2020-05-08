package majorityElement169;

/**
 * Boyer-Moore 投票算法
 *
 * 时间复杂度：O(N)
 * 空间复杂度：O(1)
 */
public class Solution3 {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
