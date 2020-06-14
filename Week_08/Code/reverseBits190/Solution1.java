package reverseBits190;

/**
 * 解题思路：位运算
 * 时间复杂度：O(1)
 * 空间复杂度：O(1)
 */
public class Solution1 {
    public int reverseBits(int n) {
        //反转后的数字
        int reverse = 0;
        //反转次数
        int count = 0;
        //总共反转32次（0~31）
        while (count < 32) {
            //左移一位腾出位置
            reverse <<= 1;
            //把 n 的最后一位加到 reverse 中
            reverse |= (n & 1);
            // n 往右移一位去掉已经处理过的最低位
            n >>= 1;
            count++;
        }

        return reverse;
    }
}
