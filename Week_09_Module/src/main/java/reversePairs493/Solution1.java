package reversePairs493;

public class Solution1 {
    public int reversePairs(int[] nums) {
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] - nums[i] > nums[i] ) {
                    count++;
                }
            }
        }
        return count;
    }
}
