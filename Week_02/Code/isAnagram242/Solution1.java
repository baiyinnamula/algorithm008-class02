package isAnagram242;

import java.util.Arrays;

/**
 * 解题思路：使用数组排序，然后逐一比较两个数字元素
 * 时间复杂度：O（nlogn） ，排序成本O(nlogn),比较成本O(n)
 * 空间复杂度：O(n)
 *
 *
 */
public class Solution1 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray,tArray);
    }
}
