package subsets78;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> subsets(int[] nums) {
        //先建立一个包括空子集合的输出集合
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<Integer>());
        //遍历原集合
        for (int num : nums) {
            //创建包含当前 num 值的所有集合
            List<List<Integer>> subSets = new ArrayList<>();
            for (List<Integer> current : output) {
                List<Integer> currentAddNum = new ArrayList<>(current);
                currentAddNum.add(num);
                subSets.add(currentAddNum);
            }
            for (List<Integer> current : subSets) {
                output.add(current);
            }
        }

        return output;
    }
}
