package islandPerimeter463;

public class Solution1 {
    public int islandPerimeter(int[][] grid) {
        int rl = grid.length;
        int cl = grid[0].length;

        for (int r = 0; r < rl; r++) {
            for (int c = 0; c < cl; c++) {
                if (grid[r][c] == '1') {
                    return dfs(grid, r, c);
                }
            }
        }

        return 0;
    }

    private int dfs(int[][] grid, int r, int c) {
        // 函数因为「坐标 (r, c) 超出网格范围」返回，对应一条黄色的边
        if (!inArea(grid, r, c)) {
            return 1;
        }
        // 函数因为「当前格子是海洋格子」返回，对应一条蓝色的边
        if (grid[r][c] == 0) {
            return 1;
        }

        // 函数因为「当前格子是已遍历的陆地格子」返回，和周长没关系
        if (grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = 2;
        return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);

    }

    // 判断坐标 (r, c) 是否在网格中
    private boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
