package week01.mergeTwoLists;

import week01.ListNode;

/**
 * @author yangbaiyinnamula
 * @date 2020-04-15
 * 使用递归
 * 时间复杂度：O(n+m)
 * 空间复杂度：O(n+m)
 */

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}