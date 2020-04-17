package detectCycle142;

import java.util.HashSet;
import java.util.Set;

import reverseList206.ListNode;

/**
 * 思路：使用哈希表
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visitedSet = new HashSet<>();
        while (head != null) {
            if (visitedSet.contains(head)) {
                return head;
            } else {
                visitedSet.add(head);
                head = head.next;
            }
        }

        return null;
    }
}
