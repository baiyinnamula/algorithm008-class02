package generateParenthesis22;

import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路：回溯法
 */
public class Solution2 {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new StringBuilder(), 0, 0, n, combinations);
        return combinations;
    }

    private void generateAll(StringBuilder currrent, int open, int close, int max, List<String> ans) {
        //terminator
        if (max * 2 == currrent.length()) {
            ans.add(currrent.toString());
        } else {
            if (open < max) {
                //process current logic
                currrent.append('(');
                //drill down
                generateAll(currrent, open + 1, close, max, ans);
                //restore currrent status
                currrent.deleteCharAt(currrent.length() - 1);
            }
            if (open > close) {
                //process current logic
                currrent.append(')');
                //drill down
                generateAll(currrent, open, close + 1, max, ans);
                //restore currrent status
                currrent.deleteCharAt(currrent.length() - 1);
            }
        }
    }
}
