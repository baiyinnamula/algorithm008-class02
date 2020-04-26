package fizzBuzz412;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangbaiyinnamula
 * 412. Fizz Buzz
 * 解题思路：使用两个计数器，分别记录数到了3的倍数还是5的倍数，这样不用每次进行取模计算
 * 时间复杂度：O(N)
 * 空间复杂度：O(1)
 */
public class Solution1 {
    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<String>(n);
        for (int i = 1, fizz = 0, buzz = 0; i <= n; i++) {
            fizz++;
            buzz++;
            if (fizz == 3 && buzz == 5) {
                ret.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            } else if (fizz == 3) {
                ret.add("Fizz");
                fizz = 0;
            } else if (buzz == 5) {
                ret.add("Buzz");
                buzz = 0;
            } else {
                ret.add(String.valueOf(i));
            }
        }
        return ret;
    }
}
