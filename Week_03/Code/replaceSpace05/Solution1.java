package replaceSpace05;

/**
 * 面试题05. 替换空格
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution1 {
    public String replaceSpace(String s) {
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                ans.append("%20");
            } else {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}
