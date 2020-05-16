import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnOrderPosition {

    @Test
    public void testUnOrderPosition() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int position = unOrderPosition(nums);
        Assertions.assertEquals(4, position);
    }

    public int unOrderPosition(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (left == right || (right - left == 1 && nums[left] >= nums[right])) {
                return right;
            }
            int mid = left + (right - left) / 2;
            //左半部分是有序数组
            if (nums[0] <= nums[mid]) {
                left = mid;
            } else {//右半部分是有序数组
                right = mid;
            }
        }
        return -1;
    }
}
