package removeOuterParentheses1021;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String str = new Solution().removeOuterParentheses("(()())(())(()(()))");
//        System.out.println(str);
    }

    public String removeOuterParentheses(String S) {
        int start = 0;
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                //如果字符是'('同时栈是空的表示新的原语开始
                if (stack.isEmpty()) {
                    start = i;
                }
                stack.push(c);
            }
            if (c == ')') {
                stack.pop();
                //如果字符是'）'同时栈是空的表示新的原语结束
                if (stack.isEmpty()) {
                    //把原语最外层的"("和")"以外的部分添加到新的字符串
                    ans.append(S.substring(start + 1, i));
                }
            }
        }

        return ans.toString();
    }
}
