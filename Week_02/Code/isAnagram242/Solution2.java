package isAnagram242;

/**
 * 使用哈希和计数器
 * 时间复杂度：O(n),n 是字符串长度
 * 空间复杂度：O(1),无论比较的字符串多大，哈希表大小是不变
 */
public class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
