package countSegments434;

/**
 * 解题思路：使用内置函数或方法
 * 时间复杂度：O(n) n 是字符串长度
 * 空间复杂度：O(n) n 是字符串长度
 */
public class Solution1 {
    public int countSegments(String s) {
        String trimmed = s.trim();
        if (trimmed.length() == 0) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }
}
