package reverseWords557;

/**
 * 解题思路：双指针
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution1 {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            char[] cs = arr[i].toCharArray();
            for (int j = 0; j < cs.length / 2; j++) {
                char c = cs[j];
                cs[j] = cs[cs.length - j - 1];
                cs[cs.length - j - 1] = c;
            }
            arr[i] = new String(cs);
        }
        return String.join(" ", arr);
    }
}
