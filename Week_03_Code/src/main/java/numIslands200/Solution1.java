package numIslands200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {

    //广度优先搜索
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        //如果超出边界，或者是水，或者被访问过，则直接跳过
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0'|| grid[r][c] == '2') {
            return;
        }
        //当前位置标记为已读
        grid[r][c] = '2';
        //广度优先搜索访问前后左右4个位置
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

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
                    dfs(grid, r, c);
                }
            }
        }

        return islandsNum;
    }
}
