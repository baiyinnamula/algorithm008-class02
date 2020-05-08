package myPow50;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 解题思路：使用快速幂
 * 时间复杂度O(logN)
 * 空间复杂度O(logN)
 */
public class Solution1 {
    @Test
    public void test1() {
        Assertions.assertEquals(0.25, myPow(2.00000, -2));
    }

    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1.00;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
