package uniquePathsWithObstacles63;

public class Solution1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        if (n < 1) {
            return -1;
        }
        int m = obstacleGrid[0].length;
        if (m < 1) {
            return -1;
        }

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 0) {
                obstacleGrid[i][0] = 1;
            } else {
                while (i < n) {
                    dp[i][0] = 0;
                    i++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                while (i < m) {
                    dp[0][i] = 0;
                    i++;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[n - 1][m - 1];
    }
}
