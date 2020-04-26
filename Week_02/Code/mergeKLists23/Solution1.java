package mergeKLists23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node != null) {
                queue.add(node);
                node = node.next;
            }
        }
        ListNode ans = new ListNode(Integer.MIN_VALUE);
        ListNode current = ans;
        while (!queue.isEmpty()) {
            current.next = queue.poll();
            current = current.next;
        }

        return ans.next;
    }
}
