package reverseList206;

/**
 * @author yangbaiyinnamula
 *
 * 206. 反转链表
 * 解法1：使用递归
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */

class Solution1 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return  head;
        }
        // p 是已经反转后的链表头元素
        ListNode p = reverseList(head.next);
        // 第 k+1 元素的next 指向第 k 元素
        head.next.next = head;
        // 取消 第 k 元素的next 指向第 k+1 元素，否则变成一个环
        head.next = null;

        return p;
    }
}

