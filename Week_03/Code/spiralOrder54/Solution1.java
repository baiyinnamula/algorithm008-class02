package spiralOrder54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangbaiyinnamula
 * 时间复杂度：O(N),其中 N 是输入矩阵所有元素的个数。
 * 空间复杂度：O(N) 需要两个矩阵 visited 和 ans 存储所需信息。
 */
public class Solution1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList();
        if (matrix.length == 0) {
            return ans;
        }

        int rowNum = matrix.length;
        int columnNum = matrix[0].length;

        //记录访问过的位置
        boolean[][] visited = new boolean[rowNum][columnNum];
        //行变动趋势
        //行不变，列增加 -> 行增加，列不变 -> 行不变，列减小->行减小，列不变
        int[] rowDirection = {0, 1, 0, -1};
        //列变动趋势
        int[] columnDirection = {1, 0, -1, 0};

        int r = 0;
        int c = 0;
        //当前行和列变动趋势
        int di = 0;
        for (int i = 0; i < rowNum * columnNum; i++) {
            ans.add(matrix[r][c]);
            visited[r][c] = true;
            //下一个访问位置（行和列）
            int nextRow = r + rowDirection[di];
            int nextColumn = c + columnDirection[di];
            //下一个位置的有效并且没有访问过
            boolean volidAndVisited = (0 <= nextRow && nextRow < rowNum) && (0 <= nextColumn && nextColumn < columnNum);
            volidAndVisited = volidAndVisited && !visited[nextRow][nextColumn];
            if (volidAndVisited) {
                r = nextRow;
                c = nextColumn;
            } else {
                di = (di + 1) % 4;
                r += rowDirection[di];
                c += columnDirection[di];
            }
        }

        return ans;
    }
}
