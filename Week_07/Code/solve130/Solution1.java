package solve130;

import template.UF2;

/**
 * 解题思路：并查集
 * 时间复杂度O(n * m)
 */
public class Solution1 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;

        UF2 uf = new UF2(rows * cols + 1);
        // 用一个虚拟节点, 边界上的O 的父节点都是这个虚拟节点
        int dummyNode = rows * cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    // 边界上的O,把它和dummyNode 合并成一个连通区域.
                    if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                        uf.union(i * cols + j, dummyNode);
                    } else {
                        //和上下左右合并成一个连通区域.
                        if (i > 0 && board[i - 1][j] == 'O') {
                            uf.union((i - 1) * cols + j, i * cols + j);
                        }
                        if (i < rows - 1 && board[i + 1][j] == 'O') {
                            uf.union((i + 1) * cols + j, i * cols + j);
                        }
                        if (j > 0 && board[i][j - 1] == 'O') {
                            uf.union(i * cols + j - 1, i * cols + j);
                        }
                        if (j < cols - 1 && board[i][j + 1] == 'O') {
                            uf.union(i * cols + j + 1, i * cols + j);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 和dummyNode 在一个连通区域的,那么就是O；
                if (!uf.connected(i * cols + j, dummyNode)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
