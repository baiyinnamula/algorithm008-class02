package week01.mergeTwoLists;

import week01.ListNode;

/**
 * @author yangbaiyinnamula
 * @date 2020-04-15
 * 使用迭代
 * 时间复杂度：O(n+m)s
 * 空间复杂度：O(1)
 */
class Solution1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}