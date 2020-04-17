package sortedSquares977;

import java.util.Arrays;

/**
 * @author yangbaiyinnamula
 *
 * 解题思路：排序
 * 977. 有序数组的平方
 * 时间复杂度：O（n logn）
 * 空间复杂度：O(n)
 */
public class Solution {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] squares = new int[len];
        for (int i = 0; i < len; i++) {
            squares[i] = A[i] * A[i];
        }

        Arrays.sort(squares);

        return squares;
    }
}
