package numIslands200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int islandsNum = 0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                //如果是1表示是一个岛屿，同时把这个岛屿前后左右陆地标记为已访问过
                if (grid[r][c] == '1') {
                    ++islandsNum;
                    grid[r][c] = '2';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(r * nc + c);
                    while (!queue.isEmpty()) {
                        int index = queue.remove();
                        int row = index / nc;
                        int col = index % nc;

                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            grid[row - 1][col] = '2';
                            queue.add((row - 1) * nc + col);
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            grid[row + 1][col] = '2';
                            queue.add((row + 1) * nc + col);
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            grid[row][col - 1] = '2';
                            queue.add(row * nc + col - 1);
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            grid[row][col + 1] = '2';
                            queue.add(row * nc + col + 1);
                        }
                    }
                }
            }
        }

        return islandsNum;
    }
}
