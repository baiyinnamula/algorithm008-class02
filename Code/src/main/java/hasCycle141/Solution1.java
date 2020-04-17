package hasCycle141;

import reverseList206.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author yangbaiyinnamula
 * 我们可以通过检查一个结点此前是否被访问过来判断链表是否为环形链表。常用的方法是使用哈希表。xx
 * 方法一：使用哈希表
 * 时间复杂度：O(n),n 为链表长度
 * 空间复杂度：O(n),使用一个哈希表保存访问过的节点
 */
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visitedNodes = new HashSet<>();
        while (head !=  null){
            if (visitedNodes.contains(head)){
                return true;
            }
            visitedNodes.add(head);
            head = head.next;
        }
        return false;
    }
}
