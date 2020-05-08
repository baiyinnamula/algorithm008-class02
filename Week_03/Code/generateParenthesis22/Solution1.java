package generateParenthesis22;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[n * 2], 0, combinations);
        return combinations;
    }

    private void generateAll(char[] currrent, int pos, List<String> combinations) {
        if (pos == currrent.length) {
            if (valid(currrent)) {
                combinations.add(new String(currrent));
            } else {
                currrent[pos] = '(';
                generateAll(currrent, pos + 1, combinations);
                currrent[pos] = ')';
                generateAll(currrent, pos + 1, combinations);
            }
        }
    }

    private boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }
}
