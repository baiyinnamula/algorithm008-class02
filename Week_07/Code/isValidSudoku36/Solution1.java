package isValidSudoku36;

/**
 * 解题思路：巧妙处理九宫格内数据冲突
 * 时间复杂度：O(n)，n 是数组元素个数
 * 空间复杂度：O(n)，n 是数组元素个数
 */
public class Solution1 {
    private static final Integer L = 9;

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[L][L];
        boolean[][] columns = new boolean[L][L];
        boolean[][] boxes = new boolean[L][L];

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = c - '1';
                    int k = (i / 3) * 3 + j / 3;
                    if (rows[i][num] || columns[j][num] ||boxes[k][num]) {
                        return false;
                    }
                    rows[i][num] = true;
                    columns[j][num] = true;
                    boxes[k][num] = true;
                }
            }
        }
        return true;
    }
}
