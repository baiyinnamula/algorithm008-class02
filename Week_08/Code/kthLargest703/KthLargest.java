package kthLargest703;

import java.util.PriorityQueue;

public class KthLargest {
    private int k;
    private PriorityQueue queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.add(val);
        } else if ((int)queue.peek() < val) {
            queue.poll();
            queue.add(val);
        }
        return (int) queue.peek();
    }
}
