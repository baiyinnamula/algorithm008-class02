package merge56;

import java.util.*;

public class Solution1 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 0) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> ansList = new ArrayList<>();
        int[] item = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (item[1] >= intervals[i][0]) {
                item[1] = Math.max(item[1], intervals[i][1]);
            } else {
                ansList.add(item);
                item = intervals[i];
            }
        }
        ansList.add(item);

        int[][] ans = new int[ansList.size()][2];
        ansList.toArray(ans);
        return ans;
    }
}
