package isSubsequence392;

/**
 * 解题思路：在t 依次中查找s 的每一个字母，如果前一个字母已经找到，从找到位置的下一个位置开始找下一个字母，以此类推
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 */
public class Solution2 {
    public boolean isSubsequence(String s, String t) {
        char[] arr = s.toCharArray();
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            j = t.indexOf(arr[i], j + 1);
            if (j == -1) {
                return false;
            }
        }

        return true;
    }
}
