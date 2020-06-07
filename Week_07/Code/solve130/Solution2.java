package solve130;

public class Solution2 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //判断是否边缘上的'O'
                boolean edge = i == 0 || j == 0 || i == rows - 1 || j == cols - 1;
                if (board[i][j] == 'O' && edge) {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        //判断是否越界
        boolean overflow = i < 0 || j < 0 || i >= board.length || j >= board[0].length;
        if (overflow || board[i][j] == '#' || board[i][j] == 'X') {
            return;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
