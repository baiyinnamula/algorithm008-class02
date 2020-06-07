package findCircleNum547;

/**
 * 给定的矩阵可以看成图的邻接矩阵。这样我们的问题可以变成无向图连通块的个数。
 * 解题思路：深度优先搜索
 * 时间复杂度：O(n^2)，整个矩阵都要被遍历，大小为 n^2。
 * 空间复杂度：O(n) ,visited 数组的大小。
 */
public class Solution1 {
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}
