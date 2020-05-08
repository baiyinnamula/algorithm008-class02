package numOfBurgers1276;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangbaiyinnamula
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution1 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ans = new ArrayList<Integer>();
        //巨无霸汉堡,也是巨无霸汉堡需要的奶酪数量
        int jumbo = 0;
        //小皇堡,也是小皇堡需要的奶酪数量
        int small = 0;
        //巨无霸汉堡需要的番茄数量
        int jumboTomatoSlices = 0;
        //小皇堡需要的番茄数量
        int smallTomatoSlices = 0;
        for (; jumbo <= cheeseSlices; jumbo++) {
            small = cheeseSlices - jumbo;
            jumboTomatoSlices = 4 * jumbo;
            smallTomatoSlices = small * 2;
            if (jumboTomatoSlices + smallTomatoSlices == tomatoSlices) {
                ans.add(jumbo);
                ans.add(small);

                return ans;
            }
        }

        return ans;
    }
}
