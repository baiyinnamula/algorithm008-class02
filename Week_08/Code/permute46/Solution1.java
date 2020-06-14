package permute46;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return ans;
        }
        boolean[] used = new boolean[nums.length];
        List<Integer> path = new ArrayList<>(nums.length);
        dfs(nums, path, used);

        return ans;
    }

    private void dfs(int[] nums, List<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                dfs(nums, path, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
