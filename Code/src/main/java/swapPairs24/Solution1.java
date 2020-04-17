package swapPairs24;

import reverseList206.ListNode;

/**
 * @author yangbaiyinnamula
 * 使用迭代
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution1 {
    public ListNode swapPairs(ListNode head) {

        //始终指向当前链表的头元素（其实是头元素的前一个元素）
        ListNode dummy = new ListNode(-1);

        //始终指向当前轮询里的前一个元素
        ListNode prevNode = dummy;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            //交换元素位置
            //前一个元素的next 指向第二个元素
            prevNode.next = second;
            //第一个元素的 next 指向第三个元素
            first.next = second.next;
            //原先第二个元素的next 指向第一个元素
            second.next = first;

            // 前一个元素指向交换后的第二个元素
            prevNode = first;
            // head 指向下一轮交换的第一个元素（这一轮的第三个元素）
            head = prevNode.next;
        }

        //返回链表首元素
        return dummy.next;
    }
}
