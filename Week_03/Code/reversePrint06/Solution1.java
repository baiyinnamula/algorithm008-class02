package reversePrint06;

import java.util.Stack;

/**
 * @author yangbaiyinnamula
 * 面试题06. 从尾到头打印链表
 */
public class Solution1 {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int[] ans = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop().val;
        }

        return ans;
    }
}
