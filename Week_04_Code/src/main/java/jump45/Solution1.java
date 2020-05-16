package jump45;

public class Solution1 {
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int step = 0;
        for (int i = 0; i < nums.length-1; i++) {
            maxPosition = Math.max(maxPosition,nums[i] + i);
            if (i == end){
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
