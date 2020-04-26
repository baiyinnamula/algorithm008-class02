package addDigits258;

/**
 * https://en.wikipedia.org/wiki/Digital_root#Congruence_formula
 * For base b (decimal case b = 10), the digit root of an integer is:
 *
 * dr(n) = 0 if n == 0
 * dr(n) = (b-1) if n != 0 and n % (b-1) == 0
 * dr(n) = n mod (b-1) if n % (b-1) != 0
 * or
 * dr(n) = 1 + (n - 1) % (b - 1)
 * 这个其实是个数学问题
 *
 */
public class Solution {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        } else {
            if (num % (10 - 1) == 0) {
                return 10 - 1;
            } else {
                return num % (10 - 1);
            }
        }
    }
}
