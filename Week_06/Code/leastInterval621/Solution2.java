package leastInterval621;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 解题思路：优先队列
 *
 */
public class Solution2 {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int f : map) {
            if (f > 0) {
                queue.add(f);
            }
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    //如果当前任务数量大于1，需要把剩余部分加入到列表中
                    if (queue.peek() > 1) {
                        temp.add(queue.poll() - 1);
                    } else {
                        queue.poll();
                    }
                }
                time++;
                i++;
                if (queue.isEmpty() && temp.size() == 0) {
                    break;
                }
            }
            //把剩余任务列表加入到队列里
            queue.addAll(temp);
        }
        return time;
    }
}
