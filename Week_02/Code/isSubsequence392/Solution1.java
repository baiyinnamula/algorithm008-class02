package isSubsequence392;

/**
 * 使用双指针
 * i 指针指向查询字符串当前查询位置
 * j 指针指向被查询字符串当前查询位置
 *
 */
public class Solution1 {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int m = s.length(), n = t.length();
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }

}
