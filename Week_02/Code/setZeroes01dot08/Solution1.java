package setZeroes01dot08;

public class Solution1 {
    public void setZeroes(int[][] matrix) {
        //用来记录应该清零的行编号
        boolean[] zeroRows = new boolean[matrix.length];
        //用来记录应该清零的列编号
        boolean[] zeroColumns = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                //如果某个元素是0 ，它所在的行和列都清零
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroColumns[j] = true;
                }
            }
        }
        //清零行
        for (int i = 0; i < matrix.length; i++) {
            if (zeroRows[i]) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //清零列
        for (int j = 0; j < matrix[0].length; j++) {
            if (zeroColumns[j]) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
