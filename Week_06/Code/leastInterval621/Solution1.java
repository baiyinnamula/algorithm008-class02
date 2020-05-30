package leastInterval621;

import java.util.*;

/**
 * 解题思路：排序
 * 时间复杂度：
 */
public class Solution1 {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        //对调度任务数量进行排序（数量递增）
        Arrays.sort(map);
        int time = 0;
        //只要还剩下任务，继续调用任务
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) {
                //如果已经没有了可执行的任务则退出当前循环
                if (map[25] == 0) {
                    break;
                }
                //执行第25-i 个任务
                if (i < 26 && map[25 - i] > 0) {
                    map[25 - i]--;
                }
                //执行单位加1
                time++;
                //当前循环量执行数量加1
                i++;
            }
            //重新排序待执行任务
            Arrays.sort(map);
        }
        return time;
    }

}
