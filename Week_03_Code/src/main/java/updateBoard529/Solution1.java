package updateBoard529;

// 'M' 代表一个未挖出的地雷
// 'E' 代表一个未挖出的空方块
// 'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块
// 数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻
// 'X' 表示一个已挖出的地雷

public class Solution1 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;
        int row = click[0];
        int col = click[1];
        //如果当前这个点是'M',表示为已挖出地雷('X'）,游戏结束。
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            //这段代码主要寻找当前块周围地雷数量
            // 记录周围地雷数量
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int r = row + i;
                    int c = col + j;
                    //如果越界，则跳过
                    if (r < 0 || r >= m || c < 0 || c >= n) {
                        continue;
                    }
                    //如果周围有地雷，则累计地雷数量
                    if (board[r][c] == 'M' || board[r][c] == 'X') {
                        count++;
                    }
                }
            }
            //周围有地雷的块
            if (count > 0) {
                board[row][col] = (char) (count + '0');
            } else {
                // 周围没有地雷的空白块
                board[row][col] = 'B';
                //这段代码主要用来继续挖空白块周围的块
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        //当前节点，或越界则直接跳过
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int r = row + i;
                        int c = col + j;
                        if (r < 0 || r >= m || c < 0 || c >= n) {
                            continue;
                        }
                        //如果是未挖出空块，则继续挖周边
                        if (board[r][c] == 'E') {
                            updateBoard(board, new int[]{r, c});
                        }
                    }
                }
            }
        }
        return board;
    }
}
