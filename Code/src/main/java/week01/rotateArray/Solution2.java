package week01.rotateArray;

/**
 * @author yangbaiyinnamula
 * 使用额外数组:使用数据项下标取模方式把数据复制到另一个数组，然后重新复制到原来数组
 * 时间复杂度:O(n)
 * 空间复杂度：O(n)
 */
public class Solution2 {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            temp[(i + k) % length] = nums[i];
        }
        for (int i = 0; i < length; i++) {
            nums[i] = temp[i];
        }
    }
}
