package hasCycle141;

import reverseList206.ListNode;

/**
 * @author yangbaiyinnamula
 * 2020-04-17
 * 通过使用具有 不同速度 的快、慢两个指针遍历链表，空间复杂度可以被降低至 O(1)O(1)。
 * 慢指针每次移动一步，而快指针每次移动两步。
 * 方法二：使用双指针
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution2 {
    public boolean hasCycle(ListNode head) {
        //如果当前链表是空的或之后一个节点，那肯定不是环形链表
        if (head == null || head.next == null) {
            return false;
        }
        //快指针
        ListNode fast = head.next;
        //满指针
        ListNode slow = head;

        while (fast != slow) {
            //如果快指针已经到了链表尾部，并且尾部元素后面是 null 那肯定不是环形链表
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return true;
    }
}
