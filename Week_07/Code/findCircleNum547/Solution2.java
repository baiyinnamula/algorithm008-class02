package findCircleNum547;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 给定的矩阵可以看成图的邻接矩阵。这样我们的问题可以变成无向图连通块的个数。
 * 解题思路：广度优先搜索
 * 时间复杂度：O(n^2)，整个矩阵都要被遍历，大小为 n^2。
 * 空间复杂度：O(n) ,queue,visited 数组的大小。
 */
public class Solution2 {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}
