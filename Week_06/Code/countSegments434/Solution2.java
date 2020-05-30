package countSegments434;

/**
 * 解题思路：统计单词首字母数量
 * 时间复杂度：O(n) n 是字符串长度
 * 空间复杂度：O(1)
 */
public class Solution2 {
    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }
}
