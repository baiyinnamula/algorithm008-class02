package week01.plusOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yangbaiyinnamula
 * @date 2020-04-14
 */

public class Solution {
    @Test
    public void test1() {
        int[] digits = {5, 2, 0, 0, 4, 6, 2, 4, 9};
        int[] expected = {5, 2, 0, 0, 4, 6, 2, 5, 0};
        digits = plusOne(digits);
        Assertions.assertArrayEquals(digits, expected);
    }

    public int[] plusOne(int[] digits) {
        //获取数组长度
        int len = digits.length;
        //如果只有一个元素，并且值小于9,则直接加1后返回。
        if (digits[len - 1] < 9) {
            digits[len - 1] += 1;
            return digits;
        } else {
            //记录是否当前元素是否需要加1：1表示加1，0表示不加1
            int temp = 1;
            //冲数组的最高位开始循环
            for (int i = len - 1; i >= 0; i--) {
                if (temp == 1) {
                    //如果加1 后不小于10,则不需要进阶
                    if (digits[i] + temp < 10) {
                        digits[i] += temp;
                        temp = 0;
                        //否则需要进阶
                    } else {
                        digits[i] = digits[i] - 9;
                        temp = 1;
                    }
                }
            }
            //判断元数组最高位是否还需要进阶，如果需要进阶，则新建一个比原数组多一位的数组
            if (temp == 1) {
                int[] result = new int[len + 1];
                for (int j = 0; j < len; j++) {
                    result[j + 1] = digits[j];
                }
                result[0] = temp;

                return result;
            }
            return digits;
        }

    }
}
