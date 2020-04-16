package week01.rotateArray;

/**
 * @author yangbaiyinnamula
 * 最笨的办法：循环2层，第一层循环k次，第二层：每次循环移动 n-1个元素
 * 时间复杂度:O(k*n)
 * 空间复杂度：O(1)
 */
public class Solution1 {
    public void rotate(int[] nums, int k) {
        for(int i = 0;i<k;i++){
            int last = nums[nums.length-1];
            for(int j=nums.length -2;j >= 0;j--){
                nums[j+1] = nums[j];
            }
            nums[0] = last;
        }
    }
}
