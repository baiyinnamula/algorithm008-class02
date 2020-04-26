package isAnagram242;

/**
 * 使用哈希和计数器
 * 时间复杂度：O(n),n 是字符串长度
 * 空间复杂度：O(1),无论比较的字符串多大，哈希表大小是不变
 * 先遍历s,再遍历t ,如果任何时刻出现值是负数的元素，表面 s和t不是字母异位词
 */
public class Solution3 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (--counter[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
