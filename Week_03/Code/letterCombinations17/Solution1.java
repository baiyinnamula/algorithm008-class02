package letterCombinations17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
    private static Map<String, String> map = new HashMap<>();
    private List<String> output = new ArrayList<String>();

    static {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
    }

    private void backtrack(String combination, String nextDigits) {
        if (nextDigits.length() == 0) {
            output.add(combination);
        } else {
            //获取第一个数字
            String digit = nextDigits.substring(0, 1);
            //获取第一个数字对应的字符串
            String letters = map.get(digit);
            //遍历字符串
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backtrack(combination + letter, nextDigits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }
}
