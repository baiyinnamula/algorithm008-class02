package toLowerCase709;

/**
 * 解题思路：ascii 码表，大小写字母间转换
 * 时间复杂度：O(N),N 为字符串长度
 * 空间复杂度：O(N),N 为字符串长度
 */
public class Solution1 {
    public String toLowerCase(String str) {
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= 65 && cs[i]  <= 90) {
                cs[i] = (char)(cs[i] + 32);
            }
        }
        return new String(cs);
    }
}
