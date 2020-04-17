package sortedSquares977;

/**
 * @author yangbaiyinnamula
 * 解题思想：双指针，分而治之思想
 * 由于原数组时已经排序好的，所有每个元素平方组成的数组其实是由一个降序数组和一个升序数组组成。
 * 所以可以分成2个升序数组来处理，也就变成了把两个升序数组合并问题。
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution1 {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] squares = new int[len];
        //用于遍历非负元素
        int j = 0;
        //用于遍历新数组
        int k = 0;
        while (j < len && A[j] < 0) {
            j++;
        }
        //用于遍历负元素
        int i = j - 1;
        //合并两个数组交叉部分
        while (i >= 0 && j < len) {
            if (A[i] * A[i] < A[j] * A[j]) {
                squares[k++] = A[i] * A[i];
                i--;
            } else {
                squares[k++] = A[j] * A[j];
                j++;
            }
        }
        //合并负元素平方组成的数组剩余部分
        while (i >= 0) {
            squares[k++] = A[i] * A[i];
            i--;
        }
        //合并非负元素平方组成的数组剩余部分
        while (j < len) {
            squares[k++] = A[j] * A[j];
            j++;
        }
        return squares;
    }
}
