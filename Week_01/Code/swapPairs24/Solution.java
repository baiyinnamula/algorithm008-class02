package swapPairs24;

import reverseList206.ListNode;

/**
 * @author yangbaiyinnamula
 * 使用递归
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }
}
