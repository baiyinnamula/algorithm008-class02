package sortColors75;

public class Solution1 {
    public void sortColors(int[] nums) {
        //红色数量
        int red = 0;
        //白色数量
        int white = 0;
        //蓝色数量
        int blue = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                red++;
            }
            if (nums[i] == 1) {
                white++;
            }
            if (nums[i] == 2) {
                blue++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < red) {
                nums[i] = 0;
            }
            if (i >= red && i < red + white) {
                nums[i] = 1;
            }
            if (i >= red + white) {
                nums[i] = 2;
            }
        }
    }
}
