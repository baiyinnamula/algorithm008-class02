package twoSum1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangbaiyinnamula
 * @date 2020-04-14
 * 两数之和
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {

        //1. 暴力破解
//        for (int i = 0; i < nums.length -1; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target){
//                    return new int[]{i,j};
//                }
//            }
//        }

        /**
         * 标签：哈希映射
         * 这道题本身如果通过暴力遍历的话也是很容易解决的，时间复杂度在 O(n2)
         * 由于哈希查找的时间复杂度为 O(1)，所以可以利用哈希容器 map 降低时间复杂度
         * 遍历数组 nums，i 为当前下标，每个值都判断map中是否存在 target-nums[i] 的 key 值
         * 如果存在则找到了两个值，如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止
         * 如果最终都没有结果则抛出异常
         * 时间复杂度：O(n)
         *
         * 作者：guanpengchn
         * 链接：https://leetcode-cn.com/problems/two-sum/solution/jie-suan-fa-1-liang-shu-zhi-he-by-guanpengchn/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
        //2. 哈希映射
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("invalid input");
    }
}
