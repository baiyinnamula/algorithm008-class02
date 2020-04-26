package sortColors75;

public class Solution3 {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        int temp;
        for (int i = 0; i <= p2; i++) {
            if (nums[i] == 0) {
                temp = nums[i];
                nums[i] = nums[p0];
                nums[p0++] = temp;
            } else if (nums[i] == 2) {
                temp = nums[i];
                nums[i--] = nums[p2];
                nums[p2--] = temp;
            }
        }
    }
}
