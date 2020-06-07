package solve130;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    static class Pos {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

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
                    bfs(board, i, j);
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

    public void bfs(char[][] board, int i, int j) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(i, j));
        while (!queue.isEmpty()) {
            Pos curr = queue.poll();
            if (curr.i - 1 >= 0 && board[i - 1][j] == 'O') {
                queue.add(new Pos(curr.i - 1, j));
                board[curr.i - 1][j] = '#';
            }
            if (curr.i + 1 < board.length && board[i + 1][j] == 'O') {
                queue.add(new Pos(curr.i + 1, j));
                board[curr.i + 1][j] = '#';
            }
            if (curr.j - 1 >= 0 && board[i][j - 1] == 'O') {
                queue.add(new Pos(curr.i, j - 1));
                board[curr.i][j - 1] = '#';
            }
            if (curr.j + 1 < board[0].length && board[i][j + 1] == 'O') {
                queue.add(new Pos(curr.i, j + 1));
                board[curr.i][j + 1] = '#';
            }
        }
    }
}
