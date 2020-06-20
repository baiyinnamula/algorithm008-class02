package isMatch44;

/**
 * 解题思路：动态规划
 * 时间复杂度：O(s*p),s,p 分别是字符串长度和匹配串长度
 * 空间复杂度：O(s*p),s,p 分别是字符串长度和匹配串长度
 */
public class Solution1 {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        if (p.equals(s) || "*".equals(p)) {
            return true;
        }
        if (p.isEmpty() || s.isEmpty()) {
            return false;
        }

        boolean[][] dp = new boolean[pLen + 1][sLen + 1];
        dp[0][0] = true;
        for (int pIdx = 1; pIdx <= pLen; pIdx++) {
            if (p.charAt(pIdx - 1) == '*') {
                int sIdx = 1;
                while ((!dp[pIdx - 1][sIdx - 1]) && (sIdx <= sLen)) {
                    sIdx++;
                }
                dp[pIdx][sIdx - 1] = dp[pIdx - 1][sIdx - 1];
                while (sIdx <= sLen) {
                    dp[pIdx][sIdx++] = true;
                }
            } else if (p.charAt(pIdx - 1) == '?') {
                for (int sIdx = 1; sIdx <= sLen; sIdx++) {
                    dp[pIdx][sIdx] = dp[pIdx - 1][sIdx - 1];
                }
            } else {
                for (int sIdx = 1; sIdx <= sLen; sIdx++) {
                    dp[pIdx][sIdx] = dp[pIdx - 1][sIdx - 1] &&
                            (p.charAt(pIdx - 1) == s.charAt(sIdx - 1));
                }
            }
        }
        return dp[pLen][sLen];
    }
}
