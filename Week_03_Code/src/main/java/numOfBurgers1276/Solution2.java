package numOfBurgers1276;

import java.util.ArrayList;
import java.util.List;

/**
 * 假设巨无霸汉堡xx个，小皇堡yy个，那么可得二元一次方程如下：
 * 4x + 2y = tomatoSlices4x+2y=tomatoSlices
 * x + y = cheeseSlicesx+y=cheeseSlices
 * <p>
 * 求解方程可得：
 * x = tomatoSlices / 2 - cheeseSlices
 * y = cheeseSlices - x
 * <p>
 * 因此，在x和y必须是非负整数的前提下，从上面x和y的解可发现以下几个规律：
 * <p>
 * tomatoSlices 必须是偶数；
 * tomatoSlices / 2 - cheeseSlices 必须 >= 0
 * cheeseSlices − x 必须 >= 0
 * <p>
 * 作者：yuruiyin
 * 链接：https://leetcode-cn.com/problems/number-of-burgers-with-no-waste-of-ingredients/solution/jie-er-yuan-yi-ci-fang-cheng-by-npe_tle/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 时间复杂度：O(1)
 * 空间复杂度：O(1)
 */
public class Solution2 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ans = new ArrayList<>();
        //tomatoSlices 必须是偶数
        if ((tomatoSlices & 1) == 1) {
            return ans;
        }
        //巨无霸汉堡个数 x 必须大于等于0
        int x = tomatoSlices / 2 - cheeseSlices;
        //小皇堡个数 x 必须大于等于0
        int y = cheeseSlices - x;

        if (x >= 0 && y >= 0) {
            ans.add(x);
            ans.add(y);
        }

        return ans;
    }
}
