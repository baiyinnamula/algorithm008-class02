package findCircleNum547;

import java.util.Arrays;

/**
 * 解题思路：并查集
 * 时间复杂度：O(n^3)
 * 空间复杂度O(n)
 */
public class Solution3 {
    public int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }

    public void union(int[] parent, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);
        if (xRoot != yRoot) {
            parent[xRoot] = yRoot;
        }
    }

    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                count++;
            }
        }
        return count;
    }
}
