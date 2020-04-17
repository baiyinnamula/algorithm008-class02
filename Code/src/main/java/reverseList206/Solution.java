package reverseList206;

/**
 * @author yangbaiyinnamula
 * 解法1：使用迭代
 * 206. 反转链表
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        //新链表头节点
        ListNode newListHead = null;
        //当前节点
        ListNode current = head;
        while (current != null){
            //临时变量指向当前节点的下一个节点
            ListNode temp = current.next;
            //当前节点的下一个节点改为 prev 节点
            current.next = newListHead;
            //新链表头节点向前移动一位
            newListHead = current;
            //current 节点指向 temp 节点，也就是就链表的剩余部分的头结点
            current = temp;
        }

        return newListHead;
    }
}

