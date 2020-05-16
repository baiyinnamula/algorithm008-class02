package levelOrder102;

import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路：深度优先搜索
 * 时间复杂度：O(N)
 * 空间复杂度：O(N)
 *
 */
public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        dfs(1, root, ans);
        return ans;
    }

    private void dfs(int index, TreeNode root, List<List<Integer>> ans) {
        if (ans.size() < index) {
            ans.add(new ArrayList<Integer>());
        }
        ans.get(index - 1).add(root.val);
        if (root.left != null) {
            dfs(index + 1, root.left, ans);
        }
        if (root.right != null) {
            dfs(index + 1, root.right, ans);
        }
    }
}
