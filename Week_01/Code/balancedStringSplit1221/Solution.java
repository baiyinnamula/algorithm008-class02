package balancedStringSplit1221;

/**
 * @author yangbaiyinnamula
 * 时间复杂度：O(n):n 为字符串长度
 * 空间复杂度：O(1)
 */
public class Solution {
    public int balancedStringSplit(String s) {
        int balance = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            balance += s.charAt(i) == 'L' ? 1 : -1;
            if (balance == 0) {
                count++;
            }
        }

        return count;
    }
}
