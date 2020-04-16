package week01.transpose;

/**
 * @author yangbaiyinnamula
 * 867. 转置矩阵
 * 时间复杂度 O(n * m)
 * 空间复杂度 O（n * m）
 */
public class Solution {

    public int[][] transpose(int[][] A) {
        // 转置新老矩阵的行和列
        // 新矩阵的列数
        int columnLength = A.length;
        // 新矩阵的行数
        int rowLength = A[0].length;
        //创建转置矩阵
        int[][] transpose = new int[rowLength][columnLength];
        for (int j = 0; j < rowLength; j++) {
            for (int i = 0; i < columnLength; i++) {
                transpose[j][i] = A[i][j];
            }
        }

        return transpose;
    }
}
